<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ToDo</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <c:import url="header.jsp"/>
    <div class="mainDiv">
    	<form action="main">
        <input class="button" type="submit" value="To Do">
    	</form>
    	<form action="login.jsp">
        <input class="button" type="submit" value="Log In">
    	</form>
    	<form action="signup.jsp">
       	<input class="button" type="submit" value="Sign Up">
    	</form>  
    </div>
      	
</body>
</html>