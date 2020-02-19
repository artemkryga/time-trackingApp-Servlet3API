<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="menu.jspf" %>
<div class="container-fluid">
    <c:if test="${error ne null}">
        <div class="alert alert-dismissible alert-${type}">
            <button type="button" class="close" data-dismiss="alert" aria-label="close" aria-hidden="true">&times;</button>
            <span>${error}</span>
        </div>
    </c:if>
    <c:remove var="error" scope="session"/>
    <c:remove var="type" scope="session"/>

    <div class="row">
        <div class="col-12 bg-dark text-light d-flex justify-content-center align-items-center" style="height: 100vh">
            <form action="signUp" method="post">
                <div class="form-group">
                    <label><fmt:message key="reg.username" /></label>
                    <input type="text" name="username" class="form-control" >
                </div>
                <div class="form-group">
                    <label><fmt:message key="reg.email" /></label>
                    <input type="email" name="email" class="form-control" aria-describedby="emailHelp">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label><fmt:message key="reg.password" /></label>
                    <input type="password" name="password" class="form-control">
                </div>

                <button type="submit" class="btn btn-primary"><fmt:message key="reg.signUp" /></button>
            </form>
        </div>
    </div>
</div>
</body>
