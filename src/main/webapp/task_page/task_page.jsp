<%@page import="java.util.ArrayList"%>
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
        List<Material> materials = new ArrayList();
        List<User> executors = (List)request.getAttribute("executors");
        int count = 1;
        long id;
    %>
    <form method="post" action="TaskServlet" >
        <fieldset>
          <legend>Ф.И.О и Адрес</legend>
            <select name="executor">
                <%for (User user : executors) {%>
                    <option><%= user.getFullName()%></option>  
                <%}%>
            </select>
          <input type="text" name="address" size="100" id="address" placeholder="Адрес"/>
        </fieldset>
            <div class="btn">
            <button type="button" name="create" value="">Создать</button>
            <button type="button" name="back" value="">Назад</button>
            </div>
        <fieldset>
            <legend>
                Материалы                
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
                        <%for (int i=15; i>0; i--) {%> 
                        <tr>	        
                            <td><%= count++ %></td>
                            <td><input type="text" name="mats_name" size="10" value="" id="address" placeholder=""/></td>
                            <td><input type="number" name="issue" size="10" value="0" id="address" placeholder="0"/></td>
                            <td><input type="number" name="recive" size="10" value="0" id="address" placeholder="0"/></td>   
                            <%%>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </fieldset>        
    </form>
</body>
</html>