package ru.edu.skynet_cd.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.edu.skynet_cd.access.AccessCheck;
import ru.edu.skynet_cd.dao.TaskDAO;
import ru.edu.skynet_cd.dao.TaskDAOImpl;
import ru.edu.skynet_cd.dao.UserDAO;
import ru.edu.skynet_cd.dao.UserDAOImpl;
import ru.edu.skynet_cd.domain.Task;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
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
        
        User user = null;
        int idPosition = -1;
        String login = (String)request.getParameter("login");
        String pwd = (String)request.getParameter("pwd");       
        
        if (login.isEmpty() || pwd.isEmpty()) {     
            request.getRequestDispatcher("/index.jsp").forward(request, response);          
        } else{              
            user = AccessCheck.check(login, pwd); 
            if (user != null) {
                idPosition = (int)user.getPosition().getId();
            }            
        }               
        if(idPosition != -1){                 
            switch (idPosition){
            case 1:   // id position administrator = 1               
                HttpSession adminSession = request.getSession();
                adminSession.setAttribute("user", user);
                UserDAO users = new UserDAOImpl();
                List<User> userList = users.getAll();                
                request.setAttribute("users", userList);
                request.getRequestDispatcher("/admin_page/admin_page.jsp").forward(request, response); 
                break;
            case 2: // id position engineer = 2   
                HttpSession engiSession = request.getSession();
                TaskDAO tasks = new TaskDAOImpl();
                List<Task> taskList = tasks.getAll();
                engiSession.setAttribute("tasks", taskList);
                engiSession.setAttribute("user", user);                
                request.setAttribute("tasks", taskList);
                request.getRequestDispatcher("/engineer_page/engineer_page.jsp").forward(request, response); 
                break;
            case 3: // id position fitter = 3
                HttpSession fitterSession = request.getSession();
                TaskDAO tasksFitter = new TaskDAOImpl();
                List<Task> taskFitterList = tasksFitter.getAllToExecutor(user.getIdUser());                
                fitterSession.setAttribute("user", user);
                fitterSession.setAttribute("tasks", taskFitterList);
                request.setAttribute("tasks", taskFitterList);
                request.getRequestDispatcher("/fitter_page/fitter_page.jsp").forward(request, response); 
                break;                
            case 4: // id position storekeeper = 4
                HttpSession kepperSession = request.getSession();
                TaskDAO tasksKepper = new TaskDAOImpl();
                List<Task> taskKepperList = tasksKepper.getAll();
                kepperSession.setAttribute("user", user);
                request.setAttribute("tasks", taskKepperList);
                request.getRequestDispatcher("/storekeeper_page/storekeeper_page.jsp").forward(request, response); 
                break;            
            default: 
                 request.getRequestDispatcher("/index.jsp").forward(request, response);                        
                 break;
        } 
            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response); } 
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
