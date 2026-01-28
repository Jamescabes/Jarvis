import asyncio
import json
from app.core.engine import JarvisCore

async def interactive_test():
    print("🤖 JARVIS INTERACTIVE TEST (Orchestrator Mode)")
    print("---------------------------------------------")
    jarvis = JarvisCore()
    
    # Simulación de un WebSocket local para pruebas
    class MockWebSocket:
        async def receive_text(self):
            user_input = input("\n👤 Tu: ")
            if user_input.lower() in ["exit", "salir"]:
                raise Exception("Test Finished")
            return json.dumps({"type": "text", "content": user_input})
        
        async def send_text(self, data):
            try:
                packet = json.loads(data)
                print(f"🤖 Jarvis: {packet.get('text')}")
            except json.JSONDecodeError:
                print(f"🤖 Jarvis: {data}")

    print("\n(Escribe 'salir' para finalizar)")
    try:
        await jarvis.handle_connection(MockWebSocket())
    except Exception as e:
        if str(e) != "Test Finished":
            print(f"\n❌ Error: {e}")
        print("\n✅ Prueba finalizada.")

if __name__ == "__main__":
    try:
        asyncio.run(interactive_test())
    except KeyboardInterrupt:
        pass
