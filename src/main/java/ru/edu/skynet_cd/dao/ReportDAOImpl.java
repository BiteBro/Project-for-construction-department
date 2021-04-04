package ru.edu.skynet_cd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.edu.skynet_cd.config.Queries;
import ru.edu.skynet_cd.domain.Report;

public class ReportDAOImpl implements ReportDAO<Report> {
    
private static final Logger logger = LoggerFactory.getLogger(ReportDAOImpl.class);
    
    @Override
    public Long insertReport(long task_id, Report report) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.INSERT_REPORT);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setString(1, report.getReportAddress());
                stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                stmt.setInt(3, report.getTotalApartments());
                stmt.setString(4, report.getBoxPosition());
                stmt.setString(5, report.getPointEnergy());
                stmt.setString(6, report.getNote());   
                stmt.setLong(7, task_id);
                stmt.executeUpdate(); 
                result = report.getIdTask();            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
        return result;
    }
    
    @Override
    public Long updateReport(long task_id, Report report) {
        Long result = -1L;
        String sql = Queries.getQueries(Queries.UPDATE_REPORT);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                //stmt.setLong(1,report.getId());
                stmt.setString(1, report.getReportAddress());
                stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                stmt.setInt(3, report.getTotalApartments());
                stmt.setString(4, report.getBoxPosition());
                stmt.setString(5, report.getPointEnergy());
                stmt.setString(6, report.getNote());   
                stmt.setLong(7, task_id);
                stmt.executeUpdate(); 
                result = report.getIdTask();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
        return result;
    }

    @Override
    public Report ReportGetByTaskId(long taskId) {
        Report rep = new Report(); 
        String sql = Queries.getQueries(Queries.GET_BY_TASK_ID_REPORT);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setLong(1, taskId);
                ResultSet rSet = stmt.executeQuery(); 
            if (rSet.next()) {                                
                rep.setId(rSet.getLong("id_report"));
                rep.setReportAddress(rSet.getString("report_address"));
                rep.setReportDate(rSet.getDate("report_date").toLocalDate());
                rep.setTotalApartments(rSet.getInt("report_apartment_quantity"));
                rep.setBoxPosition(rSet.getString("report_box_position"));
                rep.setPointEnergy(rSet.getString("report_point_energy"));
                rep.setNote(rSet.getString("report_note"));
                rep.setIdTask(rSet.getLong("id_task"));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rep;
    }

    @Override
    public int deleteReport(long task_id) {
        int result = -1;
        String sql = Queries.getQueries(Queries.DELETE_REPORT);
        try (Connection conn = ConnectionBuilder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setLong(1, task_id);
                result = stmt.executeUpdate(); 
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(
                    ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(ReportDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
        return result;
    }

}
