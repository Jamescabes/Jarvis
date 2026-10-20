import g4f
import asyncio

async def find_provider():
    providers = [
        g4f.Provider.Blackbox,
        g4f.Provider.Liaobots,
        g4f.Provider.You,
        g4f.Provider.Airforce,
        g4f.Provider.DeepInfra,
    ]
    
    for provider in providers:
        print(f"Testing {provider.__name__}...")
        try:
            response = await g4f.ChatCompletion.create_async(
                model=g4f.models.gpt_4o,
                messages=[{"role": "user", "content": "Hello"}],
                provider=provider
            )
            print(f"✅ {provider.__name__} works: {response[:50]}...")
            return provider.__name__
        except Exception as e:
            print(f"❌ {provider.__name__} failed: {e}")
    
    return None

asyncio.run(find_provider())
