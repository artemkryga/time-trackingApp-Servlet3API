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
</head>
<body>
<%@ include file="menu.jspf" %>

<div id="app">
    <h1></h1>

    <table class="table" >
        <tr>
            <th><fmt:message key="admin.category"/></th>
            <th><fmt:message key="admin.activity"/></th>
            <th><fmt:message key="admin.time"/></th>
            <th><fmt:message key="admin.admin.action"/></th>

        </tr>

        <c:forEach items="${activitiesByUserList}" var="activity">
        <tr>
            <td>
                <h5>${activity.nameCateg}</h5>
            </td>
            <td>
                <h5>${activity.nameAct}</h5>
            </td>
           <form action="${pageContext.request.contextPath}/home?activity=${activity.nameAct}" method="post">
            <td>
                <input type="number" min="1" max="180" name="time" required>
            </td>

            <td>
                <c:if test="${activity.status != 'WAIT'}">
                <button class="btn btn-primary" type="submit"><fmt:message key="home.go"/></button>
                </c:if>
                <c:if test="${activity.status == 'WAIT'}">
                <button class="btn btn-primary" disabled type="submit"><fmt:message key="home.done"/></button>
                </c:if>
            </td>
           </form>
        </tr>
        </c:forEach>
    </table>
</div>
</body>

