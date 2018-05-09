<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 03.05.18
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Passwords</title>
    <style>
        .error{color:red; background-color: yellow;}
    </style>
</head>
<body>

<form:form modelAttribute="password">
    <%--<form:errors path="*"/>--%>
    <p><label for="password">Podaj hasło</label></p>
    <p><form:input path="password" id="password"/></p>
    <p><form:errors path="password" cssClass="error"/></p>

    <p><button type="submit">Przestestuj</button></p>
</form:form>
<br>
<table>
    <tr>
        <th>Uwagi do hasła:</th>

    </tr>
    <c:forEach items="${messages}" var="message">
    <tr>
        <td>${message}</td>
    </tr>
</c:forEach>
</table>

<p><a href="../fin"><button>Podsumowanie</button></a></p>

</body>
</html>
