from fastapi import FastAPI, WebSocket, WebSocketDisconnect
from fastapi.middleware.cors import CORSMiddleware
from app.core.engine import JarvisCore

app = FastAPI(title="JARVIS Backend", description="Orchestrator Layer for JARVIS System")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

core_system = JarvisCore()

@app.get("/")
async def root():
    return {"status": "online", "system": "JARVIS", "version": "0.1.0"}

@app.websocket("/ws")
async def websocket_endpoint(websocket: WebSocket):
    await websocket.accept()
    await core_system.handle_connection(websocket)
