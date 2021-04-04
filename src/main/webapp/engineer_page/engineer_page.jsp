<%@page import="ru.edu.skynet_cd.domain.Report"%>
<%@page import="ru.edu.skynet_cd.dao.ReportDAO"%>
<%@page import="ru.edu.skynet_cd.dao.ReportDAOImpl"%>
<%@page import="ru.edu.skynet_cd.dao.TaskDAOImpl"%>
<%@page import="ru.edu.skynet_cd.dao.TaskDAO"%>
<%@page import="ru.edu.skynet_cd.dao.UserDAOImpl"%>
<%@page import="ru.edu.skynet_cd.dao.UserDAO"%>
<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page import="ru.edu.skynet_cd.domain.Task"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Отдел строительства SkyNet</title>
	<link rel="stylesheet" href="engineer_page/css/engineer_style.css">
</head>
<body>	
    <h1>Инженер</h1>	
    <form method="post" action="EngineerServlet" class="login">
        <input type="submit" name="add" value ="Создать">
        <input type="submit" name="exit" value ="Выход">
            <div class="container">
            <%
            UserDAO userDAO = new UserDAOImpl();               
            List<Task> tasks = (List)request.getAttribute("tasks");
            ReportDAO<Report> rDAO = new ReportDAOImpl();
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
                            <th>Удалить</th>	       
                        </tr>
                    </thead>
        <%for (Task tsk : tasks) {
        User user = (User)userDAO.getById(tsk.getExecutor());
        Report rep = rDAO.ReportGetByTaskId(tsk.getIdTask());
        String s;
            if (rep.getReportAddress()!=null) {
                   s = "Смотреть"; 
                } else {s = "Не заполнен"; }
        %>
        <tbody>
            <tr>
                <input type="hidden" name="id_task" id="" value ="<%=tsk.getIdTask()%>">
                <td><%= count++ %></td>
                <td><%= tsk.getTaskDate()%></td>
                <td><%= tsk.getAddress()%></td>                                            
                <td><%= user.getFullName()%></td> 
                <td><%= tsk.getTaskStatus().getStatus()%></td>
                <td><button class="btn" type="submit" name="view" value="<%=tsk.getIdTask()%>">Смотреть</button></td>                      
                <td><button class="btn" type="submit" name="report" value="<%=tsk.getIdTask()%>"><%=s%></button></td>
                <td><button class="btn" type="submit" name="delete" value="<%=tsk.getIdTask()%>">X</button></td>	
            </tr>	
        </tbody>
        <%}%>
                </table>
            </div>
    </form>	
</body>
</html>
