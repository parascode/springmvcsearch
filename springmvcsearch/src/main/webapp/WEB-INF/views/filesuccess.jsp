<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Status Page</title>
</head>
<body>
	<h1>${msg}</h1>
	<h3><c:out value="/resources/image/${name}"/></h3>
	<img src="<c:url value ="/resources/image/${name}"/>"/>
</body>
</html>