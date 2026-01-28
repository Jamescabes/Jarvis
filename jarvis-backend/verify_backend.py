import asyncio
import websockets
import json

async def test_jarvis():
    uri = "ws://localhost:8000/ws"
    print(f"Connecting to {uri}...")
    try:
        async with websockets.connect(uri) as websocket:
            print("✅ Connected to JARVIS Backend")
            
            # Test 1: Chat interaction
            msg = "Hello JARVIS"
            print(f"📤 Sending: {msg}")
            await websocket.send(msg)
            
            response = await websocket.recv()
            print(f"📩 Received: {response}")
            
            data = json.loads(response)
            if data["content"].startswith("I heard you"):
                print("✅ Core Logic Verified")
            else:
                print("❌ Core Logic Unexpected Response")

            # Test 2: Command interaction
            cmd = "/echo testing"
            print(f"📤 Sending Command: {cmd}")
            await websocket.send(cmd)
            response = await websocket.recv()
            print(f"📩 Received: {response}")
            if "Executing command" in json.loads(response)["content"]:
                 print("✅ Action Layer Verified")
            else:
                 print("❌ Action Layer Failed")

    except Exception as e:
        print(f"❌ Connection Failed: {e}")

if __name__ == "__main__":
    asyncio.run(test_jarvis())
