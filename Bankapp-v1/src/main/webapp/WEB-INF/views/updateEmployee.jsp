<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update employee</title>
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
<h1 class="text-center">Update employee</h1>
	<form:form action="addEmployee" method="post" modelAttribute="employee" class="form">
	<form:hidden path="userId"/>
	
		<div class="form-group">
				<label>Enter employee username</label>
				<form:input class="form-control" path="username" readonly="true"/>
				<form:errors path="username" class="error" />
		</div>
	
	    <div class="form-group">
				<label>Enter employee email</label>
				<form:input class="form-control" type="email" path="email" readonly="true"/>
				<form:errors path="email" class="error" />
		</div>
		
		<div class="form-group">
				<label>Enter employee password</label>
				<form:input  class="form-control" path="password" readonly="true"/>
				<form:errors path="password" class="error" />
		</div>		
				
	    <div class="form-group">
				<label>Enter employee phone number</label>
				<form:input class="form-control" path="phone" readonly="true"/>
				<form:errors path="phone" class="error" />
		</div>
			
		<div class="form-group">
				<label>Enter employee salary</label>
				<form:input class="form-control" type="number" path="salary"/>
				<form:errors path="salary" class="error" />
		</div>	
		<button type="submit" class="btn btn-primary">Submit</button>		
	</form:form>
</body>
</html>