<%@page import="ru.edu.skynet_cd.domain.Report"%>
<%@page import="ru.edu.skynet_cd.domain.Task"%>
<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User)request.getAttribute("executor");
            Task task = (Task)request.getAttribute("task");
            Report reportTask = (Report)request.getAttribute("reportTask");
        %>
        <form method="post" action="ReportServlet" class="login">
        <div class="header">
            <h1>Отчет</h1>	   
	</div>   
            <p><%= user.getFullName()%></p>
            <p><%= task.getAddress()%></p>
	<div class="input"> <br> 
            <legend>
                Колличество квартир
                <p><%= reportTask.getTotalApartments()%></p> 
            </legend>      <br>  
            <legend>
                Размещение ящиков
                <p><%= reportTask.getBoxPosition()%></p>
            </legend> <br> 
            <legend>
                Точки подключения электричества
                <p><%= reportTask.getPointEnergy()%></p>
            </legend>      <br>  
            <legend>
                Примечания
                <p><%= reportTask.getNote()%></p>
            </legend>     <br>        
        </div> 
        <div class="buttons">            
            <input type="submit" name="back" value ="Назад">
        </div>				
    </form>
    </body>
</html>
