package by.pavel.utils;

public class ParseCommandUtil {

    public static String parseCommand(String userLine) {
        return userLine.split(" ")[0];
    }

    public static String[] parseArgs(String userLine) {
        String[] args = null;
        String[] comWithArgs = userLine.split(" ");

        if(comWithArgs.length > 1) {
            args = new String[comWithArgs.length -1];

            for(int i = 1; i < comWithArgs.length; i++) {
                args[i - 1] = comWithArgs[i];
            }
        }

        return args;
    }
}
