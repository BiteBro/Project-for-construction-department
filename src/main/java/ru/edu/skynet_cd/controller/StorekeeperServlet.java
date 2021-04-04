package ru.edu.skynet_cd.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.edu.skynet_cd.dao.MaterialDAO;
import ru.edu.skynet_cd.dao.MaterialDAOImpl;
import ru.edu.skynet_cd.dao.TaskDAO;
import ru.edu.skynet_cd.dao.TaskDAOImpl;
import ru.edu.skynet_cd.dao.UserDAO;
import ru.edu.skynet_cd.dao.UserDAOImpl;
import ru.edu.skynet_cd.domain.Material;
import ru.edu.skynet_cd.domain.Task;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "StorekeeperServlet", urlPatterns = {"/StorekeeperServlet"})
public class StorekeeperServlet extends HttpServlet {
    
    private final UserDAO<User> uDAO = new UserDAOImpl();
    private final MaterialDAO mDAO = new MaterialDAOImpl();
    private final TaskDAO<Task> tDAO = new TaskDAOImpl();
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
        
        String view = request.getParameter("view"); 
        String exit = request.getParameter("exit"); 
        
        if (view != null) {
            long taskId = Long.parseLong(view);
            Task task = tDAO.getTask(taskId);
            User user = uDAO.getById(task.getExecutor());
            System.out.println(user);
            List<Material> mats = mDAO.getByTaskId(task.getIdTask());
            request.setAttribute("executor", user);
            request.setAttribute("mats", mats);
            request.setAttribute("task", task);
            request.getRequestDispatcher("/task_page/view_task.jsp").forward(request, response); 
        }        
        if (exit != null) {
            HttpSession ses = request.getSession();
            ses.removeAttribute("user");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
