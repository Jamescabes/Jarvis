# JARVIS

> **Tu Asistente Personal de Próxima Generación**

![Jarvis Icon](jarvis-android/app/src/main/res/drawable/ic_launcher_foreground.png)

## ¿Qué es JARVIS?

JARVIS es una plataforma de asistencia personal inteligente que unifica tu vida digital y física. Combina una aplicación móvil Android de diseño premium con un backend potente capaz de procesamiento en tiempo real.

## ¿Qué NO es?

No es otro chatbot genérico. No es una simple interfaz para ChatGPT. Es un sistema integrado con identidad propia, memoria y capacidad de acción.

## Principales Características (MVP)

- **Interfaz "Iron Man"**: Diseño minimalista futurista con el Núcleo Arc.
- **Chat en Tiempo Real**: Comunicación instantánea vía WebSockets.
- **Arquitectura Escalable**: Backend en Python/FastAPI listo para crecer.
- **Identidad Definida**: Distinción clara entre usuario e IA.

## ¿Cómo empezar?

Si quieres probar el sistema completo ahora mismo, consulta nuestra:
👉 **[Guía de Pruebas e Instalación (TESTING.md)](TESTING.md)**

## Estado Actual

- **Móvil**: App Android nativa (Kotlin/Compose) funcional con interfaz Arc Core.
- **Backend**: Orquestador de 4 capas (Brain, Ear, Voice, Eye) operativo en Python.
- **IA**: Soporte para OpenAI (Premium) y Fallback Gratuito mediante relés redundantes.
- **Versión**: 0.2.0 (Deep Refactor)

## Stack

| Parte | Tecnologías |
|---|---|
| App Android | Kotlin, Jetpack Compose, Hilt (inyección de dependencias), arquitectura MVVM (Model-View-ViewModel), WebSockets |
| Backend | Python, FastAPI, Uvicorn, WebSockets, Pydantic |
| IA | OpenAI y Anthropic como proveedores principales, g4f como alternativa gratuita |

## Estructura

```
jarvis-android/        App Android (cliente)
jarvis-backend/
  app/core/            Capas Brain, Ear, Voice, Eye y personalidad
  app/orchestrator/    Servidor FastAPI y endpoint WebSocket /ws
  app/memory/          Historial de sesión persistente
  app/actions/         Ejecución de acciones en el sistema
  scripts/             Pruebas manuales (ejecutar con python -m scripts.<nombre> desde jarvis-backend/)
docs/                  Arquitectura, producto, seguridad y roadmap
```

## Documentación

- [Arquitectura del Sistema](docs/02_architecture/ARCHITECTURE.md)
- [Flujo de Datos](docs/02_architecture/DATA_FLOW.md)
- [Visión del Proyecto](docs/01_overview/PROJECT_OVERVIEW.md)
- [Roadmap](docs/07_business/ROADMAP.md)

## Evolución

La versión siguiente, con agente de PC, memoria vectorial y arquitectura distribuida, está en desarrollo en un repositorio aparte (Jarvis-V2).
