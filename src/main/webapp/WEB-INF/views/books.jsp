<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>All Books</h1>
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
					<td><a href="${pageContext.request.contextPath}/read-later/${book.book_Id }">Read Later</a>
						&nbsp; <a href="${pageContext.request.contextPath}/add-to-liked/${book.book_Id }"> Like
						</a></td>
				<%} %>
			</tr>
		</c:forEach>

	</tbody>
</table>