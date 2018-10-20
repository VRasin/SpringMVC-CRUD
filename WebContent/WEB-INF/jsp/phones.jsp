<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td, th {
		border: 1px solid black;
		padding: 5px;
	}
	
	
</style>
</head>
<body>

	<table>
		<tr>
			<th>Phone ID</th>
			<th>Brand</th>
			<th>Model</th>
			<th>Processor</th>
			<th>Memory</th>
			<th>Action</th>
		</tr>

		<c:forEach var="phone" items="${phones}">
			<c:url var="delete" value="delete">
				<c:param name="id" value="${phone.id }"></c:param>
			</c:url>

			<tr>
				<td>${phone.id}</td>
				<td>${phone.brand}</td>
				<td>${phone.model}</td>
				<td>${phone.processor}</td>
				<td>${phone.memory}</td>
				<td><a href="editPhone?id=${phone.id}">edit</a> | <a
					onclick="if(!(confirm('Are you sure you want to delete this phone?'))) return false"
					href="${delete}">delete</a></td>
			</tr>
		</c:forEach>

	</table>

	<button onclick="window.location.href = 'newPhone'">add
		phone</button>
</body>
</html>