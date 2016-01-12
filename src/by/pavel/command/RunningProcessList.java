package by.pavel.command;

import by.pavel.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningProcessList extends AbstractCommand {

    private static final String UNIX_COM = "ps -few";
    private static final String[] WINDOWS_COM = {"cmd", "/c", "tasklist.exe /nh /fi \"STATUS eq running\""};

    @Override
    public void runCommand(String... args) throws IOException {
        if(args != null) {
            printProcessListWithFilterName(args);
        } else {
            printListFromOSCommand(WINDOWS_COM, UNIX_COM);
        }
    }


    private void printProcessListWithFilterName(String... names) throws IOException {
        String line;

        setProcessAndBufferedReader(Config.getInstance().isWindowsOS(), WINDOWS_COM, UNIX_COM);

        while ((line = br.readLine()) != null) {
            String processName = line.split(" ")[0];
            for(String name : names) {
                if(processName.toLowerCase().indexOf(name.toLowerCase()) > -1) {
                    System.out.println(line);
                    break;
                }
            }
        }

        br.close();
    }
}
