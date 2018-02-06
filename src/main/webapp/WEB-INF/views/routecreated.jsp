<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.01.2018
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание маршрута</title>
</head>
<body>
<h1>Маршрут успешно создан и будет опубликован после проверки</h1>
<p>Через 5 секунд бы будете перенаправлены на главную страницу</p>
<a href="/">Если этого не произошло, нажмите сюда</a>
<script>
    window.setTimeout(function(){
        window.location.href = "/";
    }, 5000);
</script>
</body>
</html>
