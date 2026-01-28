# Interacciones y UX (UX Interactions)

## Conversación Texto

- **Estilo**: Chat fluido, similar a WhatsApp/Telegram pero más limpio.
- **Feedback**: Indicadores de "Escribiendo..." y "Pensando...".
- **Burbujas**: Uso de color para denotar estado (Azul=Normal, Rojo=Error/Alerta).

## Llamadas / Voz

- **Interfaz**: Pantalla completa con visualización de onda de audio (waveform) reaccionando a la voz del usuario.
- **Latencia**: Respuesta en <500ms para sentirlo natural.

## Errores

- Nunca mostrar stack traces al usuario.
- Mensajes humanos: "Lo siento, no pude conectar con el servidor" en lugar de "Error 500".

## Confirmaciones

- Acciones destructivas requieren UI modal bloqueante o confirmación verbal explícita.
