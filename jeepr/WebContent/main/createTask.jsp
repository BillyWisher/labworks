<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../script/tasksScript.js"></script>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Create Task</title>
</head>
<body>
	<div class="tableDiv">
		<form action="createTask" name="newTaskForm" class="center"
			method="post" enctype="multipart/form-data">
			<div>
				<textarea class="text" rows="4" cols="120" type="text"
					name="description" id="description" placeholder="Description"></textarea>
			</div>
			<div>
				<c:if test="${section eq 'SOMEDAY'}">
			Date (yyyy-mm-dd) 
			<input type="date" name="date" id="date">
				</c:if>
				Attach file (max size:100 MB ) <input type="file" name="file">
			</div>
			<div>
				<input class="button" type="button" value="Create"
					onclick="JavaScript:checkInputsAndSubmit()">
				<a class="button" href="/jeeProject/main">Back</a>
			</div>
		</form>
	</div>
	<c:if test="${info != null}">
		<div class="">${info}</div>
	</c:if>
</body>
</html>