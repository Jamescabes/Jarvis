# Guía de Pruebas: JARVIS System

Esta guía detalla los pasos para realizar una prueba integral del sistema JARVIS, desde el backend hasta la aplicación Android.

## Requisitos Previos

- **Python 3.10+** instalado.
- **Android Studio** instalado.
- Dispositivo Android físico o Emulador configurado.

---

## 1. Preparación del Backend

El backend actúa como el "Cerebro" y Orquestador del sistema.

1. **Navega al directorio del backend:**

    ```bash
    cd jarvis-backend
    ```

2. **Instala las dependencias:**

    ```bash
    pip install -r requirements.txt
    ```

3. **Configura el entorno:**
    Crea o edita el archivo `.env`. Si no tienes una `OPENAI_API_KEY`, el sistema entrará automáticamente en **Modo Gratuito**.
4. **Inicia el servidor:**

    ```bash
    python main.py
    ```

    *Verás un mensaje indicando que el Orquestador está en línea en `http://0.0.0.0:8000`.*

---

## 2. Preparación de la App Android

1. **Abre el proyecto:**
    Inicia Android Studio y abre la carpeta `jarvis-android`.
2. **Sincroniza Gradle:**
    Espera a que Android Studio termine de descargar las dependencias.
3. **Configura la IP del Backend:**
    Abre el archivo `app/src/main/java/com/jarvis/client/data/repository/ChatRepository.kt`.
    - **Emulador:** No requiere cambios (usa `10.0.2.2`).
    - **Dispositivo Físico:** Cambia `10.0.2.2` por tu dirección IP local (ej. `192.168.1.133`).
4. **Ejecuta la App:**
    Haz clic en el botón "Run" (Play) en la parte superior.

---

## 3. Flujo de Prueba Recomendado

Para validar la arquitectura de Jarvis, sigue estos pasos:

1. **Inicio de Conexión:**
    Al abrir la app, deberías ver en la terminal del backend: `📩 Input Received [text]: ...` (o un log de conexión WebSocket).
2. **El Primer Saludo:**
    Escribe: *"Hola Jarvis, ¿estás en línea?"*
    - **Respuesta esperada:** Jarvis debería responder manteniendo su personalidad (ej: *"En línea y a su servicio, Sir"*).
3. **Verificación del Modo Gratuito:**
    Si no usas API Key, observa el log del backend. Verás cómo intenta conectar con los "Relés de Emergencia" (PollinationsAI, ApiAirforce, etc.).
4. **Prueba de Memoria:**
    Pregúntale algo, espera un momento y luego dile: *"¿Qué fue lo último que te pregunté?"*
    - Esto valida que el `MemoryManager` está funcionando correctamente.

---

## Solución de Problemas

- **Error de Conexión:** Verifica que tu PC y el móvil estén en la misma red Wi-Fi. Asegúrate de que el firewall de Windows permita conexiones en el puerto 8000.
- **Sin respuesta de la IA:** Si ves el error `429` en la terminal del backend, espera 10 segundos. Es el límite de los proveedores gratuitos.
- **Logs Técnicos:** Si el backend muestra `har_and_cookies dir not readable`, asegúrate de que la carpeta `har_and_cookies` existe en `jarvis-backend/`.

---
*Diseñado para la excelencia. – J.A.R.V.I.S.*
