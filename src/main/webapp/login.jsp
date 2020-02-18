<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%@ include file="menu.jspf" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-12 bg-warning text-light d-flex justify-content-center align-items-center" style="height: 100vh">
            <form action="signIn" method="post">
                <div class="form-group">
                    <label><fmt:message key="reg.email" /></label>
                    <input type="text" name="email" class="form-control" >
                </div>
                <div class="form-group">
                    <label><fmt:message key="reg.password" /></label>
                    <input type="password" name="password" class="form-control">
                </div>

                <button type="submit" class="btn btn-primary"><fmt:message key="reg.signIn" /></button>

            </form>
        </div>
    </div>
</div>
</body>
