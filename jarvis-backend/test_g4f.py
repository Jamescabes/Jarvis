import g4f
import asyncio

async def test():
    print("Testing g4f...")
    try:
        response = await g4f.ChatCompletion.create_async(
            model=g4f.models.gpt_4o,
            messages=[{"role": "user", "content": "Say 'Jarvis Online'"}]
        )
        print(f"Response: {response}")
    except Exception as e:
        print(f"Error: {e}")

asyncio.run(test())
