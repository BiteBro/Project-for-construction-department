package ru.edu.skynet_cd.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import ru.edu.skynet_cd.domain.TaskStatusEnum;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "TaskServlet", urlPatterns = {"/TaskServlet"})
public class TaskServlet extends HttpServlet {
    
    private final TaskDAO<Task> tDAO = new TaskDAOImpl();
    private final UserDAO<User> uDAO = new UserDAOImpl();
    private final MaterialDAO<Material> mDAO = new MaterialDAOImpl();

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
        
        String create = request.getParameter("create");
        String back = request.getParameter("back");
        List<Material> mats = new ArrayList();
        
        if (create != null) {
            String address = request.getParameter("address");
            String executor= request.getParameter("executor");
            String[] matsNames = request.getParameterValues("mats_name");
            String[] issue = request.getParameterValues("issue");
            String[] recive = request.getParameterValues("recive");
            for (int i = 0; i<matsNames.length; i++) {
                if (!matsNames[i].isEmpty()) {
                    Material material = new Material();
                    material.setNameMaterial(matsNames[i]);
                    material.setIssued(Integer.parseInt(issue[i]));
                    material.setReceived(Integer.parseInt(recive[i]));
                    mats.add(material);
                } 
            }            
            System.out.println(mats);
            System.out.println(executor);
            Task task = new Task();
            List<User> users = uDAO.getByPosition(3);//костыль
            task.setAddress(address);
            for (User user : users) {
                if (user.getFullName().equals(executor)) {
                    System.out.println("Problem");
                    task.setExecutor(user.getIdUser());
                }
            }
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            task.setCreator(user.getIdUser());
            task.setTaskStatus(TaskStatusEnum.GETTING);
            System.out.println(task);
            long idTask = tDAO.insert(task);
            mDAO.insertList(idTask, mats);
            request.setAttribute("tasks", tDAO.getAll());            
            request.getRequestDispatcher("/engineer_page/engineer_page.jsp").forward(request, response);
        }
        if (back != null) {
            HttpSession session = request.getSession();
            request.setAttribute("tasks", session.getAttribute("tasks"));            
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
