import Admin.Admin;

import java.io.File;

public class ReadHelp extends CommandFileEdit {

    @Override
    public void execute(String[] args, String command, File file, FileEditApp app, Admin admin) {
        System.out.println("Use << to read a lign");
    }
}
