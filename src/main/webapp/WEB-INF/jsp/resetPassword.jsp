<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <title>Reset password</title>
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
    </div>
  </div>
</nav>

<div class="container">
  <div>
    <h3>Zmiana hasła</h3>
  </div>

  <div class="row">
    <form:form modelAttribute="password" method="post">
      <form:errors path="*" cssClass="errorblock" element="div" />
      <div class="form-group row">
        <label for="password" class="col-sm-4"> Hasło </label>
        <div class="col-sm-8">
          <input type="password" name="password" id="password"/>
        </div>
      </div>
      <div class="form-group row">
        <label for="matchingPassword" class="col-sm-4"> Powtórz hasło</label>
        <div class="col-sm-8">
          <input type="password" name="matchingPassword" id="matchingPassword" />
        </div>
      </div>
      <input hidden name="email" value="${password.email}" />
      <input hidden name="token" value="${password.token}" />
      <input type="submit" class="btn btn-outline-info" role="button" value="Zmień hasło"/>
    </form:form>
  </div>

</div>
</body>
</html>
