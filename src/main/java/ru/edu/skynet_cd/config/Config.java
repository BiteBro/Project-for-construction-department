package ru.edu.skynet_cd.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "MYSQL_DB_URL";
    public static final String DB_LOGIN = "LOGIN_DB";
    public static final String DB_PASSWORD = "PASSWORD_DB";
    //private static final String SQL_DRIVER = "SQL_DRIVER";
    //public static final String DB_LIMIT = "db.limit";
    //public static final String CR_URL = "cr.url";
    
    private static Properties properties = new Properties();
    
    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            try (InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("connectDB.properties")) {
                properties.load(is);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return properties.getProperty(name);
    }
}
