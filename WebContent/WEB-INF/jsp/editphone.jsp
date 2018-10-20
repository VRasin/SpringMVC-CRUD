<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert phone</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/saveEdit" method="post" modelAttribute="phone">
		<table>
			<tr>
				<td class="label">ID:</td>
				<td class="control"><input type="number" name="id" value="${phone.id}"></td>
			</tr>
			<tr>
				<td class="label">Brand:</td>
				<td class="control"><input type="text" name="brand" value="${phone.brand}"></td>
			</tr>
			<tr>
				<td class="label">Model</td>
				<td class="control"><input type="text" name="model" value="${phone.model}"></td>
			</tr>
			<tr>
				<td class="label">Processor</td>
				<td class="control"><input type="text" name="processor" value="${phone.processor}"></td>
			</tr>
			<tr>
				<td class="label">Memory</td>
				<td class="control"><input type="text" name="memory" value="${phone.memory}"></td>
			</tr>
			<tr>
				
				<td colspan="2"><input id="btn" type="submit" value="save updates"></td>
			</tr>
		</table>
	</form:form>

	<button id="list" onclick="window.location.href = 'phones'">List of 
		phones</button>
		

</body>
</html>