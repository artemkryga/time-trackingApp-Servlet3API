<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="current" value="${param.ddlLanguage}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${current}" scope="session"/>
</c:if>

<fmt:setBundle basename="messages" scope="session"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>App</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Time-Tracker</a>
        <div class="navbar-nav mr-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/home" class="nav-link">
                    <font-awesome-icon icon="home" /> Home
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin" class="nav-link">Admin Board</a>
            </li>

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user" class="nav-link">User Board</a>
            </li>
        </div>

        <div class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/profile" class="nav-link">
                    <font-awesome-icon icon="user" />
                    Current User
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                    <font-awesome-icon icon="sign-out-alt" />
                </a>
            </li>
        </div>
    </nav>

    <div class="container">
        <router-view />
    </div>
</div>
</body>
</html>