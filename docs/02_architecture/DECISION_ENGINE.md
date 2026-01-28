# Motor de Decisión (Decision Engine)

Este documento explica cómo "piensa" Jarvis.

## Ciclo de Razonamiento (CoT - Chain of Thought)

Cada input del usuario pasa por las siguientes fases:

1. **Percepción**: Recepción del texto/audio.
2. **Análisis de Contexto**: Recuperación de memoria de corto plazo (mensajes anteriores) y contexto ambiental (hora, ubicación).
3. **Detección de Intención**: ¿El usuario quiere charlar, preguntar un dato o ejecutar una acción?
4. **Planificación**: Si es una acción compleja, se divide en pasos.
5. **Propuesta de Acciones**: El LLM emite una llamada a herramienta (Tool Call).
6. **Validación**: El sistema verifica si la acción es segura y válida.
7. **Ejecución/Respuesta**: Se ejecuta la acción o se responde al usuario.

## Confirmaciones y Riesgo

Jarvis clasifica las acciones por nivel de riesgo:

- **Bajo Riesgo** (e.g., poner música, decir la hora): Ejecución automática.
- **Medio Riesgo** (e.g., enviar mensaje, crear calendario): Requiere confirmación verbal/visual implícita.
- **Alto Riesgo** (e.g., borrar archivos, transferir dinero, compras): Requiere confirmación explícita "Sí, hazlo".

## Ejemplos Reales

### Caso: "Borra todas mis fotos"

1. **Intención**: DELETE_FILES.
2. **Riesgo**: CRITICAL.
3. **Respuesta**: "Esta acción eliminará permanentemente tus fotos. ¿Estás absolutamente seguro de que quieres proceder? Di 'Confirmar código rojo' para ejecutar."
