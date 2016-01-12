package by.pavel.command;

import by.pavel.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractCommand {

    public abstract void runCommand() throws IOException;

    protected void printListFromOSCommand(String[] windowsCom, String unixCom) throws IOException {
        String line;

        Process p = null;
        BufferedReader br = null;

        if(Config.getInstance().isWindowsOS()) {
            p = Runtime.getRuntime().exec(windowsCom);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "cp866"));
        } else {
            p = Runtime.getRuntime().exec(unixCom);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        }

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
