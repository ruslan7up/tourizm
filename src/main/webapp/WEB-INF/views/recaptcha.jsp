<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.01.2018
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<form method="post" action="/recaptcha">
    <input type="text" title="title"/>
    <div class="g-recaptcha" data-sitekey="6LcBl0EUAAAAAEQAkRrQMIax6Mv8EgPQeYosqebc"></div>
    <button type="submit">submit</button>
</form>
</body>
</html>
