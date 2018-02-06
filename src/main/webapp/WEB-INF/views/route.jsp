<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.01.2018
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Просмотр маршрута</title>
    <style>
        #map {
            width: 60%;
            height: 60%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<h1>${route.getTitle()}</h1>
<div route-id="${route.getId()}" id="map"></div>
<p class="text">${route.getText()}</p>
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBljBuDktCgyr8cEvDZvsXXD5PLTd0M-04">
</script>
<script src="/resources/js/route.js"></script>

</body>
</html>
