import random

class PersonalityEngine:
    def __init__(self):
        self.system_name = "Jarvis"
        self.user_name = "Sir" # Default, could be configurable
        
    def get_response(self, text: str) -> str:
        text = text.lower()
        
        # 1. Greetings
        if any(w in text for w in ["hola", "hello", "hi", "hey"]):
            return random.choice([
                f"At your service, {self.user_name}.",
                "Online and ready.",
                f"Hello, {self.user_name}. How can I assist you today?"
            ])
            
        # 2. Status / Identity
        if any(w in text for w in ["status", "estado", "how are you", "que tal"]):
            return "All systems nominal. Battery power at optimum levels."
            
        if "who are you" in text or "quien eres" in text:
            return "I am Jarvis, a virtual artificial intelligence developed to assist you."

        # 3. Gratitude
        if "gracias" in text or "thanks" in text:
            return random.choice([
                "My pleasure, Sir.",
                "You are welcome.",
                "Anytime."
            ])
            
        # 4. Unknown / Generic (Iron Man Style)
        return random.choice([
            "I am processing your request... requires more data.",
            "I didn't quite catch that, Sir.",
            "My protocols are limited in this offline mode. Please connect my neural net (LLM API).",
            "Could you rephrase that? I'm calibrating my auditory sensors."
        ])
