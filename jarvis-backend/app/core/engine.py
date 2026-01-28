from fastapi import WebSocket
import json
from app.memory.manager import MemoryManager
from app.actions.executor import ActionExecutor
from app.core.brain import BrainModule
from app.core.ear import EarModule
from app.core.voice import VoiceModule
from app.core.eye import EyeModule

class JarvisCore:
    """The Orchestrator. 
    Maintains the illusion of a single mind by coordinating specialized sub-modules.
    """
    def __init__(self):
        print("🤖 JARVIS Orchestrator Initialized")
        self.memory = MemoryManager()
        self.action_layer = ActionExecutor()
        
        # The 4 Layers of Intelligence
        self.brain = BrainModule()
        self.ear = EarModule()
        self.voice = VoiceModule()
        self.eye = EyeModule()

    async def handle_connection(self, websocket: WebSocket):
        try:
            conversation_history = [] 

            while True:
                raw_data = await websocket.receive_text()
                
                # Protocol Compatibility Layer
                try:
                    packet = json.loads(raw_data)
                    input_type = packet.get("type", "text")
                    content = packet.get("content")
                except json.JSONDecodeError:
                    # Fallback for older clients or Android app sending plain text
                    input_type = "text"
                    content = raw_data
                
                print(f"📩 Input Received [{input_type}]: {content[:50]}...")
                
                # 1. Processing Input (Ear/Eye)
                processed_text = ""
                if input_type == "audio":
                    processed_text = self.ear.listen(content)
                elif input_type == "image":
                    visual_description = self.eye.see(content)
                    processed_text = f"[Visual Context: {visual_description}]"
                else:
                    processed_text = content

                # 2. Reasoning (Brain)
                user_msg = {"role": "user", "content": processed_text}
                conversation_history.append(user_msg)
                
                thought = await self.brain.think(conversation_history)
                
                response_text = ""
                if thought["type"] == "text":
                    response_text = thought["content"]
                elif thought.get("type") == "error":
                    response_text = thought["content"]
                elif thought["type"] == "tool_call":
                    response_text = "I am executing your request, Sir." 
                
                # 3. Output Preparation
                if response_text:
                    conversation_history.append({"role": "assistant", "content": response_text})

                # 4. Persistence
                self.memory.add_interaction(processed_text, response_text)

                # 5. Delivery (Android Compatibility: Send plain text if it was a plain text request)
                # To keep it simple and compatible with the current ChatRepository.kt
                await websocket.send_text(response_text)
                
        except Exception as e:
            print(f"Connection closed: {e}")
