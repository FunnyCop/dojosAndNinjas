<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8" />
    <title>All Dojos</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />
    <link rel = "stylesheet" type = "text/css" href = "/css/dojo/all.css" />

</head>

<body>

	<table class = "table" id = "language-table">
		<thead class = "thead-dark">
			<tr>
				<th scope = "col">ID</th>
				<th scope = "col">Name</th>
				<th scope = "col">Ninjas</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items = "${dojos}" var = "dojo">
				<tr>
					<th scope = "row"><c:out value="${ dojo.id }" /></th>
					<td><c:out value="${ dojo.name }" /></td>
					<td><a href = "/dojo/id/${ dojo.id }/ninjas"><c:out value="${ dojo.ninjas.size() }" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3><a href = "/dojo/new">New Dojo</a></h3>
	<h3><a href = "/ninja/new">New Ninja</a></h3>

</body>

</html>