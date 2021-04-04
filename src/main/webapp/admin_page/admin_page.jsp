<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        	<title>Отдел строительства SN</title>
	<link rel="stylesheet" href="admin_page/css/admin_page.css" type="text/css">
</head>
<body>	
    <h1>Сотрудники</h1>	
    <form method="post" action="AdminServlet" class="login">        
        <input type="submit" name="add" value ="Добавить">
        <input type="submit" name="exit" value ="Выход">
    <div class="container">
        <%
            List<User> users = (List)request.getAttribute("users");
            int count = 1;       
        %>
            <table>
                <thead>
                    <tr>	        
                        <th>№</th>
                        <th>Ф.И.О.</th>
                        <th>Должность</th>	         
                        <th>Изменить</th>	
                        <th>Удалить</th>	       
                    </tr>
                </thead>
                    <%for (User user : users) {%>
                <tbody>
                    <tr>	        
                        <td><%= count++ %></td>
                        <td><%= user.getFullName()%></td>                                            
                        <td><%= user.getPosition().getName()%></td>
                        <td><button class='button' type="submit" name="update_user" value=<%= user.getIdUser()%>>Изменить</button></td>
                        <td><button class='button' type="submit" name="delete_user" value=<%= user.getIdUser()%>>Удалить</button></td>			        
                    </tr></form>	
                     <%}%>
                </tbody>
            </table>
	</div>
    </form>	
</body>
</html>
