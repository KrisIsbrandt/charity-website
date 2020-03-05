<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>" />
</head>
<body>
<header>
    <%@include file="../fragments/headerLoggedUser.jsp"%>
</header>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h2>Twój profil</h2>

        Imię: ${user.firstName}<br>
        Nazwisko: ${user.lastName}<br>
        Email: ${user.email}<br>
        <h2></h2>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../../resources/js/app.js"></script>
</body>
</html>
