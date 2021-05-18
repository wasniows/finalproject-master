<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add reservation</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="${pageContext.request.contextPath}/" class="nav-link nav-item">Start</a>
            <a href="${pageContext.request.contextPath}/user" class="nav-link nav-item">Moje dane</a>
            <a href="${pageContext.request.contextPath}/reservation" class="nav-link nav-item active">Rezerwacje</a>
            <a href="${pageContext.request.contextPath}/reservation/user" class="nav-link nav-item">Moje rezerwacje</a>
            <a href="<c:out value='${pageContext.request.contextPath}/perform_logout'/>" class="nav-link nav-item ">Wyloguj</a>
        </div>
    </div>
</nav>

<div class="container pt-5">

    <div class="alert alert-danger">
        <h5>${message}</h5>
    </div>


</div>
</main>
</body>
</html>
