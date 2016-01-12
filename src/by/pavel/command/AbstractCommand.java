package by.pavel.command;

import by.pavel.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractCommand {

    protected Process p;
    protected BufferedReader br;

    public abstract void runCommand(String... args) throws IOException;

    protected void printListFromOSCommand(String[] windowsCom, String unixCom) throws IOException {
        setProcessAndBufferedReader(Config.getInstance().isWindowsOS(), windowsCom, unixCom);

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    protected void setProcessAndBufferedReader(boolean isWindows, String[] windowsCom, String unixCom)
            throws IOException {
        if(isWindows) {
            p = Runtime.getRuntime().exec(windowsCom);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "cp866"));
        } else {
            p = Runtime.getRuntime().exec(unixCom);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        }
    }
}
