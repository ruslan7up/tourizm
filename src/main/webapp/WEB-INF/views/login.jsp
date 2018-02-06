<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.01.2018
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body onload='document.f.username.focus();'>
<h3>Авторизация</h3><form name='f' action='/auth' method='POST'>
    <table>
        <tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
        <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
    </table>
</form></body></html>
