<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Bookess</a>
        <button class="navbar-toggler" type="button"
            data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active"
                    aria-current="page" href="${pageContext.request.contextPath}/">Home</a></li>
                <%
                String id = (String) session.getAttribute("email");
    
                if (id == null) {
                %>
                <li class="nav-item"><a class="nav-link" href="login">Login</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="register">Register</a>
                </li>
                <%}else{ %>
                <li class="nav-item"><a class="nav-link" href="logout">Logout</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="liked">Liked Books</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="read-later">Read Later Books</a>
                </li>
                <%} %>
                
            </ul>
        </div>
    </div>
</nav>