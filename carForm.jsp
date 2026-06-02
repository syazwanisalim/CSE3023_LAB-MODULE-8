<%-- 
    Document   : carForm
    Created on : 2 Jun 2026, 3:53:39 pm
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<form action="${car != null ? 'update' : 'insert'}" method="post">

<c:if test="${car != null}">
    <input type="hidden" name="id" value="${car.car_id}">
</c:if>

Brand: <input type="text" name="brand" value="${car.brand}"><br>
Model: <input type="text" name="model" value="${car.model}"><br>
Cylinder: <input type="number" name="cylinder" value="${car.cylinder}"><br>
Price: <input type="text" name="price" value="${car.price}"><br>

<button type="submit">Save</button>

</form>
