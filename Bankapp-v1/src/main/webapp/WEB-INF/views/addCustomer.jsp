<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new customer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
<style>
.error{
	color:red;
}
.form{
	border:15px solid white;
}
</style>
</head>
<body>

	<h1 class="text-center">Add new Customer</h1>

	<form:form action="addCustomer" method="post" modelAttribute="customer" class="form">
	<form:hidden path="customerId"/>
		
		<div class="form-group">
				<label>Enter customer name</label>
				<form:input class="form-control" path="customerName" />
				<form:errors path="customerName" class="error" />
		</div>
		
		<div class="form-group">
				<label>Enter customer email</label>
				<form:input class="form-control" path="customerEmail" />
				<form:errors path="customerEmail" class="error" />
		</div>	
		
		<div class="form-group">
				<label>Enter customer phone number</label>
				<form:input class="form-control" path="customerPhone" />
				<form:errors path="customerPhone" class="error" />
		</div>	
		
		<div class="form-group">
				<label>Enter customer address</label>
				<form:input class="form-control" path="customerAddress" />
				<form:errors path="customerAddress" class="error" />
		</div>		
		
		<div class="form-group">
				<label>Enter customer balance</label>
				<form:input class="form-control" type="number" path="balance"/>
				<form:errors path="balance" class="error" />
		</div>		
		<button type="submit" class="btn btn-primary">Submit</button>	
	</form:form>
</body>
</html>