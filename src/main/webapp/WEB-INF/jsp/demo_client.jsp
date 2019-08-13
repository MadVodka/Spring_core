<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/demo.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
  <title>Личный кабинет (демо режим)</title>
</head>
<body>
  <header>
    <h3>Личный кабинет (демо)</h3>
    <a href="/demo_admin">Админка (демо)</a>
  </header>
  <div class="auto_container">
      <c:choose>
        <c:when test="${orders.size()>0}">
          <table>
            <tr class="head">
              <th>Id заказа</th>
              <th>Модель автомобиля</th>
              <th>Начало аренды</th>
              <th>Окончание аренды</th>
            </tr>
          <c:forEach items="${orders}" var="order">
            <tr class="body">
              <td><c:out value="${order.id}" /></td>
              <td><c:out value="${cars[order.carId].model}" /></td>
              <td><c:out value="${order.startDate}" /></td>
              <td><c:out value="${order.endDate}" /></td>
            </tr>
          </c:forEach>
          </table>
          <br>
          <form>
            <input type="button" value="Оформить еще авто" onclick="window.location.href='/demo_client/add'" />
          </form>
        </c:when>

        <c:otherwise>
          <h4>Нет оформленных авто</h4>
          <form>
            <input type="button" value="Оформить авто" onclick="window.location.href='/demo_client/add'" />
          </form>
        </c:otherwise>
      </c:choose>
  </div>
  </body>
</html>
