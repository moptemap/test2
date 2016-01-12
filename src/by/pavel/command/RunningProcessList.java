package by.pavel.command;

import java.io.IOException;

public class RunningProcessList extends AbstractCommand {

    private static final String UNIX_COM = "ps -few";
    private static final String[] WINDOWS_COM = {"cmd", "/c", "tasklist.exe /fi \"STATUS eq running\""};

    @Override
    public void runCommand(String... args) throws IOException {
        if(args != null) {
            printProcessListWithFilterName(args);
        } else {
            printListFromOSCommand(WINDOWS_COM, UNIX_COM);
        }
    }


    private void printProcessListWithFilterName(String... names) {

    }
}
