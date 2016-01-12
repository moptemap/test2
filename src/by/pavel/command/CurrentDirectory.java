package by.pavel.command;

import java.io.IOException;

public class CurrentDirectory extends AbstractCommand {

    @Override
    public void runCommand(String... args) throws IOException {
        printCurrentDirectory();
    }

    private void printCurrentDirectory() throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
    }
}
