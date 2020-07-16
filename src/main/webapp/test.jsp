<%--
  Created by IntelliJ IDEA.
  User: Huangwk
  Date: 2020/7/11
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>

<body>
<form action="/users" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="text" name="id"/>
    <input type="text" name="userName"/>
    <button type="submit">submit</button>
</form>

</body>
</html>
