<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Login</title>
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <meta name="theme-color" content="#563d7c">


    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="navbar-top.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-nav">
            <a href="${pageContext.request.contextPath}/" class="nav-link nav-item">Start</a>
            <a href="${pageContext.request.contextPath}/user" class="nav-link nav-item">Moje dane</a>
            <a href="${pageContext.request.contextPath}/reservation" class="nav-link nav-item">Rezerwacje</a>
            <a href="${pageContext.request.contextPath}/reservation/user" class="nav-link nav-item">Moje rezerwacje</a>
            <a href="${pageContext.request.contextPath}/account" class="nav-link nav-item">Zarejestruj się</a>
            <a href="${pageContext.request.contextPath}/checkadmin" class="nav-link nav-item">Panel admina</a>
            <a href="<c:out value='perform_logout'/>" class="nav-link nav-item ">Wyloguj</a>
        </div>
    </div>
</nav>

<div class="container">
    <div>
        <h4>Logowanie</h4>
    </div>

    <c:if test="${not empty param.logout}" >
        <div class="alert alert-success" role="alert">
            Wylogowano!
        </div>
    </c:if>

    <div class="error">
        <c:if test="${not empty param.error}" > Błędne dane logowania</c:if>
    </div>

<div class="row">
    <form:form action="perform_login" method="post">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <div class="form-group row">
            <label for="username" class="col-sm-4"> Email </label>
            <div class="col-sm-8">
                <input type="text" name="username" id="username"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="password" class="col-sm-4"> Hasło </label>
            <div class="col-sm-8">
                <input type="password" name="password" id="password"/>
            </div>
        </div>
        <input type="submit" class="btn btn-outline-info" role="button" value="Zaloguj"/>
        <a href="password">Zmiana hasła</a>
    </form:form>
</div>
</div>
</body>
</html>