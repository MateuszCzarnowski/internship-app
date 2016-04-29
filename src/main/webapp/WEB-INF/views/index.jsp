<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kainos Internship App - Investment fund</title>

    <link href="resources/css/normalize.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">

    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/jquery.canvasjs.min.js"></script>
    <script src="resources/js/pagination.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/commons.js"></script>
    <script src="resources/js/index.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div id="navbar">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/compare">Compare</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a>Kainos Internship App</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">

    <div id="chart-container" class="row">
        <div id="chart"></div>
        <div id="date-range">
            Date range:
            <input id="date1">
            -
            <input id="date2">
            <button id="submit" class="button">Submit</button>
        </div>
    </div>
    <div id="data-container" class="row">
        <div id="data"></div>
        <div id="pagination"></div>
    </div>
</div>
</body>
</html>