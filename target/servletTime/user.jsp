<%@ include file="headerHome.jsp" %>

<table>
    <tr>
        <th>First Name</th>
    </tr>
    <c:forEach items="${activitiesFromDB}" var="activity">
        <tr>
            <td>${activity.nameCateg}</td>
            <td>${activity.nameAct}</td>

        </tr>
    </c:forEach>
</table>