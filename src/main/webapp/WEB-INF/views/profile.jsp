<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.01.2018
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <style>
        th,td {
            border:1px solid;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Логин</th>
        <td>${user.getLogin()}</td>
    </tr>
    <tr>
        <th>ФИО</th>
        <td>${user.getFullName()}</td>
    </tr>
    <tr>
        <th>Страна</th>
        <td>${user.getCountry()}</td>
    </tr>
    <tr>
        <th>Город</th>
        <td>${user.getCity()}</td>
    </tr>
</table>
</body>
</html>
