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

<div class="container">
    <header class="jumbotron">
        <h3>
            <strong><fmt:message key="all.available.activities"/></strong>
        </h3>
    </header>

</div>
    </div>
<div class="container">
    <c:forEach items="${allActivities}" var="categ">
        <div class="alert alert-secondary" role="alert">${categ.nameCategory}</div>
                <div class="card-group">
                    <c:forEach items="${categ.activities}" var="act">
                        <c:if test="${act.status == 'WAIT'}">
                    <div>
                            <c:if test="${!act.userHas}">
                                <div
                                        class="card text-white bg-primary mb-3"
                                        style="max-width: 9rem;"
                                >
                                    <div class="card-header"><fmt:message key="can.add"/></div>
                                    <div class="card-body">
                                        <h5 class="card-title">${act.nameAct}</h5>
                                       <form method="post" action="${pageContext.request.contextPath}/user?nameActivity=${act.nameAct}&action=ADD">
                                        <button type="submit" disabled
                                                class="btn btn-success">
                                            <fmt:message key="wait"/>
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
                                                    <fmt:message key="add"/>
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
<header class="jumbotron">
    <h3>
        <strong><fmt:message key="my.activities"/></strong>
    </h3>
</header>
</div>
<div class="container">
    <c:forEach items="${allActivities}" var="categ">
        <div class="alert alert-secondary" role="alert">${categ.nameCategory}</div>
        <div class="card-group">
            <c:forEach items="${categ.activities}" var="act">
                <c:if test="${act.status == 'WAIT'}">
                    <div>
                        <c:if test="${act.userHas}">
                            <div
                                    class="card text-white bg-primary mb-3"
                                    style="max-width: 9rem;"
                            >
                                <div class="card-header"><fmt:message key="can.remove"/></div>
                                <div class="card-body">
                                    <h5 class="card-title">${act.nameAct}</h5>
                                    <form method="post" action="${pageContext.request.contextPath}/user?nameActivity=${act.nameAct}&action=DELETE">
                                        <button type="submit" disabled
                                                class="btn btn-danger">
                                            <fmt:message key="wait"/>
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </c:if>
                <c:if test="${act.status != 'WAIT'}">
                    <div>
                        <c:if test="${act.userHas}">
                            <div
                                    class="card text-white bg-primary mb-3"
                                    style="max-width: 9rem;"
                            >
                                <div class="card-header"><fmt:message key="can.remove"/></div>
                                <div class="card-body">
                                    <h5 class="card-title">${act.nameAct}</h5>
                                    <form method="post" action="${pageContext.request.contextPath}/user?nameActivity=${act.nameAct}&action=DELETE">
                                        <button type="submit"
                                                class="btn btn-danger">
                                            <fmt:message key="delete"/>
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