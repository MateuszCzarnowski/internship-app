<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kainos Internship App - Fund comparison</title>

    <link href="resources/css/normalize.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/jquery.canvasjs.min.js"></script>
    <script src="resources/js/pagination.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/commons.js"></script>
    <script src="resources/js/compare.js"></script>

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
            <label for="date1">From:</label>
            <input id="date1" class="form-control">
            <label for="date2"> To:</label>
            <input id="date2" class="form-control">
        </div>
        <div id="money-container">
            <label for="amount">Amount:</label>
            <input id="amount" class="form-control">
            <label for="interest-rate">Interest rate:</label>
            <input class="form-control" id="interest-rate"><b>%</b>
        </div>
        <button id="submit" class="btn btn-primary center-block">Submit</button>
    </div>
    <br>
    <div id="data-container" class="row">
        <div id="data"></div>
        <div id="pagination"></div>
    </div>
</div>
</body>
</html>