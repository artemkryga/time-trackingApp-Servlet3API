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
    <title><fmt:message key="title"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Time-Tracker</a>
        <div class="navbar-nav mr-auto">
            <li class="nav-item">
                <a href="index.jsp" class="nav-link">
                    <font-awesome-icon icon="home"/>
                    Home
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/signIn" class="nav-link">Sign In</a>
            </li>

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/signUp" class="nav-link">Sign Up</a>
            </li>
        </div>

        <div class="navbar-nav ml-auto">
            <li class="nav-item">

                <div class="input-group mb-3">

                    <form action="#" method="get">
                        <select name="ddlLanguage" class="custom-select" id="inputGroupSelect03">
                            <option value="en">English</option>
                            <option value="ru">Русский</option>
                        </select>

                        <div class="input-group-prepend">
                            <button class="btn btn-outline-secondary" type="submit"><fmt:message key="button"/></button>
                        </div>

                    </form>
                </div>
            </li>
        </div>
    </nav>

    <div class="container">
        <router-view/>
    </div>
</div>
</body>
</html>