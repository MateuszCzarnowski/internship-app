<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kainos Internship App - Fund comparison</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/jquery.canvasjs.min.js"></script>
    <script src="resources/js/pagination.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/script-compare.js"></script>

</head>
<body>
<div id="chart-container">
    <div id="chart"></div>
    <div id="date-range">
        <input id="date1">
        <input id="date2">
        <button id="submit" class="button">Submit</button>
    </div>
    <div id="money-container">
        <input id="amount">
        <input id="interest-rate">
    </div>
</div>
<div id="data-container">
    <div id="data"></div>
    <div id="pagination"></div>
</div>

</body>
</html>