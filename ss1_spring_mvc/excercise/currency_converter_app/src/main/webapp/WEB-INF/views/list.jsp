<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18/11/2022
  Time: 11:14 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang List</h1>

<form action="/app/converter" method="post">
    <input type="text" name="usd">
    <input type="submit" value="converter">
</form>

<p>
    Kết quả:${result}
</p>

</body>
</html>
