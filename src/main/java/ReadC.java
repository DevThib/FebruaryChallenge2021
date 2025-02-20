import Admin.Admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadC extends Command{
    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        if (args.length > 1) {
            File file = new File(path + "/" + args[1]);
            if (file.exists()) {
                if(file.isDirectory()) {
                    System.out.println("rc -> list");
                    args = new String[]{"list"};
                    CommandsEnum.LIST.execute(args, command, path, app, admin);
                }else {
                    try {
                        Scanner sc = new Scanner(file);
                        System.out.println("Warning ! Most of file types aren't read correctly");
                        Thread.sleep(1000);
                        while (sc.hasNextLine()) {
                            System.out.println(sc.nextLine());
                        }
                    } catch (FileNotFoundException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            System.out.println("Arg 1 is empty");
        }
    }
}
