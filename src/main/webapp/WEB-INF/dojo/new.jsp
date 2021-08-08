<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8" />
    <title>New Dojo</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />
    <link rel = "stylesheet" type = "text/css" href = "/css/dojo/new.css" />

</head>

<body>

	<form:form action = "/dojo/new/submit" method = "post" modelAttribute = "dojo" class = "form-group">

		<form:label path = "name">Name</form:label>
		<form:errors path = "name" style = "color: red;" />
		<form:input path = "name" class = "form-control" required = "true" />
		
		<form:button class = "btn btn-primary">Submit</form:button>

	</form:form>

	<h3><a href = "/dojo/all">Home</a></h3>

</body>

</html>