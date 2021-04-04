package ru.edu.skynet_cd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.edu.skynet_cd.config.Config;

public class ConnectionBuilder {
/**
 * 
 * @return
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(Config.getProperty(Config.SQL_DRIVER)).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }
}
