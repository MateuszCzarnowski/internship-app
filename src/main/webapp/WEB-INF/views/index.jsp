<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Investments</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.canvasjs.min.js" />"></script>
    <script src="<c:url value="//paginationjs.com/dist/2.0.7/pagination.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/script.js" />"></script>

</head>
<body>
<div id="chart-container">
    <div id="chart"></div>
    <div id="date-range">
        <input id="date1">
        <input id="date2">
        <button id="submit" class="button">Submit</button>
    </div>
</div>
<div id="data-container">
    <div id="data"></div>
    <div id="pagination"></div>
</div>

</body>
</html>