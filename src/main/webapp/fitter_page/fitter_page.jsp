
<%@page import="ru.edu.skynet_cd.domain.Report"%>
<%@page import="ru.edu.skynet_cd.dao.ReportDAOImpl"%>
<%@page import="ru.edu.skynet_cd.dao.ReportDAO"%>
<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page import="ru.edu.skynet_cd.dao.UserDAOImpl"%>
<%@page import="ru.edu.skynet_cd.domain.Task"%>
<%@page import="java.util.List"%>
<%@page import="ru.edu.skynet_cd.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Отдел строительства SN</title>
	<link rel="stylesheet" href="fitter_page/css/fitter_style.css">
</head>
    <body>	
        <h1>Монтажник</h1>	
        <form method="post" action="FitterServlet" class="login">
            <button class='button' type="submit" name="exit" value="">Выход</button>
            <div class="container">
                <%                
                    List<Task> tasks = (List)request.getAttribute("tasks");
                    HttpSession sess = request.getSession();
                    User user = (User)sess.getAttribute("user");
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
                            <th>Отчет</th>							       
                        </tr>
                    </thead>
        <%for (Task tsk : tasks) {                
        %>
        <tbody>
            <tr>	        
                <td><%= count++ %></td>
                <td><%= tsk.getTaskDate()%></td>
                <td><%= tsk.getAddress()%></td>                                            
                <td><%= user.getFullName()%></td> 
                <td><%= tsk.getTaskStatus().getStatus()%></td>
                <td><button class='button' type="submit" name="task" value="<%=tsk.getIdTask()%>">Смотреть</button></td>
                <td><button class='button' type="submit" name="report" value="<%=tsk.getIdTask()%>">Смотреть</button></td>
            </tr>	
        </tbody>
        <%}%>
                </table>
		</div>
            </div>
        </form>	
    </body>
</html>
