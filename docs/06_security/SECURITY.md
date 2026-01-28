# Protocolos de Seguridad (Security)

## Modelo de Confianza

Jarvis opera bajo un modelo de "Confianza Cero" para acciones externas.

- El LLM es considerado una entidad "no confiable" para la ejecución directa de código.
- Todo comando debe pasar por el **Action Layer**, que actúa como firewall lógico.

## Niveles de Permisos

1. **Read-Only**: Buscar datos, leer clima. (Sin confirmación).
2. **User-Level Write**: Agendar citas, poner alarmas. (Confirmación implícita/suave).
3. **Critical Write**: Borrar datos, transacciones financieras. (Confirmación explícita + Autenticación biométrica).

## Sandbox

Las herramientas complejas (e.g., análisis de datos con Python) se ejecutan en contenedores efímeros sin acceso a red externa (salvo whitelist) ni al sistema de archivos del host.

## Logs y Auditoría

- Cada acción crítica deja un rastro inmutable.
- Los logs de seguridad no pueden ser borrados por el propio Jarvis.
