<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <script type="text/javascript" src="script/tasksScript.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <c:import url="header.jsp"/>
    <div class="five">
    <form name="sectionForm" action="main/changeSection" method="post">
    	<input name="section" type="hidden">
    	<div align="center">
		<a href="JavaScript:changeSection('TODAY')">Today</a>
		<a href="JavaScript:changeSection('TOMORROW')">Tomorrow</a>
		<a href="JavaScript:changeSection('SOMEDAY')">Someday</a>
		<a href="JavaScript:changeSection('FIXED')">Fixed</a>
		<a href="JavaScript:changeSection('DELETED')">Recycle Bin</a>
	</div>
    </form>
    </div>
    <div class="tableDiv">${section}</div>
    
    <c:if test="${info != null}">
        <div class="info-block">
                ${info}
        </div>
    </c:if>

	<div class="tableDiv">
	<table id="tasksTable">
		<tr>
    		<th>Task</th>
	    	<th>Expiration date</th>
	    	<th>File</th>
	    	<th>Choose all<br><input type=checkbox id="checkboxAll" onclick="JavaScript:chooseAll()"></th>
		</tr>   
		<c:forEach items="${tasks}" var="task" varStatus="counter">
	   		<tr>
	    		<td>${task.description}</td>
	    		<td>${task.date}</td>
	    		<td>
	    			 <c:if test="${task.file ne null}">
	    			 	<form action="main/file" name="fileForm" id="fileFormId${task.id}" method="post">
							<input name="taskDownload" id="taskDownloadId${task.id}" type="hidden">
							<a href="JavaScript:downloadFile('${task.id}')">${task.fileName}</a>
							<input name="deleteTask" id="deleteTask${task.id}" type="hidden">
							<input class="but" type="button" value="Delete" onclick="JavaScript:deleteFile('${task.id}')">
						</form>
	    			 </c:if>
	    			 <c:if test="${task.file eq null}">
	    			 	<form action="main/loadFile" name="loadFileForm" id="loadFileFormId${task.id}" method="post" enctype="multipart/form-data" onsubmit="JavaScript:loadFile('${task.id}')">
	    			 		<input name="taskLoadFileId" type="hidden" id="taskLoadFileId${task.id}">
	    			 		<input type="file" name="file">
	    			 		<input class="but" type="reset" value="Reset">
	    			 		<input class="but" type="button" value="Load" onclick="JavaScript:loadFile('${task.id}')">
	    			 	</form>
	    			 </c:if>
	    		</td>
	    		<td>
					<input type=checkbox name="taskCheckbox${counter.index}">
					<input type="hidden" name="taskId${counter.index}" id="taskId${counter.index}" value="${task.id}">
	    		</td>
			</tr>
		</c:forEach>  
	</table>
	</div>

	<div class="five">
	<form action="main/action" method="post" name="actionForm">
		<input type="hidden" name="action">
		<input type="hidden" name="target">
		<div align="center" id="operations">
			<c:forEach items="${operations}" var="operation" varStatus="counter">
				<a href="JavaScript:doAction('${operation}')" id="operationRef${counter.index}">${operation}</a>
			</c:forEach>  
		</div>
	</form>
	</div>
</body>
</html>