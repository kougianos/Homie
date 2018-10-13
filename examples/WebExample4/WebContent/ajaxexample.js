var req;

function init() {
    studentName = document.getElementById("student");
}

function doCompletion() {
        var url = encodeURI("search_by_name?action=complete&name=" + studentName.value);
        req = new XMLHttpRequest();
        req.open("GET", url, true);
        req.onreadystatechange = callback;
        req.send(null);
}


function callback() {
	if (req.readyState == 4) {
        if (req.status == 200) {
        	document.getElementById('studentnames').value =req.responseText;
        }
	}
}



