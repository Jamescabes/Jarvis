# Documentación del Backend

## Stack Tecnológico

- **Lenguaje**: Python 3.10+
- **Framework Web**: FastAPI
- **Servidor**: Uvicorn (ASGI)
- **Gestión de Paquetes**: Pip / Requirements.txt

## APIs y Endpoints

- `GET /`: Health check.
- `WS /ws`: Endpoint principal para conexión WebSocket bidireccional.

## WebSockets

El corazón de la comunicación en tiempo real.

- **Protocolo**: JSON sobre WebSocket.
- **Estructura de Mensaje**:

  ```json
  {
    "type": "TEXT" | "ACTION" | "ERROR",
    "payload": "..."
  }
  ```

## Autenticación

(Pendiente de implementación)

- Previsto: JWT (JSON Web Tokens).
- Flujo: Login -> Token devuelto -> Token enviado en header "Authorization" al conectar WebSocket.
