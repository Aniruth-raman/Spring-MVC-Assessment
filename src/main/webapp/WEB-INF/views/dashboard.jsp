<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<!--  http://localhost:8080/SpringMVCDemo/greet  -->
	<h1>Welcome ${sessionScope.email }</h1>
	<div class="container">
    		<table class="table">
    			<thead>
    				<tr>
    					<th scope="col">Book Name</th>
    					<th scope="col">Author</th>
    					<th scope="col">Genre</th>
    					<th scope="col">READ LATER/ LIKE</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach items="${books }" var="book">
    					<tr>
    						<td>${book.book_name }</td>
    						<td>${book.author }</td>
    						<td>${book.genre }</td>
    						<!-- <td><a style="margin: 7.5%"
    							href="dashboard/readlater/${book.book_Id }"><i
    								class="fa fa-bookmark-o" style="color: black"></i></a> &nbsp; <a
    							href="dashboard/liked/${book.book_Id }"> <i
    								class="fa fa-heart-o" style="color: black"></i>
    						</a></td> -->
    					</tr>
    				</c:forEach>

    			</tbody>
    		</table>
    	</div>
</body>

</html>