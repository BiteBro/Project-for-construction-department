<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page import="ru.edu.skynet_cd.domain.Task"%>
<%@page import="ru.edu.skynet_cd.dao.UserDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="ru.edu.skynet_cd.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Отдел строительства SN</title>
        <link rel="stylesheet" href="storekeeper_page/css/storekeeper_style.css">
    </head>
    <body>	
        <h1>Склад</h1>	
        <form method="post" action="StorekeeperServlet" class="login">	
            <input type="submit" name="exit" id="action" value ="Выход">
            <div class="container">
                <%
                UserDAO userDAO = new UserDAOImpl();
                List<Task> tasks = (List)request.getAttribute("tasks");
                int count = 1;
                %>
                    <table>
                        <thead>
                            <tr>	        
                                <th>№</th>
                                <th>Дата</th>
                                <th>Адрес</th>
                                <th>Ф.И.О.</th>
                                <th>Статус</th>					
                                <th>Наряд</th>
                            </tr>
                        </thead>
            <%for (Task tsk : tasks) {
            User user = (User)userDAO.getById(tsk.getExecutor());                
            %>
            <tbody>
                <tr>	        
                    <td><%= count++ %></td>
                    <td><%= tsk.getTaskDate()%></td>
                    <td><%= tsk.getAddress()%></td>                                            
                    <td><%= user.getFullName()%></td> 
                    <td><%= tsk.getTaskStatus().getStatus()%></td>
                    <td><button class='button' type="submit" name="view" value="<%= tsk.getIdTask()%>">Просмотреть</button></td>
                </tr>	
            </tbody>
            <%}%>
                    </table>                        
            </div>                        
        </form>	
    </body>
</html>
