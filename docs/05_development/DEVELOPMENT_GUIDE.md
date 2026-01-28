# Guía de Desarrollo (Development Guide)

## Estilo de Código

- **Python**: Seguir PEP 8. Usar Type Hints esturos.
- **Kotlin**: Seguir la guía de estilo oficial de Android/Kotlin.

## Convenciones de Commits

Usar Conventional Commits:

- `feat: nueva funcionalidad de voz`
- `fix: crash al iniciar sesión`
- `docs: actualizados diagramas`
- `style: formateo de código`

## Cómo añadir nuevas acciones (Tools)

1. Ir a `jarvis-backend/app/actions`.
2. Crear nueva función Python decorada.
3. Añadir docstring detallado (el LLM usa esto para saber cuándo llamarla).
4. Registrar la herramienta en el `ToolRegistry`.

## Testing

- **Backend`:`pytest`.
- **Android**: `JUnit` + `Espresso`.
