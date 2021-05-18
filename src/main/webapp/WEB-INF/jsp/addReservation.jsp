<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add reservation</title>
    <style>
        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

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
            <a href="${pageContext.request.contextPath}/reservation" class="nav-link nav-item">Rezerwacje</a>
            <a href="<c:out value='${pageContext.request.contextPath}/perform_logout'/>" class="nav-link nav-item ">Wyloguj</a>
        </div>
    </div>
</nav>
<div class="container pt-5">

        <form:form method="post" modelAttribute="reservation">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <div class="row">
                <div class="form-group col-6">
                    <label for="date" >Data</label>
<%--                    <input id="date" class="btn-outline-info" type="date" name="date" value="${reservation.date} ">--%>
                    <form:input type="date" path="date" name="date" cssClass="form-control" />
                    <small><form:errors path="date"  cssClass="alert-danger"/></small>
                </div>
                <div class="form-group col-6">
                    <label for="court">Kort</label>
                    <form:select path="court" items="${courts}" itemValue="id" itemLabel="name" cssClass="form-control"/>
                    <small><form:errors path="court" cssClass="alert-danger"/></small>
                </div>
            </div>
            <div class="row">

                <div class="form-group col-6">
                    <label for="hours">Godziny</label>
                    <form:select path="hours" items="${hours}" itemValue="id" itemLabel="name" multiple="true" cssClass="form-control"/>
                    <small><form:errors path="hours" cssClass="alert-danger"/></small>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-outline-info" >Rezerwuj</button>
        </form:form>
</div>
</body>
</html>
