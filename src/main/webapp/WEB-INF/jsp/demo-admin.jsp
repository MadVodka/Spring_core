<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/demo.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
  <title>Админка (демо режим)</title>
</head>
<body>
  <header>
    <h3>Админка (демо)</h3>
    <a href="/demo-client">Личный кабинет (демо)</a>
  </header>
  <h4>Имеющиеся автомобили</h4>
  <table>
    <tr>
      <td>Id автомобиля</td>
      <td>Модель автомобиля</td>
      <td>Регистрационный номер</td>
      <td>Цена аренды (в день)</td>
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

  <h4>Текущие заказы</h4>
  <c:choose>
    <c:when test="${orders.size()>0}">
      <table>
        <tr>
          <td>Id заказа</td>
          <td>Модель автомобиля</td>
          <td>Начало аренды</td>
          <td>Окончание аренды</td>
        </tr>
      <c:forEach items="${orders}" var="order">
        <tr>
          <td><c:out value="${order.id}" /></td>
          <td><c:out value="${cars[order.carId].model}" /></td>
          <td><c:out value="${order.startDate}" /></td>
          <td><c:out value="${order.endDate}" /></td>
        </tr>
      </c:forEach>
    </c:when>

    <c:otherwise>
      <p>Нет оформленных авто</p>
    </c:otherwise>
  </c:choose>
  </body>
</html>
