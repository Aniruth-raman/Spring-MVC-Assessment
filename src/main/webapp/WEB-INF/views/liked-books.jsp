<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>User Dashboard</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<link href="resources/css/login.css" rel="stylesheet" type="text/css">

</head>

<body>
<h1>${sessionScope.username}'s Liked Books</h1>
<table class="table">
	<thead>
		<tr>
			<th scope="col">Book Name</th>
			<th scope="col">Author</th>
			<th scope="col">Genre</th>
			<% String id=(String) session.getAttribute("email"); if (id!=null) { %>
				<th scope="col">READ LATER/ LIKE</th>
			<%} %>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.book_name}</td>
				<td>${book.author}</td>
				<td>${book.genre}</td>
				<% if (id!=null) { %>
					<td> <a href="${pageContext.request.contextPath}/remove-from-liked/${book.book_Id }"> Remove from Liked
						</a></td>
				<%} %>
			</tr>
		</c:forEach>

	</tbody>
</table>
</body>

</html>
