import asyncio
import json
from app.core.llm import JarvisBrain

async def test_brain():
    print("🧠 Testing Jarvis Brain (Async/Free Mode)...")
    brain = JarvisBrain()
    history = [{"role": "user", "content": "Hello Jarvis, respond with 'Hello Sir' and nothing else."}]
    
    try:
        response = await brain.think(history)
        print(f"🤖 Jarvis: {response.get('content')}")
        if "Sir" in response.get('content'):
            print("✅ Brain is working!")
        else:
            print("❌ Brain response was unexpected.")
    except Exception as e:
        print(f"❌ Test Failed: {e}")

if __name__ == "__main__":
    asyncio.run(test_brain())
