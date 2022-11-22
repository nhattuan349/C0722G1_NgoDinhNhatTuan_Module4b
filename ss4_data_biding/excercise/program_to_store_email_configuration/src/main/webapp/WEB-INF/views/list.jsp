<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 22/11/2022
  Time: 11:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="email" action="email/emailUpdate" method="post" >
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="languages">
                    <form:options items="${languageList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>
                <span>Show</span>
                <form:select path="pageSize">
                    <form:options items="${pageSizeList}" />
                </form:select>
                <span>emails per page</span>
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:checkboxes path="spamsFilter" items="${spamsFilterList}" />
                <span>Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"></td>
            <td><input type="reset" value="cancel"></td>

        </tr>
    </table>

</form:form>

</body>
</html>
