<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 22/11/2022
  Time: 11:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/email">Back to List</a></h3>

<h2>Update</h2>
<h3 style="color: green">${message}</h3>
<table>
    <tr>
        <td>Language:</td>
        <td>${email.languages}</td>
    </tr>

    <tr>
        <td>Page Size:</td>
        <td>${email.pageSize}</td>
    </tr>

    <tr>
        <td>Spam Fillter:</td>
        <td>${email.spamsFilter}</td>
    </tr>

    <tr>
        <td>signature:</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
