<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 22/11/2022
  Time: 5:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>CREATE USE FORM</h2>
<form:form action="/create-user" method="post" modelAttribute="user">
    <p>User name: </p>
    <form:input type="text" path="userName" />
    <p>Password:</p>
    <form:input type="text" path="passWord" />
    <p>Age:</p>
    <form:input type="text" path="age" />
    <br>
    <button type="submit">Create</button>
</form:form>
</body>
</html>
