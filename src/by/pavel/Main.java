package by.pavel;

import by.pavel.command.AbstractCommand;
import by.pavel.config.Config;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String command = null;
        String commandClass = null;

        while(!(command = br.readLine()).equals("exit")) {
            commandClass = Config.getInstance().getCommands().get(command);

            if(commandClass != null) {
                Class clazz = Class.forName(commandClass);

                if(AbstractCommand.class.equals(clazz.getSuperclass())) {
                    AbstractCommand abstractCommand = (AbstractCommand) clazz.newInstance();
                    abstractCommand.runCommand();
                }
            } else {
                System.err.println("Command not found");
            }
        }
    }
}
