<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    		crossorigin="anonymous">
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    		crossorigin="anonymous"></script>
    			<link href="resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
<!--    <h1>User Registration</h1>
     <form action="/register" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Register">
    </form>
-->
    <div class="container">
    		<div>
    			<div class="wrapper fadeInDown">
    				<div id="formContent">
    					<div class="fadeIn first">
    						<h2 class='sign'>Register!</h2>
    						<div>
    							<span class='error'>
    								<c:if test="${error != null }">
    									${error }
    								</c:if>
    							</span>
    						</div>
    					</div>
    					<br />
    					<form action="register" method="POST">
    						<input type="text" id="username" class="fadeIn first" name="username" placeholder="Username" required/>
    						<input type="text" id="login" class="fadeIn second" name="email" placeholder="Email" required/>
    						<input type="password" id="password" class="fadeIn third" name="password" placeholder="Password" required/>
    						<input type="submit" class="fadeIn fourth" value="Register" />
    					</form>
    				</div>
    			</div>
    		</div>
    	</div>
</body>
</html>