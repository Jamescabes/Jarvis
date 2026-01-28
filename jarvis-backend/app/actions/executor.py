import subprocess
import os

class ActionExecutor:
    def __init__(self):
        print(f"⚡ Action Layer Initialized (System: {os.name})")

    def execute_command(self, command: str) -> str:
        """
        Execute a shell command. 
        WARNING: In a real product, this needs strict sandboxing.
        """
        try:
            print(f"Executing: {command}")
            # Identify OS and allow simple commands
            # TODO: Implement safety checks
            
            result = subprocess.run(
                command, 
                shell=True, 
                capture_output=True, 
                text=True,
                check=True
            )
            return result.stdout
        except subprocess.CalledProcessError as e:
            return f"Error: {e.stderr}"
        except Exception as e:
            return f"Execution Failed: {str(e)}"

    def write_file(self, path: str, content: str):
        try:
            with open(path, "w", encoding="utf-8") as f:
                f.write(content)
            return f"File written to {path}"
        except Exception as e:
            return f"File Write Failed: {e}"
