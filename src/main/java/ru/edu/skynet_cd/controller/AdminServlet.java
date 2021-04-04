package ru.edu.skynet_cd.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.edu.skynet_cd.dao.PositionDAOImpl;
import ru.edu.skynet_cd.dao.UserDAO;
import ru.edu.skynet_cd.dao.UserDAOImpl;
import ru.edu.skynet_cd.domain.Position;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAOImpl();
    
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
        
        String add = request.getParameter("add");   
        String exit = request.getParameter("exit");   
        String updateUser = (String)request.getParameter("update_user");
        String deleteUser = (String)request.getParameter("delete_user");
        
        List<Position> positions= new PositionDAOImpl().getAll();
        
        if (add != null) {
            User u = new User("","","","");
            request.setAttribute("user", u);
            request.setAttribute("positions", positions);
            request.getRequestDispatcher("/add_user_page/add_user.jsp").forward(request, response); 
        }
        
        if (exit != null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response); 
        }        
        
        if (updateUser != null) {            
            System.out.println(updateUser);    
            User user = (User)userDAO.getById(Long.parseLong(updateUser));            
            System.out.println("AdminServlet обновление по ID" + user);
            request.setAttribute("user", user);
            request.setAttribute("positions", positions);
            request.getRequestDispatcher("/update_user_page/update_user.jsp").forward(request, response);
        }        
        if (deleteUser != null) {            
            userDAO.delete(Long.parseLong(deleteUser));             
            request.setAttribute("users", userDAO.getAll());
            request.getRequestDispatcher("/admin_page/admin_page.jsp").forward(request, response); 
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
