package FileEditApp;

public abstract class Command {
    public abstract void execute(String[] args, String command, String path);
}
