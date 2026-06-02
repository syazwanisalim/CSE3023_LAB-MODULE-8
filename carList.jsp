<%-- 
    Document   : carList
    Created on : 2 Jun 2026, 3:52:40 pm
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.model.Car" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<h2>Car List</h2>



<a href="new">Add Car</a>

<table border="1">
<tr>
    <th>ID</th><th>Brand</th><th>Model</th>
    <th>Cylinder</th><th>Price</th><th>Action</th>
</tr>

<c:forEach var="car" items="${listCars}">
<tr>
    <td>${car.car_id}</td>
    <td>${car.brand}</td>
    <td>${car.model}</td>
    <td>${car.cylinder}</td>
    <td>${car.price}</td>
    <td>
        <a href="edit?id=${car.car_id}">Edit</a>
        <a href="delete?id=${car.car_id}">Delete</a>
    </td>
</tr>
</c:forEach>
</table>