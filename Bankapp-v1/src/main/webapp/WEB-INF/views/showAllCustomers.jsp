<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All customers</title>
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
<h1 class="text-center">Customer List</h1>
<div class="table-responsive">
<table class="table table-danger table-striped">
		<thead>
			<tr class="headRow">
				<th>Customer id</th>
				<th>Customer name</th>
				<th>Customer email</th>
				<th>Customer mobile</th>
				<th>Customer address</th>
				<th>Customer accountNumber</th>
				<th>Customer accountBalance</th>
				<th>Account statement</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr class="table-success">
					<td>${customer.customerId}</td>
					<td>${customer.customerName}</td>
					<td>${customer.customerEmail}</td>
					<td>${customer.customerPhone}</td>
					<td>${customer.customerAddress}</td>
					<td>${customer.account.accountId}</td>
					<td>${customer.account.accountBalance}</td>
					<td><a href="/bankapp/transaction/accountStatement?id=<c:out value="${customer.account.accountId}"/>">statement</a></td>
					<td><a href="updateCustomer?id=<c:out value="${customer.customerId}"/>">update</a></td>
					<td><a href="deleteCustomer?id=<c:out value="${customer.customerId}"/>">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>	
	<ul>
		<li>
			<a href="addCustomer">Add new Customer</a>
		</li>
		<li>
			<a href="/bankapp/home">Home Page</a>
		</li>
	</ul>
	
</body>
</html>