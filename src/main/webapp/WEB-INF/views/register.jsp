<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.01.2018
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
    <sf:form method="POST" modelAttribute="user">
        <sf:label path="login">Логин</sf:label>
        <sf:input path="login"/>
        <sf:errors path="login"/>
        <br>
        <sf:label path="fullName">ФИО:</sf:label>
        <sf:input path="fullName"/>
        <sf:errors path="fullName"/>
        <br>
        <sf:label path="password">Пароль:</sf:label>
        <sf:input path="password"/>
        <sf:errors path="password"/>
        <br>
        <sf:label path="country">Страна:</sf:label>
        <sf:input path="country"/>
        <sf:errors path="country"/>
        <br>
        <sf:label path="city">Город:</sf:label>
        <sf:input path="city"/>
        <sf:errors path="city"/>
        <div class="g-recaptcha" data-sitekey="6LcBl0EUAAAAAEQAkRrQMIax6Mv8EgPQeYosqebc"></div>
        <c:if test="${recaptcha != null}">
            <span id="recaptcha.errors">Докажите, что вы не робот!</span>
        </c:if>
        <input type="submit" value="Create account">
    </sf:form>
</body>
</html>
