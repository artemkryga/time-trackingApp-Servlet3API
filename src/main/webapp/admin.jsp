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
<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    <li class="nav-item">
        <a
                class="nav-link active"
                id="pills-home-tab"
                data-toggle="pill"
                href="#pills-home"
                role="tab"
                aria-controls="pills-home"
                aria-selected="true"
        ><fmt:message key="admin.user.statistics"/></a>
    </li>
    <li class="nav-item">
        <a
                class="nav-link"
                id="pills-profile-tab"
                data-toggle="pill"
                href="#pills-profile"
                role="tab"
                aria-controls="pills-profile"
                aria-selected="false"
        ><fmt:message key="admin.user.choice"/></a>
    </li>
</ul>
<div class="tab-content" id="pills-tabContent">
    <div
            class="tab-pane fade show active"
            id="pills-home"
            role="tabpanel"
            aria-labelledby="pills-home-tab"
    >
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">username</span>
            </div>
            <input
                    type="text"
                    class="form-control"
                    id="basic-url"
                    aria-describedby="basic-addon3"
            />
            <div class="input-group-append">
                <button
                        class="btn btn-outline-secondary"
                        type="button"
                        id="button-addon2"
                        @change="findUser()"
                ><fmt:message key="admin.search"/></button>
            </div>
        </div>


    </div>
    <div
            class="tab-pane fade"
            id="pills-profile"
            role="tabpanel"
            aria-labelledby="pills-profile-tab"
    >
        <table class="table table-hover">
            <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th><fmt:message key="admin.name.activity"/></th>
                <th><fmt:message key="admin.action"/></th>
                <th><fmt:message key="admin.yes"/></th>
                <th><fmt:message key="admin.no"/></th>
            </tr>
            </thead>
            <c:forEach items="${persistenses}" var="persistense">
<%--            v-for="user of todos" :key="user.userName"--%>
            <tbody >
<%--            v-if="user.activities.length!=0"--%>

            <c:if test="${persistense.activities.size() != 0 }">
            <tr>
                <td align="center" colspan="5">
                    <h3>${persistense.userName}</h3>
                </td>
            </tr>
            </c:if>
            <!--v-for="activity of user.activities" :key="activity.nameAct"-->
            <c:forEach items="${persistense.activities}" var="activity">
            <tr >
                <td>1</td>
                <td>${activity.nameAct}</td>
                <td>${activity.action}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin?accept=1&action=${activity.action}&nameActivity=${activity.nameAct}&username=${persistense.userName}&id=${activity.id}"

                          method="post">
                    <button type="submit" class="btn btn-success"><fmt:message key="admin.accept"/></button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin?decline=1&action=${activity.action}&nameActivity=${activity.nameAct}&username=${persistense.userName}&id=${activity.id}"
                          method="post">
                    <button
                            type="submit"
                            class="btn btn-danger"
                    ><fmt:message key="admin.decline"/></button>
                    </form>
                </td>
            </tr>
            </c:forEach>
            </tbody>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
