package ru.edu.skynet_cd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import ru.edu.skynet_cd.domain.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.edu.skynet_cd.config.Queries;

public class PositionDAOImpl implements DAO<Position> {

    private static final String SAVE = "INSERT * FROM skynet_cd.position";
    private static final String DELETE = "SELECT * FROM skynet_cd.position WHERE id_position = ?";
    private static final String UPDATE = "SELECT * FROM skynet_cd.position WHERE id_position = ?";
    private static final String GET_BY_ID = "SELECT * FROM skynet_cd.position WHERE id_position = ?";
    private static final String GET_ALL = "SELECT * FROM skynet_cd.position";
    private static final Logger logger = LoggerFactory.getLogger(PositionDAOImpl.class);

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public Long insert(Position position) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.INSERT_POSITION);
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, position.getName());
            result = (long)stmt.executeUpdate();            
            System.out.println("Insert ID = " + result);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    PositionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }

    @Override
    public Long update(Position position) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.UPDATE_POSITION);
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, position.getName());
            stmt.setLong(2, position.getId());
            stmt.executeUpdate(); 
            result = position.getId();
            System.out.println("Update ID = " + result);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    PositionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
    @Override
    public Long delete(long id) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.DELETE_POSITION);
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            result = id;
            System.out.println("Delete ID = " + result);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    PositionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
    @Override
    public Position getById(long id) {
        Position p = new Position();
        String sql = Queries.getQueries(Queries.GET_ByID_POSITION);
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, id);
            ResultSet rSet = stmt.executeQuery();            
            if (rSet.next()) {
                p.setId(rSet.getLong("id_position"));
                p.setName(rSet.getString("position_name"));
            }            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    PositionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return p;
    }
    @Override
    public List<Position> getAll() {
        List<Position> resultList = new ArrayList();
        String sql = Queries.getQueries(Queries.GET_ALL_POSITION);
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rSet = stmt.executeQuery();) {
            while (rSet.next()) {
                Position pos = new Position(rSet.getString("position_name"));
                resultList.add(pos);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    PositionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

}
