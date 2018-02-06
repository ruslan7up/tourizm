<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.01.2018
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать маршрут</title>
    <style>
        #map {
            height: 50%;
        }

        #minfo {
            padding-left: 1%;
        }
    </style>
</head>
<body>
<h1>Создание маршрута</h1>
<div id="map"></div>
<hr>
<label for="title">Название маршрута</label>
<input type="text" id="title">
<hr>
<label>Страна</label>
<input type="text" id="country">
<br>
<label>Город</label>
<input type="text" id="city">
<hr>
<label>Описание маршрута</label>
<textarea placeholder="Описание" id="text">

</textarea>
<ol id="minfo">
</ol>

<input type="submit" value="Create route">
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBljBuDktCgyr8cEvDZvsXXD5PLTd0M-04&callback=initMap">
</script>
<script src="/resources/js/map.js"></script>
</body>

</html>
