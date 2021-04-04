package ru.edu.skynet_cd.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import ru.edu.skynet_cd.config.Queries;
import ru.edu.skynet_cd.dao.ConnectionBuilder;
import ru.edu.skynet_cd.dao.PositionDAOImpl;
import ru.edu.skynet_cd.domain.User;

public class AccessCheck {   

    /** 
     * Checking user, contained in data base or not.
     * 
     * @param login
     * @param pwd
     * @return User
     */
    public static User check(String login, String pwd) {        
        String sql = Queries.getQueries(Queries.GET_ALL_USERS);
        //System.out.println(sql);
        try (Connection conn = ConnectionBuilder.getConnection()){            
            System.out.println("Connection to Store DB succesfull!");  
                Statement statement = conn.createStatement();                 
                ResultSet resultSet = statement.executeQuery(sql);  //"SELECT * FROM user"              
                while(resultSet.next()){
                    String lgn = resultSet.getString("login");
                    String pass = resultSet.getString("password");
                    if (lgn.equals(login)) {
                        if (pass.equals(pwd)) {
                            User user = new User();
                            user.setIdUser(resultSet.getLong("id_user"));
                            user.setFirstName(resultSet.getString("first_name"));
                            user.setSecondName(resultSet.getString("second_name"));
                            user.setPatronymic(resultSet.getString("patronymic"));
                            user.setPosition(new PositionDAOImpl().getById(resultSet.getLong("id_position")));
                            user.setLogin(lgn);
                            user.setPwd(pass);
                            return user;                            
                        }
                    }
                }
            }                
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }        
        return null;
    }
}
