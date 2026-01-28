# Sistema de Memoria (Memory System)

## Tipos de Memoria

### 1. Memoria de Sesión (Short-Term)

- **Alcance**: La conversación actual.
- **Almacenamiento**: En memoria RAM (lista Python) o Redis temporal.
- **Uso**: Mantener el hilo de la conversación ("¿Quién es él?" refiriéndose al sujeto de la frase anterior).

### 2. Memoria Semántica/Episódica (Long-Term)

- **Alcance**: Permanente entre sesiones.
- **Almacenamiento**: Base de datos vectorial (ChromaDB / Pinecone) + SQL.
- **Uso**: Recordar preferencias ("No me gusta el sushi"), hechos sobre el usuario ("Mi perro se llama Max").

## Política de Privacidad de Memoria

- El usuario puede pedir "Olvida todo lo de hoy" o "Borra mi dirección".
- Datos sensibles (contraseñas, tarjetas) **NUNCA** se guardan en la memoria a largo plazo, solo se usan en el momento de la ejecución y se descartan.
