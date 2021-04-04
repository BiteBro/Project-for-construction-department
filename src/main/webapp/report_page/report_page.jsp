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
            Report report = (Report)request.getAttribute("reportTask");
        %>
        <form method="post" action="AddReportServlet" class="login">
        <div class="header">
            <h1>Отчет</h1>	   
	</div>   
            <legend><%= user.getFullName()%></legend>
            <legend><%= task.getAddress()%></legend> <br>
            <p><input name="status" type="radio" value="exec"> Выполнено</p>
            <p><input name="status" type="radio" value="cancel"> Отменен</p>
	<div class="input"> <br> 
            <legend>
                Колличество квартир
                <input type="number" name="apartment_count" value="<%=report.getTotalApartments()%>" >
            </legend>  <br>      
            <legend>
                Размещение ящиков
                <input type="text" name="box_position" value="<%=report.getBoxPosition()%>">
            </legend> <br> 
            <legend>
                Точки подключения электричества
                <input type="text" name="point_energy" value="<%=report.getPointEnergy()%>">
            </legend>   <br>    
            <legend>
                Примечания
                <input type="text" name="note" value="<%=report.getNote()%>">
            </legend>   <br>          
        </div> 
        <div class="buttons">            
            <button class='button' type="submit" name="save" value="<%=task.getIdTask()%>">Сохранить</button>
            <button class='button' type="submit" name="exit" value ="exit">Выйти</button>
        </div>				
    </form>
    </body>
</html>
