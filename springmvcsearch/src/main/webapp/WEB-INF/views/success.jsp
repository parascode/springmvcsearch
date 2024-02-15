<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>

<h1>Name is: ${student.name}</h1>
<h1>Student id is: ${student.id}</h1>
<h1>Student Date of Birth is: ${student.date}</h1>
<h1>Courses are: ${student.courses}</h1>
<h1>Student gender is: ${student.gender}</h1>
<h1>Student type is: ${student.type}</h1>
<hr>
<h1>Address street is: ${student.getAddress().getStreet()}</h1>
<h1>Address type is: ${student.getAddress().getCity()}</h1>

</body>
</html>