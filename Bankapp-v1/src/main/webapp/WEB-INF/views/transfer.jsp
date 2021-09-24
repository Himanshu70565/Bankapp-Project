<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer amount</title>
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
<h1 class="text-center">Transfer amount</h1>
	<form:form action="transferMoney" method="post" modelAttribute="transactionObject" class="form">
		
		<div class="form-group">
				<label>Enter from AccountNumber</label>
				<form:input class="form-control" path="fromAccountNumber" />
				<form:errors path="fromAccountNumber" class="error" />
		</div>
		
		<div class="form-group">
				<label>Enter to AccountNumber</label>
				<form:input class="form-control" path="toAccountNumber" />
				<form:errors path="toAccountNumber" class="error" />
		</div>
			
		<div class="form-group">
				<label>Enter transfer amount</label>
				<form:input class="form-control" path="amount" />
				<form:errors path="amount" class="error" />
		</div>
			
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>		
</body>
</html>