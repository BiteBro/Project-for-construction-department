/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.edu.skynet_cd.config;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author ralew
 */
public class Queries {
    public static final String GET_ALL_POSITION = "GET_ALL_POSITION";
    public static final String GET_ByID_POSITION = "GET_ByID_POSITION";
    public static final String UPDATE_POSITION = "UPDATE_POSITION";
    public static final String DELETE_POSITION = "DELETE_POSITION";
    public static final String INSERT_POSITION = "INSERT_POSITION";
    
    private static Properties queriesProp = new Properties();
    
    public synchronized static String getQueries(String name) {
        if (queriesProp.isEmpty()) {
            try (InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("sql_queries.properties")) {
                queriesProp.load(is);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return queriesProp.getProperty(name);
    }
}
