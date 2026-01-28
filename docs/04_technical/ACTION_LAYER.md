# Action Layer (Capa de Acción)

El Action Layer es el módulo encargado de traducir la intención del usuario en cambios tangibles en el mundo real o digital.

## Sandbox y Seguridad

Para evitar ejecuciones maliciosas o accidentales:

1. **Validación de Esquema**: Cada herramienta tiene un esquema JSON estricto.
2. **Lista Blanca**: Solo se pueden ejecutar funciones explícitamente registradas.
3. **Aislamiento**: Las acciones que ejecutan código (e.g., Python REPL) corren en un entorno aislado (Docker container en producción).

## Logging

Toda acción ejecutada se registra con:

- Timestamp
- Usuario
- Acción intentada
- Resultado (Éxito/Fallo)
- Latencia

## Ejemplos de Acciones

- `web_search(query)`: Busca información en internet.
- `send_email(to, subject, body)`: Envía un correo.
- `smart_home_control(device_id, state)`: Controla luces/iot.
