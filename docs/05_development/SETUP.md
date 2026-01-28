# Configuración del Proyecto (Setup)

## Requisitos Previos

- **Python**: 3.10 o superior.
- **Java JDK**: 11 o superior (para Android).
- **Android Studio**: Última versión estable.
- **Git**: Para control de versiones.

## Backend Setup

1. Navegar al directorio: `cd jarvis-backend`.
2. Crear entorno virtual: `python -m venv venv`.
3. Activar entorno: `.\venv\Scripts\Activate` (Windows) o `source venv/bin/activate` (Mac/Linux).
4. Instalar dependencias: `pip install -r requirements.txt`.
5. Configurar variables de entorno:
    - Renombrar `.env.example` a `.env`.
    - Añadir claves API (OpenAI, Anthropic, etc.).
6. Ejecutar: `python main.py`.

## Mobile Setup

1. Abrir `jarvis-android` en Android Studio.
2. Esperar sincronización de Gradle.
3. Crear Emulador (AVD) o conectar dispositivo físico.
4. Run (Shift+F10).

> **Nota**: Si usas emulador, el backend debe estar accesible. Por defecto usamos `10.0.2.2` para localhost desde el emulador.
