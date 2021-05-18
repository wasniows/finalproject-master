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
            <a href="user" class="nav-link nav-item">Moje dane</a>
            <a href="reservation" class="nav-link nav-item active">Rezerwacje</a>
            <a href="reservation/user" class="nav-link nav-item">Moje rezerwacje</a>
            <a href="<c:out value='perform_logout'/>" class="nav-link nav-item ">Wyloguj</a>
        </div>
    </div>
</nav>

<div class="container pt-5">

   <div class="form-group row">
       <div class="col-4">
           <form action="${pageContext.request.contextPath}/reservation" method="get">
               <input class="btn-outline-info" type="date" name="date" value="${date}">
               <button type="submit" class=" btn-outline-info" >OK</button>
           </form>
       </div>
       <div class="col-8">

           <a class="btn btn-outline-info" href="reservation/add?date=${date}">Dodaj rezerację</a>
       </div>
   </div>

    <div>
        <table class="table" border="3">
            <thead>
            <tr>
                <th>Godz.</th>
                <th>kort 1</th>
                <th>kort 2</th>
                <th>kort 3</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items='${hours}' var="hour">
                    <tr>
                        <td>${hour.name}</td>
                        <td class="
                            <c:forEach items="${mapReservationsCort1}" var="item">
                                <c:if test="${hour.name.equals(item.key.name)}">
                                 ${item.value}
                                </c:if>
                            </c:forEach>
                                    "></td>
                        <td class="
                            <c:forEach items="${mapReservationsCort2}" var="item">
                                <c:if test="${hour.name.equals(item.key.name)}">
                                 ${item.value}
                                </c:if>
                            </c:forEach>
                                    "></td>
                        <td class="
                             <c:forEach items="${mapReservationsCort3}" var="item">
                                <c:if test="${hour.name.equals(item.key.name)}">
                                 ${item.value}
                                </c:if>
                            </c:forEach>
                                    "></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
  </div>
</main>
</body>
</html>