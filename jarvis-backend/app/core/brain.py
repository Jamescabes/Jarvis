from app.core.llm import JarvisBrain

class BrainModule:
    """The 'Conscious' part of Jarvis. Reason, Decide, Speak."""
    def __init__(self):
        self.engine = JarvisBrain()
    
    async def think(self, history, vision_context=None):
        # We could inject vision_context into history if provided
        return await self.engine.think(history)
