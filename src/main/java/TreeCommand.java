import Admin.Admin;

import java.io.File;

public class TreeCommand extends Command{
    @Override
    public void execute(String[] args, String command, String path, MainApp app, Admin admin) {
        if (args.length > 1) {
            if (args.length > 2) {
                sendDirectorySizeAndTree(path, 0);
            }else {
                sendDirectorySize(path, 0);
            }
        }else {
            sendTree(path, 0);
        }

    }

    private static void sendTree(String path, int n) {
        File f = new File(path);
        String[] list = f.list();
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tab.append("\t");
        }
        if (list != null) {
            for (String str : list) {
                File file = new File(path + "/" + str);
                if (file.isDirectory()) {
                    System.out.println(tab + "+ " + str);
                    sendTree(path + "/" + str, n + 1);
                }else {
                    System.out.println(tab + "- " + str);
                }
            }
        }
    }

    private static long sendDirectorySize(String path, int n) {
        File f = new File(path);
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tab.append("\t");
        }
        long answer = 0;
        String[] list = f.list();
        if (list != null) {
            for (String str : list) {
                File file = new File(path + "/" + str);
                if (file.isDirectory()) {
                    long temp = sendDirectorySize(path + "/" + str, n + 1);
                    System.out.println(tab + "+ " + str + " + " + temp + " byte(s)");
                    answer += temp;
                } else {
                    long temp = file.length();
                    System.out.println(tab + "- " + str + " - " + temp + " byte(s)");
                    answer += temp;
                }
            }
        }
        return answer;
    }

    private static long getDirectorySize(File f) {
        long answer = 0;
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    answer += getDirectorySize(file);
                }else {
                    answer += file.length();
                }
            }
        }
        return answer;
    }

    private static void sendDirectorySizeAndTree(String path, int n) {
        File f = new File(path);
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tab.append("\t");
        }
        String[] list = f.list();
        if (list != null) {
            for (String str : list) {
                File file = new File(path + "/" + str);
                if (file.isDirectory()) {
                    System.out.println(tab + "+ " + str + " + " + getDirectorySize(file) + " byte(s)");
                    sendDirectorySizeAndTree(path + "/" + str, n + 1);
                } else {
                    long temp = file.length();
                    System.out.println(tab + "- " + str + " - " + temp + " byte(s)");
                }
            }
        }
    }
}
