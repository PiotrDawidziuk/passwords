<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 08.05.18
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Podsumowanie</title>
    <link href="/static/stylesheet.css" rel="stylesheet" media="screen">

</head>
<body>
<table class="list">
    <tr>
        <th>Lista Twoich haseł:</th>

    </tr>
    <c:forEach items="${passwords}" var="password">
        <tr>
            <td>${password.password}</td>
        </tr>
    </c:forEach>
</table>

<p>Twój e-mail, login i wszystkie twoje hasła zostały zapisane do bazy danych.</p>
<p>Gdybyś zrobił takie coś na innej stronie, to ktoś
    mógłby ich użyć, żeby włamać sie na twoją pocztę lub Facebooka!</p>

<p class="messages">Pamiętaj: nigdy nie podawaj swoich loginów i haseł osobom trzecim!</p>

<p><a href="/" class="button">Jeszcze raz!</a>
<a href="../delete/${user_id}" class="button">Usuń moje dane</a>
</p>


</body>
</html>
