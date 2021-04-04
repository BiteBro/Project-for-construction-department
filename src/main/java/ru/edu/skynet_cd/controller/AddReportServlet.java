package ru.edu.skynet_cd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.edu.skynet_cd.dao.ReportDAO;
import ru.edu.skynet_cd.dao.ReportDAOImpl;
import ru.edu.skynet_cd.dao.TaskDAO;
import ru.edu.skynet_cd.dao.TaskDAOImpl;
import ru.edu.skynet_cd.domain.Report;
import ru.edu.skynet_cd.domain.Task;
import ru.edu.skynet_cd.domain.TaskStatusEnum;

@WebServlet(name = "AddReportServlet", urlPatterns = {"/AddReportServlet"})
public class AddReportServlet extends HttpServlet {
    private Report report;
    private Task task;
    private TaskDAO tDAO;
    private ReportDAO rDAO;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
         
        String totalApartments = request.getParameter("apartment_count");
        String boxPosition = request.getParameter("box_position");
        String energyPoint = request.getParameter("point_energy");
        String note = request.getParameter("note");        
        String exit = request.getParameter("exit");
        String save = request.getParameter("save");
        String status = request.getParameter("status");
        
        if (save != null) {  
            rDAO = new ReportDAOImpl();
            tDAO = new TaskDAOImpl();
            long taskId = Long.parseLong(save);
            task = tDAO.getTask(taskId);
            report = new Report();
            report.setReportAddress(task.getAddress());
            report.setTotalApartments(Integer.parseInt(totalApartments));
            report.setBoxPosition(boxPosition);
            report.setPointEnergy(energyPoint);
            report.setNote(note);
            rDAO.insertReport(taskId, report);
            if ("exec".equals(status)) {
                task.setTaskStatus(TaskStatusEnum.COMPLETED);
                tDAO.updateStatus(task);
            }
            if ("cancel".equals(status)) {
                task.setTaskStatus(TaskStatusEnum.CANCELED);
                tDAO.updateStatus(task);
            }            
            session.setAttribute("tasks", tDAO.getAllToExecutor(task.getExecutor()));
            request.setAttribute("tasks", session.getAttribute("tasks"));            
            request.getRequestDispatcher("/fitter_page/fitter_page.jsp").forward(request, response);      
        }        
        if (exit != null) {           
            request.setAttribute("tasks", session.getAttribute("tasks"));            
            request.getRequestDispatcher("/fitter_page/fitter_page.jsp").forward(request, response);      
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
