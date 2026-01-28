from fastapi import WebSocket
import json
from app.memory.manager import MemoryManager
from app.actions.executor import ActionExecutor

class JarvisCore:
    def __init__(self):
        print("🧠 Core Layer Initialized")
        self.memory = MemoryManager()
        self.action = ActionExecutor()
        # TODO: Initialize LLM Service

    async def handle_connection(self, websocket: WebSocket):
        try:
            while True:
                data = await websocket.receive_text()
                print(f"📩 Received: {data}")
                
                # 1. Save to Memory (User)
                # self.memory.add_interaction(data, "") 

                # 2. Mock Decision (If starts with '/', it's a command)
                if data.startswith("/"):
                    response_text = f"Executing command: {data}"
                    result = self.action.execute_command(data[1:])
                    response_text += f"\nResult: {result}"
                else:
                    response_text = f"I heard you: {data}"
                
                # 3. Save to Memory (System)
                self.memory.add_interaction(data, response_text)

                response = {
                    "type": "text",
                    "content": response_text,
                    "files": []
                }
                
                await websocket.send_text(json.dumps(response))
        except Exception as e:
            print(f"Connection closed: {e}")
