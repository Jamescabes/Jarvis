import uvicorn
from app.orchestrator.server import app
import os

if __name__ == "__main__":
    # Ensure necessary directories exist
    os.makedirs("data/memory", exist_ok=True)
    os.makedirs("data/uploads", exist_ok=True)
    
    print("🤖 JARVIS System Initializing...")
    uvicorn.run(app, host="0.0.0.0", port=8000)
