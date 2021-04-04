package ru.edu.skynet_cd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.edu.skynet_cd.config.Queries;
import ru.edu.skynet_cd.domain.Position;
import ru.edu.skynet_cd.domain.User;

public class UserDAOImpl implements UserDAO<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public Long insert(User user) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.INSERT_USER);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getSecondName());
            stmt.setString(3, user.getPatronymic());
            stmt.setLong(4, user.getPosition().getId());
            stmt.setString(5, user.getLogin());
            stmt.setString(6, user.getPwd());
            result = (long)stmt.executeUpdate(); 
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @Override
    public Long update(User user) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.UPDATE_USER);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getSecondName());
            stmt.setString(3, user.getPatronymic());
            stmt.setLong(4, user.getPosition().getId());
            stmt.setString(5, user.getLogin());
            stmt.setString(6, user.getPwd());
            stmt.setLong(7, user.getIdUser());
            stmt.executeUpdate(); 
            result = user.getIdUser();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @Override
    public Long delete(long id) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.DELETE_USER);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            result = id;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @Override
    public User getById(long id) {
        User u = new User();
        String sql = Queries.getQueries(Queries.GET_BY_ID_USER);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, id);
            ResultSet rSet = stmt.executeQuery();            
            if (rSet.next()) {
                u.setIdUser(rSet.getLong("id_user"));
                u.setFirstName(rSet.getString("first_name"));
                u.setSecondName(rSet.getString("second_name"));
                u.setPatronymic(rSet.getString("patronymic"));
                PositionDAO<Position> pos = new PositionDAOImpl(); 
                u.setPosition(pos.getById(rSet.getLong("id_position")));
                u.setLogin(rSet.getString("login"));
                u.setPwd(rSet.getString("password"));
            }            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    @Override
    public List<User> getAll() {
        List<User> resultList = new ArrayList();
        String sql = Queries.getQueries(Queries.GET_ALL_USERS);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rSet = stmt.executeQuery();) {
            while (rSet.next()) {
                User u = new User();
                u.setIdUser(rSet.getLong("id_user"));
                u.setFirstName(rSet.getString("first_name"));
                u.setSecondName(rSet.getString("second_name"));
                u.setPatronymic(rSet.getString("patronymic"));
                PositionDAO<Position> pos = new PositionDAOImpl(); 
                u.setPosition(pos.getById(rSet.getLong("id_position")));
                u.setLogin(rSet.getString("login"));
                u.setPwd(rSet.getString("password"));
                resultList.add(u);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    @Override
    public List<User> getByPosition(long positionId) {
        List<User> executorsList = new ArrayList();
        String sql = Queries.getQueries(Queries.GET_BY_USER_POSITION);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, positionId);
            ResultSet rSet = stmt.executeQuery();            
            while(rSet.next()) {
                User u = new User();
                u.setIdUser(rSet.getLong("id_user"));
                u.setFirstName(rSet.getString("first_name"));
                u.setSecondName(rSet.getString("second_name"));
                u.setPatronymic(rSet.getString("patronymic"));
                PositionDAO<Position> pos = new PositionDAOImpl(); 
                u.setPosition(pos.getById(rSet.getLong("id_position")));
                u.setLogin(rSet.getString("login"));
                u.setPwd(rSet.getString("password"));
                executorsList.add(u);
            }            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executorsList;
    }
}
