<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All employees</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
<style>
table {
	font-family: "Lucida" Grande, sans-serif;
	border-collapse: collapse;
	width: 80%;
	border:25px solid white;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
</head>
<body>
<h1 class="text-center">Employee list</h1>
<div class="table-responsive">
<table class="table table-success table-striped">
		<thead>
			<tr class="headRow">
				<th>Employee id</th>
				<th>Employee username</th>
				<th>Employee email</th>
				<th>Employee phone</th>
				<th>Salary</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.userId}</td>
					<td>${employee.username}</td>
					<td>${employee.email}</td>
					<td>${employee.phone}</td>
					<td>${employee.salary}</td>
					<td><a href="updateEmployee?id=<c:out value="${employee.userId}"/>">update</a></td>
					<td><a href="deleteEmployee?id=<c:out value="${employee.userId}"/>">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>	
	<ul>
		<li>
			<a href="addEmployee">Add new Employee</a>		
		</li>
		<li>
			<a href="/bankapp/home">Home Page</a>
		</li>
	</ul>
		
</body>
</html>