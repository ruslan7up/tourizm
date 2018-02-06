<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.01.2018
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Маршруты</title>
    <style>
        .route {
            border: 2px dotted black;
            margin-top: 2%;
            width: 90%;
            margin-left: auto;
            margin-right: auto;

        }

        .title, .page {
            text-align: center;
        }

        .map {
            width: 70%;
            height: 50%;
            margin-left: auto;
            margin-right: auto;
        }

    </style>
</head>
<body>
    <c:forEach items="${routes}" var="route">
        <div class="route">
            <a href="/routes/view?id=${route.getId()}"><p class="title">${route.getTitle()}</p></a>
            <div class="map" route-id="${route.getId()}"></div>
        </div>
    </c:forEach>
    <div class="page"><c:if test="${(page-1)> 0}"><a href="/routes?page=${page-1}">&lt; </a></c:if> ${page} <c:if test="${page+1<=count}"><a href="/routes?page=${page+1}"> &gt;</a></c:if></div>
    <script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBljBuDktCgyr8cEvDZvsXXD5PLTd0M-04">
    </script>
    <script src="/resources/js/routes.js">
    </script>
</body>
</html>
