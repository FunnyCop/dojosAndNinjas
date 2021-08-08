<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8" />
    <title>Dojo</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />

</head>

<body>

	<h3><c:out value="${ dojo }" /></h3>

	<table class = "table" id = "language-table">
		<thead class = "thead-dark">
			<tr>
				<th scope = "col">ID</th>
				<th scope = "col">First Name</th>
				<th scope = "col">Last Name</th>
				<th scope = "col">Age</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items = "${ninjas}" var = "ninja">
				<tr>
					<th scope = "row"><c:out value="${ ninja.id }" /></th>
					<td><c:out value="${ ninja.firstName }" /></td>
					<td><c:out value="${ ninja.lastName }" /></td>
					<td><c:out value="${ ninja.age }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3><a href = "/dojo/all">Home</a></h3>

</body>

</html>