<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
   <head>
      <title>Создать заявку на авто</title>
   </head>
   <body>
      <h1>Создать заявку на авто</h1>
      <p><a href="/demo-client">Назад</a></p>

      <form:form id="add_order" action="/demo-client/add" method="post" modelAttribute="order">

        <form:select path="carId" form="add_order">
          <form:option value="-1">Выберите автомобиль</form:option>
          <c:forEach items="${cars}" var="car">
              <form:option value="${car.id}">${car.model} (${car.pricePerDay})</form:option>
          </c:forEach>
        </form:select>
        <form:errors path="carId"/>

        <p>Начало использования</p>
        <form:input path="startDate" type="date"/>
        <form:errors path="startDate"/>

        <p>Окончание использования</p>
        <form:input path="endDate" type="date"/>
        <form:errors path="endDate"/>
        <br>
        <p><input type="submit" value="Оформить"></p>
      </form:form>
   </body>

</html>
