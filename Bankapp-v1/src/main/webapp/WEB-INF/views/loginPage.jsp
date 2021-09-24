<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="assets/css/styleLogin.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>
	<h1 class="text-center" style="color:white">My Bankapp Login page!</h1>

	<div class="login-box">
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
			<font color="red">
				<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out>
			</font>
		</c:if>

		<c:if test="${not empty param.logout}">
        	<font color="green"> <c:out value="Logged Out Successfully"></c:out>
        	</font>
 		</c:if>
        
        <h2>Login</h2>
        <c:url value="/myloginprocessor" var="login"/>
        <form:form action="${login}" method="post">
            <div class="user-box">
               <input type="text" name="username" >
                <label>Username</label>
            </div>
            <div class="user-box">
                 <input type="password" name="password">
                <label for="">Password</label>
            </div>
            <a href="">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <button type="submit" class="btn btn-primary">Submit</button>
            </a>
        </form:form>
    </div>
</body>
</html>