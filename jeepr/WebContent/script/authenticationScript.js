/**
 * Checks whether str is empty
 * @param str - string to check
 * @returns - empty or not
 */
function isEmptyField(str) {
    if(str===undefined){
        return true;
    }
    return str.trim() === '';
}

/**
 * Sends post request
 * @param path - request path
 * @param params - params to send
 */
function sendPost(path, params) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", path);

    for(var key in params) {
        if(params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);
    form.submit();
}

/**
 * Checks login form 
 * @returns false
 */
function loginSubmit() {
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    if(isEmptyField(login) || isEmptyField(password)){
        alert("Please fill all fields");
        return false;
    }
    sendPost('login',{'login':login, 'password':sha256(password)});
    return false;
}

/**
 * Checks signup form 
 * @returns false
 */
function signupSubmit() {
    var login = document.getElementById('signup-login').value;
    var password = document.getElementById('signup-password').value;
    var password2 = document.getElementById('signup-password2').value;
    if(isEmptyField(login) || isEmptyField(password)){
        alert("Please fill all fields");
        return false;
    }
    if(password !== password2){
        alert("Passwords should be the same.");
        return false;
    }
    sendPost('signup',{'login':login, 'password':sha256(password)});
    return false;
}