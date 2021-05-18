<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <meta name="theme-color" content="#563d7c">

    <!-- Custom styles for this template -->
    <link href="navbar-top.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="${pageContext.request.contextPath}/" class="nav-link nav-item active">Start</a>
            <a href="${pageContext.request.contextPath}/user" class="nav-link nav-item">Moje dane</a>
            <a href="${pageContext.request.contextPath}/reservation" class="nav-link nav-item">Rezerwacje</a>
            <a href="${pageContext.request.contextPath}/reservation/user" class="nav-link nav-item">Moje rezerwacje</a>
            <a href="${pageContext.request.contextPath}/account" class="nav-link nav-item">Zarejestruj się</a>
            <a href="${pageContext.request.contextPath}/checkadmin" class="nav-link nav-item">Panel admina</a>
            <a href="<c:out value='perform_logout'/>" class="nav-link nav-item ">Wyloguj</a>
        </div>
    </div>
</nav>

<div class=" bg-success text-white">
    <div class="container">
        <h3 class="display-4">Klub tenisowy GEM SET MECZ</h3>
    </div>
</div>
<div class="container align-content-center">
    <img src="assets/img/court.jpg" alt="court.jpg">
</div>
</body>
</html>