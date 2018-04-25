<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <script type="text/javascript" src="script/getXMLRequest.js"></script>
    <script type="text/javascript" src="script/authenticationScript.js"></script>
    <script src="script/sha256.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <c:import url="header.jsp"/>
    <div id="login-block" class="form-class">
        <form name="login-form" onsubmit="return loginSubmit();">
            <table>
                <tr>
                    <td>
                        <input class="input" type="text" id="login" placeholder="Login"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class="input" type="password" id="password" placeholder="Password"/>
                    </td>
                </tr>
                <tr>
                	<td>
                		<div class="rememberMe" >Remember me</div>
                	</td>
               		<td>
               			<input type="checkbox" name="rememberMe" checked="checked" value= "true" />
               		</td>
                </tr>
            </table>
            <input class="button" type="submit" value="Log in">
            <div class="qu">Don't you have an account? <a href="signup.jsp">Sign Up</a>
            </div>
        </form>
    </div>
    <c:if test="${info != null}">
        <div class="info-block">
                ${info}
        </div>
    </c:if>
</body>
</html>