<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Create Account</title>
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <meta name="theme-color" content="#563d7c">


    <style>
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
            <a href="${pageContext.request.contextPath}/user" class="nav-link nav-item active">Moje dane</a>
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
        <h4>Moje dane</h4>
    </div>
    <div class="row">
        <form:form modelAttribute="user" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />

            <div class="form-group row">
                <label for="email" class="col-sm-4"> Email </label>
                <div class="col-sm-8">
                    <form:input readonly="true" path="email"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="firstName" class="col-sm-4">Imię</label>
                <div class="col-sm-8">
                    <form:input path="firstName"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="lastName" class="col-sm-4">Nazwisko</label>
                <div class="col-sm-8">
                    <form:input path="lastName"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="phone" class="col-sm-4">Telefon</label>
                <div class="col-sm-8">
                    <form:input path="phone"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-sm-4">Adres</label>
                <div class="col-sm-8">
                    <form:textarea path="address"/>
                </div>
            </div>
            </div>
        <form:hidden path="enabled" />
        <form:hidden path="reservationAccess" />
        <form:hidden path="password" />
        <form:hidden path="id" />
        <input type="submit" class="btn btn-outline-info" role="button" value="Zmień dane"/>
        </form:form>
    </div>
</body>
</html>
