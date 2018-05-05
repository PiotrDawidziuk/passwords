<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 03.05.18
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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


    <p><label for="user">User</label></p>
    <p><form:select path="user.id" items="${users}" itemValue="id" itemLabel="username"/></p>
    <p><form:errors path="user.id" cssClass="error"/></p>

    <p><button type="submit">Zarejestruj</button></p>
</form:form>


</body>
</html>
