<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<table border="1" width="100%">
    <caption><b>ALL USERS INFORMATION</b></caption>
    <thead>
    <tr>
        <th width="33%">IP</th>
        <th width="33%">User-Agent</th>
        <th width="33%">Request time</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="currentUser" scope="request" type="ua.fan.model.User"/>
    <c:forEach var="user" items="${usersList}">
            <c:choose>
                <c:when test="${currentUser.ip == user.ip}">
                    <tr>
                    <td><b>${user.ip}</b></td>
                    <td><b>${user.userAgent}</b></td>
                    <td>${user.dateTime}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                    <td>${user.ip}</td>
                    <td>${user.userAgent}</td>
                    <td>${user.dateTime}</td>
                    </tr>
                </c:otherwise>
            </c:choose>

    </c:forEach>
    </tbody>
</table>
</body>
</html>