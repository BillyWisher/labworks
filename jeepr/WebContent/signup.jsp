<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sing Up</title>
    <script type="text/javascript" src="script/authenticationScript.js"></script>
    <script src="script/sha256.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <c:import url="header.jsp"/>
    <div id="signup-block" class="form-class">
        <form name="signup-form" onsubmit="return signupSubmit();">
            <table>
                <tr>
                    <td>
                        <input class="input" type="text" id="signup-login" placeholder="Login">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class="input" type="password" id="signup-password" placeholder="Password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class="input" type="password" id="signup-password2" placeholder="Repeat password">
                    </td>
                </tr>
            </table>
            <input type="submit" class="button" value="Sign Up">
            <div class="qu">Already signed up? <a href="login.jsp">Log in</a></div>
        </form>
    </div>
    <c:if test="${info != null}">
        <div class="info-block">
                ${info}
        </div>
    </c:if>
    </body>
</html>