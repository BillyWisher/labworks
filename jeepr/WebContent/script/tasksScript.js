/**
 * Changes section and submit form
 * @param sec - section to change
 */
function changeSection(sec){
			document.sectionForm.section.value = sec;
			document.sectionForm.submit();
}

/**
 * Load task file
 * @param task - task to load 
 */
function loadFile(id){
			document.getElementById("taskLoadFileId" + id).value = id;
			document.getElementById("loadFileFormId" + id).submit();
}

/**
 * Set task id to download file
 * @param id - task id
 */
function downloadFile(id){
			document.getElementById("taskDownloadId" + id).value = id;
			document.getElementById("fileFormId" + id).submit();
}

/**
 * Delete file from task
 * @param id - task id
 */
function deleteFile(id){
			document.getElementById("taskDownloadId" + id).value = id;
			document.getElementById("deleteTask" + id).value = id;
			document.getElementById("fileFormId" + id).submit();
}

/**
 * Check all
 */
function chooseAll(){ 
			var rows = document.getElementById("tasksTable").getElementsByTagName("tr");
			var checkAll = document.getElementById("checkboxAll");  
			for(var index=0; index<rows.length; ++index){ 
				document.getElementsByName("taskCheckbox" + index)[0].checked = checkAll.checked;
			} 
}

/**
 * Checks inputs and submit form
 */
function checkInputsAndSubmit(){
			var isValidInputs = true;
			var date = document.getElementById("date");
			var datePattern = /\d\d\d\d-\d{1,2}-\d{1,2}/;
			var cause = "";	
			if (date != null && date.value != "") {
				if (date.value.match(datePattern) != date.value) {
					isValidInputs = false;
					cause += "Invalid date.";
				}
			} 
			var description = document.getElementById("description");
			if (description.value == "") {
				cause += " Empty description.";
				isValidInputs = false;		
			}
			if (isValidInputs) {
				document.newTaskForm.submit();
			} else {
				alert(cause);
			}
}

/**
 * Do some ation with tasks
 * @param action - action to do
 */
function doAction(action) {
	var REDIRECT_PATH = {
			CREATE : "createTask.jsp", 
			DELETE : "deleteTask", 
			FIX : "fixTask", 
			HARDDELETE : "hardDeleteTask", 
			RESTORE : "restoreTask", 
			UNFIX : "restoreTask"
	}
	var rows = document.getElementById("tasksTable").getElementsByTagName("tr");
	var ids = "";
	for (var i = 0; i < rows.length - 1; i++) {
		if (document.getElementsByName("taskCheckbox" + i)[0].checked) {
			var id= document.getElementById("taskId" + i).value;
			ids += id +";";
		}
	}
	ids = ids.slice(0, -1);
	if (ids.length < 1) {
		ids = "-1";
	}
	
	var form = document.actionForm;	
	form.action.value = REDIRECT_PATH[action];
	form.target.value = ids;
	form.submit();
}