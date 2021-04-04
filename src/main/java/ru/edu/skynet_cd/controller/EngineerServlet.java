package ru.edu.skynet_cd.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.edu.skynet_cd.dao.MaterialDAO;
import ru.edu.skynet_cd.dao.MaterialDAOImpl;
import ru.edu.skynet_cd.dao.ReportDAO;
import ru.edu.skynet_cd.dao.ReportDAOImpl;
import ru.edu.skynet_cd.dao.TaskDAO;
import ru.edu.skynet_cd.dao.TaskDAOImpl;
import ru.edu.skynet_cd.dao.UserDAO;
import ru.edu.skynet_cd.dao.UserDAOImpl;
import ru.edu.skynet_cd.domain.Material;
import ru.edu.skynet_cd.domain.Report;
import ru.edu.skynet_cd.domain.Task;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "EngineerServlet", urlPatterns = {"/EngineerServlet"})
public class EngineerServlet extends HttpServlet {
    
    private final UserDAO<User> uDAO = new UserDAOImpl();
    private final MaterialDAO mDAO = new MaterialDAOImpl();
    private final ReportDAO<Report> rDAO = new ReportDAOImpl();
    private final TaskDAO tDAO = new TaskDAOImpl();
   
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
        //HttpSession session = request.getSession();
        String add = request.getParameter("add");
        String exit = request.getParameter("exit");
        String view = request.getParameter("view");
        String report = request.getParameter("report");
        String delete = request.getParameter("delete");
        
        System.out.println(exit);
               
        if (add != null) {
            /*
                1-Администратор
                2-Инженер
                3-Бригадир
                4-Кладовщик
            */
            List<User> executors = new UserDAOImpl().getByPosition(3);
            request.setAttribute("executors", executors);
            request.getRequestDispatcher("/task_page/task_page.jsp").forward(request, response); 
        }        
        if (exit != null) {            
            request.getRequestDispatcher("/index.jsp").forward(request, response); 
        }
        if (view != null) {
            long taskId = Long.parseLong(view);
            Task task = tDAO.getTask(taskId);
            User user = uDAO.getById(task.getExecutor());
            List<Material> mats = mDAO.getByTaskId(task.getIdTask());
            request.setAttribute("executor", user);
            request.setAttribute("mats", mats);
            request.setAttribute("task", task);
            request.getRequestDispatcher("/task_page/view_task.jsp").forward(request, response); 
        }
        if (report != null) {
            long taskId = Long.parseLong(report);
            Task task = tDAO.getTask(taskId);
            User user = uDAO.getById(task.getExecutor());
            Report reportTask = rDAO.ReportGetByTaskId(taskId);            
            request.setAttribute("reportTask", reportTask);
            request.setAttribute("executor", user);
            request.setAttribute("task", task);
            request.getRequestDispatcher("/report_page/view_report_page.jsp").forward(request, response); 
        }
        if (delete != null) {
            long taskId = Long.parseLong(delete); 
            tDAO.delete(taskId);
            request.setAttribute("tasks", tDAO.getAll());            
            request.getRequestDispatcher("/engineer_page/engineer_page.jsp").forward(request, response); 
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
