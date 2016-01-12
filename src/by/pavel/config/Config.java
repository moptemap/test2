package by.pavel.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {

    private static final String CONFIG_PATH = "config.xml";
    private static Config instance = new Config();
    private Map<String, String> commands;
    private boolean windowsOS;

    private Config() {
        try {
            setCommands();
            setWindowsOS();
        } catch (Exception e) {
            throw new RuntimeException("Can't read config file", e);
        }
    }

    public static Config getInstance() {
        return instance;
    }

    private void setCommands() throws IOException {
        File file = new File(CONFIG_PATH);
        FileInputStream fis = new FileInputStream(file);
        Properties properties = new Properties();
        properties.loadFromXML(fis);
        fis.close();

        commands = new HashMap<>();
        Enumeration enuKeys = properties.keys();
        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            String value = properties.getProperty(key);
            commands.put(key, value);
        }
    }

    public Map<String, String> getCommands() {
        return commands;
    }

    public boolean isWindowsOS() {
        return windowsOS;
    }

    private void setWindowsOS() {
        String osName = System.getProperty("os.name").toLowerCase();

        if(osName.startsWith("windows")) {
            windowsOS = true;
        } else {
            windowsOS = false;
        }
    }
}
