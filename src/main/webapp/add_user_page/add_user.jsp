<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page import="ru.edu.skynet_cd.domain.Position"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>Отдел строительства SN</title>
    <link rel="stylesheet" href="add_user_page/css/add_user_style.css" type="text/css">
</head>
<body>	
    <%
        List<Position> positions = (List)request.getAttribute("positions");
        User user = (User)request.getAttribute("user");
    %>
    <form method="post" action="AddUserServlet" class="login">
        <div class="header">
            <h1>Добавление</h1>	   
	</div>   
	<div class="input"> 
            <input type="text" name="first_name" value="<%= user.getFirstName()%>" placeholder="Фамилия">		       
            <input type="text" name="second_name" value="<%= user.getSecondName()%>" placeholder="Имя">
            <input type="text" name="patronymic" value="<%= user.getPatronymic()%>" placeholder="Отчество">		       
            <select name="position">
                <%for (Position pos : positions) {%>
                    <option><%= pos.getName()%></option>
                <%}%>
            </select>            
            <input type="text" name="phone" placeholder="Номер телефона">
            <input type="text" name="login" value="<%= user.getLogin()%>" placeholder="логин">		       
            <input type="password" name="password" placeholder="пароль">
            <input type="password" name="repeat_pass" placeholder="повтор пароля">
        </div> 
        <div class="buttons">
            <input type="submit" name="add" value ="ОК">
            <input type="submit" name="back" value ="Назад">
        </div>				
    </form>
</body>
</html>
