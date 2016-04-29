$(function () {
    var date1 = $("#date1");
    var date2 = $("#date2");

    var chart = initializeChart();
    chart.options.title.text = "Investments rate over time";

    date1.val("2015-01-01");
    date2.val("2016-04-01");

    getData(chart, date1, date2);

    $("#submit").click(function () {
        if(new Date(date1.val()) < new Date(date2.val())) {
            $("#submit").removeClass("btn-danger");
            $("#submit").addClass("btn-primary");
            getData(chart, date1, date2);
        } else {
            $("#submit").removeClass("btn-primary");
            $("#submit").addClass("btn-danger");
        }

    });

});


function getData(chart, date1, date2) {
    var resultList = [];
    $.ajax({
        url: "/getData/" + date1.val() + "/" + date2.val(),
        success: function (result) {
            var parsedResult = $.parseJSON(result);
            for (var obj in parsedResult) {
                resultList.push({x: new Date(parsedResult[obj].date), y: parsedResult[obj].value});
            }

            chart.options.data[0].dataPoints = resultList;
            chart.render();

            initializePagination(resultList);

        }

    });
}




