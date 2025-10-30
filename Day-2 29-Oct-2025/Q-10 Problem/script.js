var students = [];

var addStudentData=()=> {

  var name = prompt("Enter student name:");
  if (!name) {
    alert("Student name cannot be empty!");
    return;
  }
  if(+name){
    alert("Student name cannot be number");
    return;
  }

  var marks = [];

  for (var i = 1; i <= 5; i++) {
    var mark = prompt("Enter marks for Subject " + i + ":");
    mark = parseFloat(mark);

    if (isNaN(mark) || mark < 0 || mark > 100) {
      alert("Invalid marks! Please enter a number between 0 and 100.");
      return;
    }
    marks.push(mark);
  }

  var total = marks.reduce(function(sum, mark) {
    return sum + mark;
  }, 0);
  var average = (total / 5).toFixed(2); 
  console.log("hello:"+average)
  students.push({
    name: name,
    marks: marks,
    total: total,
    average: average
  });

  updateTable();
}

function updateTable() {
  var tableBody = document.querySelector("#studentTable tbody");
  tableBody.innerHTML = ""; 

  students.forEach(function(student) {
    var row = document.createElement("tr");

    var nameCell = document.createElement("td");
    nameCell.textContent = student.name;

    row.appendChild(nameCell)
    
    student.marks.forEach(function(mark) {
      var markCell = document.createElement("td");
      markCell.textContent = mark;
      row.appendChild(markCell);
    });

    var totalCell = document.createElement("td");
    totalCell.textContent = student.total;

    var averageCell = document.createElement("td");
    averageCell.textContent = student.average;

    row.appendChild(totalCell);
    row.appendChild(averageCell);


    tableBody.appendChild(row);
  });
}
