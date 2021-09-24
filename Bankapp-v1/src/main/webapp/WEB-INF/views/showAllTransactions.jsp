<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Transactions</title>
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
<h1 class="text-center">Transaction List</h1>
<div class="table-responsive">
	<table class="table table-info table-striped">
		<thead>
			<tr class="headRow">
				<th>Transaction Id</th>
				<th>From account</th>
				<th>To account</th>
				<th>Amount</th>
				<th>Transaction type</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="transaction">
				<tr>
					<td>${transaction.transactionId}</td>
					<td>
						<c:if test="${transaction.fromAccountNumber==null}" >
							self
						</c:if>
						<c:if test="${transaction.fromAccountNumber!=null}" >
							${transaction.fromAccountNumber}
						</c:if>
					</td>
					<td>
						<c:if test="${transaction.toAccountNumber==null}" >
							self
						</c:if>
						<c:if test="${transaction.toAccountNumber!=null}" >
							${transaction.toAccountNumber}
						</c:if>
					</td>
					<td>${transaction.amount}</td>
					<td>${transaction.transactionType}</td>
					<td>${transaction.status}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>	
	<ul>
		<li>
			<a href="withdrawMoney">Withdraw Money</a>	
		</li>
		<li>
			<a href="depositMoney">Deposit Money</a>
		</li>
		<li>
			<a href="transferMoney">Transfer Money</a>	
		</li>
		<li>
			<a href="pendingTransaction">View Pending Transaction</a>	
		</li>
		<li>
			<a href="/bankapp/home">Home Page</a>
		</li>
	</ul>
</body>
</html>