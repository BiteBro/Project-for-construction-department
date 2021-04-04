<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<title>Отдел строительства SN</title>
	<link rel="stylesheet" href="static style.css" type="text/css">	
</head>
<body>	
    <form method="post" action="LoginServlet" class="login">
        <h1>ВХОД</h1>
        <input type="text" name="login" id="login" placeholder="имя пользователя">
        <input type="password" name="pwd" id="password" placeholder="пароль">
        <input type="submit" name="entrance" value ="Войти" >
    </form>     
</body>
</html>
