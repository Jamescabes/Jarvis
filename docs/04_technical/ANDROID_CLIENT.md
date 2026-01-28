# Cliente Android

## Arquitectura

Patrón **MVVM (Model-View-ViewModel)** siguiendo Clean Architecture.

- **UI Layer**: Jetpack Compose (`ChatScreen`).
- **ViewModel Layer**: `ChatViewModel` (Gestión de estado).
- **Data Layer**:
  - `ChatRepository`: Lógica de negocio y conexión a fuentes de datos.
  - `OkHttpClient`: Cliente WebSocket.

## Estructura de Paquetes

```
com.jarvis.client
├── data
│   ├── model       # Data classes (Message)
│   └── repository  # ChatRepository
├── di              # Inyección de dependencias (Hilt)
└── ui              # Pantallas y ViewModels
```

## Permisos

- `android.permission.INTERNET`: Vital para conexión con Backend.
- `android.permission.RECORD_AUDIO`: (Futuro) Para entrada de voz.

## Comunicación con Backend

Se utiliza la librería **OkHttp** para mantener una conexión WebSocket persistente. Se gestiona la reconexión automática y el manejo de hilos (Background Threads) con **Kotlin Coroutines**.
