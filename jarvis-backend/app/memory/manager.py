import json
import os
from datetime import datetime

class MemoryManager:
    def __init__(self, storage_path="data/memory"):
        self.storage_path = storage_path
        self.current_session = []
        os.makedirs(storage_path, exist_ok=True)
        print(f"💾 Memory Layer Initialized at {storage_path}")

    def add_interaction(self, user_input: str, system_output: str):
        """Add a turn to the short-term memory."""
        self.current_session.append({
            "timestamp": datetime.now().isoformat(),
            "role": "user",
            "content": user_input
        })
        self.current_session.append({
            "timestamp": datetime.now().isoformat(),
            "role": "assistant",
            "content": system_output
        })
        self._save_session()

    def get_context(self, limit=10):
        """Retrieve recent context for the LLM."""
        return self.current_session[-limit:]

    def _save_session(self):
        """Persist current session to disk (simple JSON for now)."""
        # In a real app, this would use a database or append to a log
        filename = f"{self.storage_path}/current_session.json"
        with open(filename, "w", encoding="utf-8") as f:
            json.dump(self.current_session, f, ensure_ascii=False, indent=2)
