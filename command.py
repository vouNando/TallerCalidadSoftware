from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

    @abstractmethod
    def undo(self):
        pass

class MusicPlayer:
    def play(self):
        print("Reproduciendo música")

    def stop(self):
        print("Música detenida")

class PlayMusicCommand(Command):
    def __init__(self, player):
        self.player = player
    
    def execute(self):
        self.player.play()
    
    def undo(self):
        self.player.stop()

class StopMusicCommand(Command):
    def __init__(self, player):
        self.player = player
    
    def execute(self):
        self.player.stop()
    
    def undo(self):
        self.player.play()

class RemoteControl:
    def __init__(self):
        self.commands = []
    
    def add_command(self, command):
        print("Comando agregado: " + command.__class__.__name__)
        self.commands.append(command)

    def execute_commands(self):
        print("Ejecutando comandos...")
        for command in self.commands:
            command.execute()
    
    def undo_last_command(self):
        if self.commands:
            print("Deshaciendo el último comando...")
            self.commands.pop().undo()
    
    def undo_all_commands(self):
        print("Deshaciendo todos los comandos...")
        while self.commands:
            self.commands.pop().undo()

# Ejemplo de uso
player = MusicPlayer()
remote_control = RemoteControl()

play_music_command = PlayMusicCommand(player)
stop_music_command = StopMusicCommand(player)

remote_control.add_command(play_music_command)
remote_control.add_command(stop_music_command)
remote_control.add_command(play_music_command)

remote_control.execute_commands()
remote_control.undo_last_command()
remote_control.undo_all_commands()
