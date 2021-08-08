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

	<form:form action = "/ninja/new/submit" method = "post" modelAttribute = "ninja" class = "form-group">

		<form:label path = "dojo">Dojo</form:label>
		<form:errors path = "dojo" style = "color: red;" />
		<form:select path = "dojo" class = "form-control">

			<c:forEach items = "${dojos}" var = "dojo">

				<form:option value = "${ dojo.id }"><c:out value = "${ dojo.name }" /></form:option>

			</c:forEach>

		</form:select>

		<form:label path = "firstName">First Name</form:label>
		<form:errors path = "firstName" style = "color: red;" />
		<form:input path = "firstName" class = "form-control" required = "true" />

		<form:label path = "lastName">Last Name</form:label>
		<form:errors path = "lastName" style = "color: red;" />
		<form:input path = "lastName" class = "form-control" required = "true" />

		<form:label path = "age">Age</form:label>
		<form:errors path = "age" style = "color: red;" />
		<form:input path = "age" class = "form-control" required = "true" />
		
		<form:button class = "btn btn-primary">Submit</form:button>

	</form:form>

	<h3><a href = "/dojo/all">Home</a></h3>

</body>

</html>