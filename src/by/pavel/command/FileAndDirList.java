package by.pavel.command;

import java.io.IOException;

public class FileAndDirList extends AbstractCommand {

    private static final String UNIX_COM = "ls -laX";
    private static final String[] WINDOWS_COM = {"cmd", "/c", "dir /a /o"};

    @Override
    public void runCommand(String... args) throws IOException {
        printListFromOSCommand(WINDOWS_COM, UNIX_COM);
    }
}
