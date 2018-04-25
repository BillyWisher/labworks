<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <div class="header">
        <div class="title">
            ToDo
        </div>
        <div class="authentication">
            <c:if test="${user != null}">
                ${user.login}, <a href="http://localhost:8080/jeeProject/logout">logout</a>
            </c:if>
        </div>
    </div>
</body>
</html>
