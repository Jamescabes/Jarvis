from app.core.llm import JarvisBrain
import asyncio

async def test_brain():
    print("🧪 Testing Jarvis Brain (Async/Puter Mode)...")
    brain = JarvisBrain()
    
    user_input = "Hello Jarvis, explain your new modular architecture in one short sentence."
    print(f"👤 User: {user_input}")
    
    history = [{"role": "user", "content": user_input}]
    
    thought = await brain.think(history)
    
    if thought["type"] == "text":
        print(f"🤖 Jarvis: {thought['content']}")
        print("\n✅ TEST RESULT: Brain is responding via PuterGenAI!")
    elif thought["type"] == "error":
        print(f"❌ Error: {thought['content']}")
    else:
        print(f"🔧 Tool Call: {thought}")

if __name__ == "__main__":
    asyncio.run(test_brain())
