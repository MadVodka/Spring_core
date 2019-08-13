<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
   <head>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/demo.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
     <title>Создать заявку на авто</title>
   </head>
   <body>
        <header>
            <h3>Создать заявку на авто</h3>
            <a href="/demo_client">Назад</a>
        </header>
        <form:form id="add_order" action="/demo_client/add" method="post" modelAttribute="order">
            <p>Выберите автомобиль</p>
            <form:select path="carId" form="add_order">
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
