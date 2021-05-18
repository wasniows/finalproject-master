<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin panel</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="${pageContext.request.contextPath}/" class="nav-link nav-item">Start</a>
            <a href="user" class="nav-link nav-item">Moje dane</a>
            <a href="reservation" class="nav-link nav-item">Rezerwacje</a>
            <a href="reservation/user" class="nav-link nav-item">Moje rezerwacje</a>
            <a href="${pageContext.request.contextPath}/checkadmin" class="nav-link nav-item active">Panel admina</a>
            <a href="<c:out value='perform_logout'/>" class="nav-link nav-item ">Wyloguj</a>
        </div>
    </div>
</nav>

<div class="container pt-5">

    <div>
        <table class="table" border="3">
            <thead>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
                <th>Telefon</th>
                <th>Dostęp do rezerwacji</th>
                <td>Operacja</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items='${users}' var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.reservationAccess}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/useraccess/${user.id}">Zmień dostęp</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</main>
</body>
</html>