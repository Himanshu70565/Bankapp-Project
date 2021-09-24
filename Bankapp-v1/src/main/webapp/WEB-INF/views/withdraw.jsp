<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Money</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
<style>
.error{
	color:red;
}
.form{
	border:15px solid white;

</style>
</head>
<body>
	<h1 class="text-center">Withdraw amount</h1>
	<form:form action="withdrawMoney" method="post" modelAttribute="withdrawRequest" class="form">
			<div class="form-group">
				<label>Enter customer accountNumber</label>
				<form:input class="form-control" path="fromAccount" />
				<form:errors path="fromAccount" class="error" />
			</div>		
			<div class="form-group">
				<label>Enter withdraw amount</label>
				<form:input class="form-control" path="amount" />
				<form:errors path="amount" class="error" />
			</div>		
			<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>		
</body>
</html>