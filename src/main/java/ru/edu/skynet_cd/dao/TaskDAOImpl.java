package ru.edu.skynet_cd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.edu.skynet_cd.config.Queries;
import ru.edu.skynet_cd.domain.Task;
import ru.edu.skynet_cd.domain.TaskStatusEnum;

public class TaskDAOImpl implements TaskDAO<Task>{

    @Override
    public Long insert(Task task) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.INSERT_TASK);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, task.getAddress());
            stmt.setLong(2, task.getExecutor());
            stmt.setLong(3, task.getCreator());
            stmt.setString(4, task.getTaskStatus().toString());
            stmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                        
            long rownum = stmt.executeUpdate();
            if (rownum == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                result = generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Long delete(long id) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.DELETE_TASK);
        try (Connection conn = ConnectionBuilder.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setLong(1, id);
            stmt.executeUpdate();
            result = id;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Long update(Task task) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.UPDATE_TASK);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, task.getAddress());
            stmt.setLong(2, task.getExecutor());
            stmt.setLong(3, task.getCreator());
            stmt.setString(4, task.getTaskStatus().toString());            
            stmt.setLong(5, task.getIdTask());
            
            result = (long)stmt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Task> getAll() {
        String sql = Queries.getQueries(Queries.GET_ALL_TASK);
        List<Task> resultList = new ArrayList();
        try(Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rSet = stmt.executeQuery();){
            while (rSet.next()) {            
            Task task = new Task(rSet.getString("task_address"),
                                 rSet.getLong("id_user_executor_task"),
                                 rSet.getLong("id_user_creator_task"),
                                 TaskStatusEnum.valueOf(rSet.getString("task_status")),
                                 rSet.getDate("task_date").toLocalDate());
            task.setIdTask(rSet.getLong("id_task"));
            resultList.add(task);
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    @Override
    public List<Task> getAllToExecutor(long idExecutor) {
        String sql = Queries.getQueries(Queries.GET_ALL_TASK_TO_EXECUTOR);
        List<Task> resultList = new ArrayList();
        try(Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setLong(1, idExecutor);
                    ResultSet rSet = stmt.executeQuery();
            while (rSet.next()) {            
            Task task = new Task(rSet.getString("task_address"),
                                 rSet.getLong("id_user_executor_task"),
                                 rSet.getLong("id_user_creator_task"),
                                 TaskStatusEnum.valueOf(rSet.getString("task_status")),
                                 rSet.getDate("task_date").toLocalDate());
            task.setIdTask(rSet.getLong("id_task"));
            resultList.add(task);
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    @Override
    public Task getTask(long id) {
        String sql = Queries.getQueries(Queries.GET_TASK);
        Task task = new Task();
        try(Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setLong(1, id);
                ResultSet rSet = stmt.executeQuery();
            if (rSet.next()) {            
            task = new Task(rSet.getString("task_address"),
                                 rSet.getLong("id_user_executor_task"),
                                 rSet.getLong("id_user_creator_task"),
                                 TaskStatusEnum.valueOf(rSet.getString("task_status")),
                                 rSet.getDate("task_date").toLocalDate());  
            task.setIdTask(rSet.getLong("id_task"));
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return task;
    }

    @Override
    public Long updateStatus(Task task) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.UPDATE_TASK_STATUS);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {            
            stmt.setString(1, task.getTaskStatus().toString());            
            stmt.setLong(2, task.getIdTask());            
            result = (long)stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(
                    TaskDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
