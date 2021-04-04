package ru.edu.skynet_cd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.edu.skynet_cd.dao.TaskDAO;
import ru.edu.skynet_cd.dao.TaskDAOImpl;
import ru.edu.skynet_cd.domain.Task;
import ru.edu.skynet_cd.domain.TaskStatusEnum;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "ViewTaskServlet", urlPatterns = {"/ViewTaskServlet"})
public class ViewTaskServlet extends HttpServlet {
    
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
        HttpSession session = request.getSession();
        String back = request.getParameter("back");
        String issue = request.getParameter("issue");
        String recive = request.getParameter("recive");
        
        if (recive != null) {
            Task task = tDAO.getTask(Long.parseLong(recive));
            task.setTaskStatus(TaskStatusEnum.PROGRESS);
            tDAO.updateStatus(task);
            User u = (User)session.getAttribute("user");
            request.setAttribute("tasks", tDAO.getAllToExecutor(u.getIdUser()));
            request.getRequestDispatcher("/fitter_page/fitter_page.jsp").forward(request, response);
        }
        if (issue != null) {
            Task task = tDAO.getTask(Long.parseLong(issue));
            task.setTaskStatus(TaskStatusEnum.ISSUED);
            tDAO.updateStatus(task);
            request.setAttribute("tasks", tDAO.getAll());
            request.getRequestDispatcher("/storekeeper_page/storekeeper_page.jsp").forward(request, response);
        }        
        if (back != null) {
            User u = (User)session.getAttribute("user");
            request.setAttribute("tasks", session.getAttribute("tasks"));
            switch((int)u.getPosition().getId()){
                case 2 :   
                    request.setAttribute("tasks", tDAO.getAll());
                    request.getRequestDispatcher("/engineer_page/engineer_page.jsp").forward(request, response);
                    break;
                case 3 :
                    request.setAttribute("tasks", tDAO.getAllToExecutor(u.getIdUser()));
                    request.getRequestDispatcher("/fitter_page/fitter_page.jsp").forward(request, response);
                    break;
                case 4 : 
                    request.setAttribute("tasks", tDAO.getAll());
                    request.getRequestDispatcher("/storekeeper_page/storekeeper_page.jsp").forward(request, response);
                    break;
            }
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
