<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Investments</title>
</head>
<body>
<div align="center">
    <h2>Investments</h2>
    <table border="1">
        <th>id</th>
        <th>Date</th>
        <th>Value</th>

        <c:forEach var="investment" items="${investmentList}">
            <tr>
                <td>${investment.id}</td>
                <td>${investment.date}</td>
                <td>${investment.value}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>