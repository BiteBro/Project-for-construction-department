package ru.edu.skynet_cd.config;

import java.io.InputStream;
import java.util.Properties;

public class Queries {
    
    public static final String GET_ALL_POSITION = "GET_ALL_POSITION";
    public static final String GET_BY_ID_POSITION = "GET_BY_ID_POSITION";
    public static final String UPDATE_POSITION = "UPDATE_POSITION";
    public static final String DELETE_POSITION = "DELETE_POSITION";
    public static final String INSERT_POSITION = "INSERT_POSITION";
   
    public static final String GET_ALL_USERS = "GET_ALL_USERS";
    public static final String GET_BY_ID_USER = "GET_BY_ID_USER";
    public static final String DELETE_USER = "DELETE_USER";
    public static final String UPDATE_USER = "UPDATE_USER"; 
    public static final String INSERT_USER = "INSERT_USER";     
    public static final String GET_BY_USER_POSITION = "GET_BY_USER_POSITION";     

    public static final String GET_BY_TASK_ID_MATERIALS = "GET_BY_TASK_ID_MATERIALS";    
    public static final String DELETE_MATERIALS = "DELETE_BY_TASK_ID_MATERIALS";         
    public static final String INSERT_MATERIALS = "INSERT_MATERIALS";
    
    public static final String INSERT_REPORT = "INSERT_REPORT"; 
    public static final String GET_BY_TASK_ID_REPORT = "GET_BY_TASK_ID_REPORT";
    public static final String UPDATE_REPORT = "UPDATE_REPORT"; 
    public static final String DELETE_REPORT = "DELETE_REPORT";
  
    public static final String INSERT_TASK = "INSERT_TASK";     
    public static final String UPDATE_TASK = "UPDATE_TASK";
    public static final String UPDATE_TASK_STATUS = "UPDATE_TASK_STATUS";
    public static final String DELETE_TASK = "DELETE_TASK";
    public static final String GET_TASK = "GET_TASK";
    public static final String GET_ALL_TASK = "GET_ALL_TASK";
    public static final String GET_ALL_TASK_TO_EXECUTOR = "GET_ALL_TASK_TO_EXECUTOR";
    
    private static Properties queriesProp = new Properties();
    
    /**
     * Get query from proterty file
     * @param name
     * @return String query
     */
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
