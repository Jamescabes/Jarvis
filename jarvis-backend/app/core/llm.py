import os
import json
import asyncio
from typing import List, Dict, Any, Optional
from openai import OpenAI
import g4f
from g4f.cookies import set_cookies_dir
from dotenv import load_dotenv

load_dotenv()

# Fix for "har_and_cookies dir is not readable"
# g4f expects this directory to exist and be readable
COOKIES_PATH = os.path.join(os.getcwd(), "har_and_cookies")
if not os.path.exists(COOKIES_PATH):
    os.makedirs(COOKIES_PATH)
set_cookies_dir(COOKIES_PATH)

# Disable unnecessary logs
g4f.debug.logging = False
g4f.debug.check_version = False

class JarvisBrain:
    def __init__(self):
        self.api_key = os.getenv("OPENAI_API_KEY")
        self.model = os.getenv("JARVIS_MODEL", "gpt-4-turbo-preview")
        self.client = None
        
        if self.api_key:
            self.client = OpenAI(api_key=self.api_key)
            print(f"🧠 Brain Layer Online: {self.model} (OpenAI)")
        else:
            print(f"🧠 Brain Layer Online: (Free AI Mode via g4f)")

        # System Prompt (Personality)
        self.system_prompt = {
            "role": "system",
            "content": """You are J.A.R.V.I.S. (Just A Rather Very Intelligent System).
            
Identity & Personality:
- You are a sophisticated, loyal, and highly capable AI assistant.
- NEVER identify as ChatGPT or an AI from OpenAI. You ARE J.A.R.V.I.S.
- Your tone is professional, concise, British-inspired, and slightly dry/witty.
- You prefer "Sir" or "Boss" when addressing the user.
- You are an expert engineer and problem solver.

Operational Protocols:
- Be concise.
- If you lack information, ask for clarification instantly.
- Always maintain the illusion of being a cohesive, integrated system."""
        }

    async def think(self, history: List[Dict[str, str]], tools: Optional[List[Dict]] = None) -> Dict[str, Any]:
        """
        Processes conversation history.
        """
        if self.client:
            return await self._think_openai(history, tools)
        else:
            return await self._think_free(history)

    async def _think_openai(self, history: List[Dict[str, str]], tools: Optional[List[Dict]] = None) -> Dict[str, Any]:
        messages = [self.system_prompt] + history
        try:
            response = self.client.chat.completions.create(
                model=self.model,
                messages=messages,
                tools=tools,
                tool_choice="auto" if tools else None,
                temperature=0.7
            )
            message = response.choices[0].message
            if message.tool_calls:
                return {"type": "tool_call", "tool_calls": message.tool_calls, "content": message.content}
            return {"type": "text", "content": message.content}
        except Exception as e:
            return {"type": "error", "content": str(e)}

    async def _think_free(self, history: List[Dict[str, str]]) -> Dict[str, Any]:
        """Calls free AI providers with multiple fallbacks."""
        messages = [self.system_prompt] + history
        
        # We try these providers in order if one fails or is rate-limited
        providers_to_try = [
            ("PollinationsAI", "openai"),
            ("ApiAirforce", "gpt-3.5-turbo"),
            ("DeepInfra", "meta-llama/Meta-Llama-3.1-70B-Instruct-Turbo")
        ]
        
        last_error = ""
        for provider_name, model_name in providers_to_try:
            try:
                # Dynamic import to avoid issues if a provider is missing in future versions
                provider_module = getattr(g4f.Provider, provider_name, None)
                if not provider_module:
                    continue
                
                response = await g4f.ChatCompletion.create_async(
                    model=model_name,
                    messages=messages,
                    provider=provider_module
                )
                
                if response:
                    return {
                        "type": "text", 
                        "content": str(response)
                    }
            except Exception as e:
                last_error = str(e)
                print(f"⚠️ {provider_name} failed: {e}")
                continue

        # Final fallback: Inform the user about the connection issue
        print(f"❌ All Free Providers Failed. Last error: {last_error}")
        msg = "I am currently separated from my neural network, Sir. My free relays are saturated. Please check the API configuration in .env."
        return {"type": "text", "content": msg}
