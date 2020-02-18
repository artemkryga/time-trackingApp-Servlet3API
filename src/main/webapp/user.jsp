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

<div class="container">
<div>-------------------------</div>
<h3>All activities</h3>
<div>-------------------------</div>
    </div>
<div class="container">

    <c:forEach items="${allActivities}" var="categ">
            <h3>${categ.nameCategory}</h3>
                <div class="card-group">
                    <c:forEach items="${categ.activities}" var="act">
                        <c:if test="${act.status == 'WAIT'}">
                    <div>
                            <c:if test="${!act.userHas}">
                                <div
                                        class="card text-white bg-primary mb-3"
                                        style="max-width: 9rem;"
                                >
                                    <div class="card-header">Can add</div>
                                    <div class="card-body">
                                        <h5 class="card-title">${act.nameAct}</h5>
                                       <form method="post" action="${pageContext.request.contextPath}/user?nameActivity=${act.nameAct}&action=ADD">
                                        <button type="submit" disabled
                                                class="btn btn-success">
                                            wait
                                        </button>
                                       </form>
                                    </div>
                                </div>
                            </c:if>
                </div>
                        </c:if>
                        <c:if test="${act.status != 'WAIT'}">
                            <div>
                                <c:if test="${!act.userHas}">
                                    <div
                                            class="card text-white bg-primary mb-3"
                                            style="max-width: 9rem;"
                                    >
                                        <div class="card-header">Can add</div>
                                        <div class="card-body">
                                            <h5 class="card-title">${act.nameAct}</h5>
                                            <form method="post" action="${pageContext.request.contextPath}/user?nameActivity=${act.nameAct}&action=ADD">
                                                <button type="submit"
                                                        class="btn btn-success">
                                                    add
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
        </c:forEach>
</div>

<div class="container">
    <div>-------------------------</div>
    <h3>All activities</h3>
    <div>-------------------------</div>
</div>

<div class="container">
<c:forEach items="${allActivities}" var="categ">
    <h3>${categ.nameCategory}</h3>
    <div class="card-group">
        <c:forEach items="${categ.activities}" var="act">
            <div>

                <c:if test="${act.userHas}">
                    <div
                            class="card text-white bg-primary mb-3"
                            style="max-width: 9rem;"
                    >
                        <div class="card-header">Can remove</div>
                        <div class="card-body">
                            <h5 class="card-title">${act.nameAct}</h5>
                            <form method="post" action="${pageContext.request.contextPath}/user?nameActivity=${act.nameAct}&action=DELETE">
                            <button type="submit"
                                    class="btn btn-danger">
                                delete
                            </button>
                            </form>
                        </div>
                    </div>
                </c:if>

            </div
        </c:forEach>
    </div>
</c:forEach>
</div>

<h1>Statistics</h1>
<table class="table">
    <tr>
        <th>Activities</th>
        <th>Date</th>
        <th>Time</th>
    </tr>
    <c:forEach items="StatUser" var="currency">
    <tr>
        <td>
            <h5></h5>
        </td>
        <td>
            <h5></h5>
        </td>
        <td>
            <h5></h5>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
<style scoped>
    .card{
        margin:30px;
    }
    .container{
        text-align: center;
        margin-top:10px;
        margin-bottom: 30px;
        width: 80%;
    }

    .main{
        text-align: center;
        width: 100%;
    }
    button{
        margin-top: 20px;

    }
    .card:hover{
        background-color: green;
    }
    table{
        margin-top: 20px;
    }

</style>
</html>