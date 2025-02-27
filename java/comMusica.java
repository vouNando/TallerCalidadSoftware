import java.util.ArrayList;
import java.util.List;

// Interfaz Command
interface Command {
    void execute();
    void undo();
}

// Clase MusicPlayer
class MusicPlayer {
    public void play() {
        System.out.println("Reproduciendo música");
    }
    
    public void stop() {
        System.out.println("Música detenida");
    }
}

// Comando para reproducir música
class PlayMusicCommand implements Command {
    private MusicPlayer player;
    
    public PlayMusicCommand(MusicPlayer player) {
        this.player = player;
    }
    
    @Override
    public void execute() {
        player.play();
    }
    
    @Override
    public void undo() {
        player.stop();
    }
}

// Comando para detener la música
class StopMusicCommand implements Command {
    private MusicPlayer player;
    
    public StopMusicCommand(MusicPlayer player) {
        this.player = player;
    }
    
    @Override
    public void execute() {
        player.stop();
    }
    
    @Override
    public void undo() {
        player.play();
    }
}

// Control remoto que administra comandos
class RemoteControl {
    private List<Command> commands;
    
    public RemoteControl() {
        commands = new ArrayList<>();
    }
    
    public void addCommand(Command command) {
        System.out.println("Comando agregado: " + command.getClass().getSimpleName());
        commands.add(command);
    }
    
    public void executeCommands() {
        System.out.println("Ejecutando comandos...");
        for (Command command : commands) {
            command.execute();
        }
    }
    
    public void undoLastCommand() {
        if (!commands.isEmpty()) {
            System.out.println("Deshaciendo el último comando...");
            Command lastCommand = commands.remove(commands.size() - 1);
            lastCommand.undo();
        }
    }
    
    public void undoAllCommands() {
        System.out.println("Deshaciendo todos los comandos...");
        while (!commands.isEmpty()) {
            Command command = commands.remove(commands.size() - 1);
            command.undo();
        }
    }
}

// Clase principal para ejecutar el ejemplo
public class comMusica {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        RemoteControl remoteControl = new RemoteControl();
        
        Command playMusicCommand = new PlayMusicCommand(player);
        Command stopMusicCommand = new StopMusicCommand(player);
        
        remoteControl.addCommand(playMusicCommand);
        remoteControl.addCommand(stopMusicCommand);
        remoteControl.addCommand(playMusicCommand);
        
        remoteControl.executeCommands();
        remoteControl.undoLastCommand();
        remoteControl.undoAllCommands();
    }
}
