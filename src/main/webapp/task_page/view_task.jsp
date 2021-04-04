<%@page import="ru.edu.skynet_cd.domain.Material"%>
<%@page import="ru.edu.skynet_cd.domain.User"%>
<%@page import="ru.edu.skynet_cd.domain.Position"%>
<%@page import="java.util.List"%>
<%@page import="ru.edu.skynet_cd.domain.Task"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="task_page/css/task_style.css">
</head>
<body>
    <%    
        Task task = (Task)request.getAttribute("task");
        List<Material> materials = (List)request.getAttribute("mats");
        User executor = (User)request.getAttribute("executor");
        int count = 1;
        HttpSession sess = request.getSession();
        User userSess = (User)sess.getAttribute("user");
    %>
    <form method="post" action="ViewTaskServlet" class=full>
        <fieldset>
          <legend>Ф.И.О и Адрес</legend>            
          <p><%= executor.getFullName()%></p>
          <p><%= task.getAddress()%></p>        
        </fieldset>
        <fieldset>
            <legend>
                Материалы <% if (userSess.getPosition().getId() == 4) // 4 - id storekeeper 
                            { %>
                        <button class='button' type="submit" name="issue" value="<%= task.getIdTask()%>">Выдать</button>                    
               <% } else if(userSess.getPosition().getId() == 3) // 3 - id fitter
                    {%>
                        <button class='button' type="submit" name="recive" value="<%= task.getIdTask()%>">Получил</button>
               <%}%>
            </legend>  
            <div class="container">
                <table>
                    <thead>
                        <tr>	        
                            <th>№</th>						
                            <th>Наименование</th>	         
                            <th>Выписано</th>	
                            <th>Получено</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Material mats : materials) {%> 
                        <tr>	        
                            <td><%= count++ %></td>
                            <td><%= mats.getNameMaterial() %></td>
                            <td><%= mats.getIssued() %></td>
                            <td><%= mats.getReceived() %></td>                            
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </fieldset>
        <button class='button' type="submit" name="back" value="">Назад</button>        
    </form>
</body>
</html>