
function getPeopleTable(firstName, tableId) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "people?firstName="+document.getElementById(firstName).value, true);
  xhttp.send();
}

function getAllPeopleTable(tableId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "people", true);
  xhttp.send();
}

function insertPerson(studentName, parentName, phoneNumber, description, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
  var ar1 = document.getElementById(studentName).value;
  var ar2 = document.getElementById(parentName).value;
  var ar3 = document.getElementById(phoneNumber).value;
  var ar4 = document.getElementById(description).value;
  
  xhttp.open("GET", "peopleInsert?studentName=" + ar1 + "&parentName=" + ar2 + "&phoneNumber=" + ar3 + "&description=" + ar4 , true);
  xhttp.send();
}


function updatePerson(clientId, studentName, parentName, phoneNumber, description, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
  var ar1 = document.getElementById(studentName).value;
  var ar2 = document.getElementById(parentName).value;
  var ar3 = document.getElementById(phoneNumber).value;
  var ar4 = document.getElementById(description).value;
  
  xhttp.open("GET", "peopleUpdate?clientId="+clientId+"&studentName=" + ar1 + "&parentName=" + ar2 + "&phoneNumber=" + ar3 + "&description=" + ar4 , true);
  xhttp.send();
}

function deletePerson(clientId, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
  
  xhttp.open("GET", "peopleDelete?id=" + clientId, true);
  xhttp.send();
}

function getAttendanceListTable(tableId) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
     document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "attendanceList", true);
  xhttp.send();
}