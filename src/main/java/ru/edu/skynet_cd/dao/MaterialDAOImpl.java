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
import ru.edu.skynet_cd.domain.Material;

public class MaterialDAOImpl implements MaterialDAO<Material>{

    private static final Logger logger = LoggerFactory.getLogger(MaterialDAOImpl.class);
    /**
     * Receiving list materials to task by id.
     * @param taskId
     * @return list material to task by id
     */
    @Override
    public List<Material> getByTaskId(long taskId) {
        List<Material> resultList = new ArrayList();
        String sql = Queries.getQueries(Queries.GET_BY_TASK_ID_MATERIALS);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setLong(1, taskId);
            try (ResultSet rSet = stmt.executeQuery()) {
                while (rSet.next()) {
                    Material mat = new Material();
                    mat.setId(rSet.getLong("id_material"));
                    mat.setNameMaterial(rSet.getString("material_name"));
                    mat.setIssued(rSet.getInt("material_issued"));
                    mat.setReceived(rSet.getInt("material_received"));
                    mat.setIdTask(rSet.getLong("id_task"));
                    resultList.add(mat);
                }
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    MaterialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaterialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }
    
    /**
     * Adds list materials in database to task by id.
     * @param taskId
     * @param listMaterials
     * @return number of inserted rows
     */
    @Override
    public int insertList(long taskId, List<Material> listMaterials) {
        int result = 0;
        String sql = Queries.getQueries(Queries.INSERT_MATERIALS);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {            
            conn.setAutoCommit(false);
            try{
                for (Material list : listMaterials) {
                    stmt.setString(1, list.getNameMaterial());
                    stmt.setInt(2, list.getIssued());
                    stmt.setInt(3, list.getReceived());
                    stmt.setLong(4, taskId);
                    stmt.executeUpdate();
                    result++;
                }
            }catch(SQLException ex){
                conn.rollback();
                throw ex;
            }
            conn.commit();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    MaterialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaterialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * Delete materials issued to task by id.
     * @param taskId
     * @return number of deleted rows
     */
    @Override
    public int deleteMaterials(long taskId) {
        int result = 0;
        String sql = Queries.getQueries(Queries.DELETE_MATERIALS);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, taskId);
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    MaterialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaterialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
