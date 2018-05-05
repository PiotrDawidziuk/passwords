<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 03.05.18
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Registration</title>
    <style>
        .error{color:red; background-color: yellow;}
    </style>
</head>
<body>


<form:form modelAttribute="user">
    <%--<form:errors path="*"/>--%>
    <p><label for="username">Nazwa użytkownika</label></p>
    <p><form:input path="username" id="username"/></p>
    <p><form:errors path="username" cssClass="error"/></p>


    <%--<p><label for="passwords">Password</label></p>--%>
    <%--<p><form:password path="passwords" id="passwords"/></p>--%>
    <%--<p><form:errors path="passwords" cssClass="error"/></p>--%>

    <p><label for="email">E-Mail</label></p>
    <p><form:input path="email" id="email"/></p>

    <p><button type="submit">Zarejestruj</button></p>
</form:form>



</body>
</html>
