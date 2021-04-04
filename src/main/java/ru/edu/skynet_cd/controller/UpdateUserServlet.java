package ru.edu.skynet_cd.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.edu.skynet_cd.dao.PositionDAO;
import ru.edu.skynet_cd.dao.PositionDAOImpl;
import ru.edu.skynet_cd.dao.UserDAO;
import ru.edu.skynet_cd.dao.UserDAOImpl;
import ru.edu.skynet_cd.domain.Position;
import ru.edu.skynet_cd.domain.User;

@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
    
    private final UserDAO<User> uDAO = new UserDAOImpl();
    private final PositionDAO<Position> pDAO = new PositionDAOImpl();
    
    private Position getPosition(String posName, PositionDAO pDAO){         
        List<Position> positionList = pDAO.getAll();
        for (Position pos : positionList) {
            if (pos.getName().equals(posName)) {
                return pos;
            }
        }       
        return null;
    }    
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
        String back = request.getParameter("back");
        long id_user = Long.parseLong(request.getParameter("id_user"));
        String first = request.getParameter("first_name");
        String second = request.getParameter("second_name");
        String patronymic = request.getParameter("patronymic");
        String position = request.getParameter("position");
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        String pwdRepeat = request.getParameter("repeat_pass"); 
        
        Position userPosition = getPosition(position, pDAO);
        List<Position> positionList = pDAO.getAll();
        List<User> userList = uDAO.getAll();
        User newUser;
        newUser = new User(first,second,patronymic,userPosition,login,pwd);
        newUser.setIdUser(id_user);
        System.out.println(newUser);
        if (add != null) {    
            if (pwd.equals(pwdRepeat)&&(!pwd.isEmpty()&&!pwdRepeat.isEmpty())) {
                if (!first.isEmpty()&&!second.isEmpty()&&!patronymic.isEmpty()&&
                        !position.isEmpty()&&!login.isEmpty()) {
                    if (userList.contains(newUser)) {
                        request.setAttribute("users", userList);
                        request.getRequestDispatcher("/admin_page/admin_page.jsp").forward(request, response);                           
                    }else{                       
                        uDAO.update(newUser);                                          
                        request.setAttribute("users", uDAO.getAll());
                        request.getRequestDispatcher("/admin_page/admin_page.jsp").forward(request, response);
                    }
                }else{     
                    request.setAttribute("user", newUser);
                    request.setAttribute("positions", positionList);
                request.getRequestDispatcher("/update_user_page/update_user.jsp").forward(request, response);}
            }else if(!pwd.equals(pwdRepeat)){
                request.setAttribute("user", newUser);
                request.setAttribute("positions", positionList);
                request.getRequestDispatcher("/update_user_page/update_user.jsp").forward(request, response); 
            }else{
                request.setAttribute("user", newUser);
                request.setAttribute("positions", positionList);
                request.getRequestDispatcher("/update_user_page/update_user.jsp").forward(request, response);
            }
        }
        if (back != null){
            request.setAttribute("users", userList);
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
