/**
 * @returns xml request to get
 */
function getXMLHttpRequest() {
    var xmlHttpReq;
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (exp1) {
            try {
                xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (exp2) {
                alert("Exception in getXMLHttpRequest()!");
            }
        }
    }
    return xmlHttpReq;
}