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
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<!--  http://localhost:8080/SpringMVCDemo/greet  -->
	<% String id=(String) session.getAttribute("email"); if (id!=null) { %>
		<div class="container">
			<h1>Welcome ${sessionScope.username}</h1>
		</div>
		<%} %>
			<div class="container">
				<jsp:include page="/WEB-INF/views/books.jsp" />
			</div>
</body>

</html>