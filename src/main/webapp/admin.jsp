<%@ include file="headerHome.jsp" %>

<table>
    <tr>
        <th>First Name</th>
    </tr>
    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>