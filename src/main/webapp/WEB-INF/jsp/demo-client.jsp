<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/demo.css">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
  <title>Личный кабинет (демо режим)</title>
</head>
<body>
  <header>
    <h3>Личный кабинет (демо режим)</h3>
  </header>
  <div class="auto_container">
    <%-- <div> --%>
      <p>Нет оформленных авто</p>
      <button type="button" name="Оформить авто">Оформить авто</button>
    <%-- </div> --%>
  </div>
  <table>
    <tr>
      <td>Id</td>
      <td>Модель автомобиля</td>
      <td>Регистрационный номер</td>
      <td>Стоимость аренды (в сутки)</td>
    </tr>
  <c:forEach items="${cars}" var="car">
    <tr>
      <td><c:out value="${car.id}" /></td>
      <td><c:out value="${car.model}" /></td>
      <td><c:out value="${car.registrationNumber}" /></td>
      <td><c:out value="${car.pricePerDay}" /></td>
    </tr>
  </c:forEach>
</table>
  </body>
</html>
