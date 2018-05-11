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
        .error {
            color:#990000;
            /*background-color: lightgray;*/
        }    </style>
    <link href="/static/stylesheet.css" rel="stylesheet" media="screen">

</head>
<body>
<p class="center">Podaj e-mail i nazwę uzytkownika, której zwykle używasz na forach lub innych stronach internetowych.</p>

<form:form modelAttribute="user" class="center">
    <%--<form:errors path="*"/>--%>
    <p><label for="username">Nazwa użytkownika</label></p>
    <p><form:input path="username" id="username"/></p>
    <p><form:errors path="username" cssClass="error"/></p>


    <p><label for="email">E-Mail</label></p>
    <p><form:input path="email" id="email"/></p>
    <p><form:errors path="email" cssClass="error"/></p>


    <p><button class="button" type="submit">Dalej</button></p>


</form:form>


</body>
</html>
