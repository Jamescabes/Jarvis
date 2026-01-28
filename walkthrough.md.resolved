# JARVIS System Walkthrough

I have successfully initialized the **JARVIS System** with the 5-layer architecture.

## 1. Backend Service (The Brain)
The backend is running on `http://localhost:8000`.
- **Orchestrator**: [app/orchestrator/server.py](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-backend/app/orchestrator/server.py) handles WebSockets.
- **Core**: [app/core/engine.py](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-backend/app/core/engine.py) processes input and routes logic.
- **Action**: [app/actions/executor.py](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-backend/app/actions/executor.py) can execute shell commands.
- **Memory**: [app/memory/manager.py](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-backend/app/memory/manager.py) persists session history.

### Verification Results
Ran [verify_backend.py](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-backend/verify_backend.py):
- ✅ WebSocket Connection
- ✅ Core Logic (Response generation)
- ✅ Action Layer (Command execution)

## 2. Android Client (The Body)
Located in `jarvis-android`.
- **Architecture**: MVVM + Clean Architecture.
- **UI**: Jetpack Compose [ChatScreen.kt](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-android/app/src/main/java/com/jarvis/client/ui/ChatScreen.kt) for messaging.
- **Network**: [ChatRepository.kt](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-android/app/src/main/java/com/jarvis/client/data/repository/ChatRepository.kt) manages WebSocket connection.
- **DI**: Hilt setup in `JarvisApp.kt` (stub) and [MainActivity.kt](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-android/app/src/main/java/com/jarvis/client/MainActivity.kt).

## How to Run locally
1. **Backend**:
    ```powershell
    cd jarvis-backend
    python main.py
    ```
2. **Android**:
    - Open `jarvis-android` in Android Studio.
    - Sync Gradle.
    - Run on Emulator. Note: `ws://10.0.2.2:8000/ws` is configured for Emulator -> Localhost access.

## Next Steps
- Implement Audio recording/streaming on Android.
- Connect LLM API (OpenAI/Anthropic) in [app/core/engine.py](file:///c:/Users/javie/OneDrive/Documentos/Proyectos/jarvis-backend/app/core/engine.py).
