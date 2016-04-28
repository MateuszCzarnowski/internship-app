$(function () {
    var date1 = $("#date1");
    var date2 = $("#date2");

    var chart = initializeChart();

    date1.val("2015-01-01");
    date2.val("2016-04-01");

    sendRequest(chart, date1, date2);

    $("#submit").click(function () {
        sendRequest(chart, date1, date2);
    });

});


function sendRequest(chart, date1, date2) {
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

function initializeChart() {
    return new CanvasJS.Chart("chart",
        {

            title: {
                text: "Investments rate over time"
            },
            axisY: {
                includeZero: false
            },
            data: [
                {
                    type: "line",

                    dataPoints: null
                }

            ]
        }
    );
}

function initializePagination(resultList) {
    $('#pagination').pagination({
        dataSource: resultList,
        pageSize: 20,
        formatResult: function (data) {
            for (var i = 0, len = data.length; i < len; i++) {
                data[i].x = data[i].x.toString().substring(4, 15);
            }
        },
        callback: function (data, pagination) {
            var html = simpleTemplating(data);
            $("#data").html(html);
        }
    });
}

function simpleTemplating(data) {
    var html = '<table class="table table-striped table-bordered"><thead><th>Date</th><th>Value</th></thead><tbody>';
    $.each(data, function (index, item) {
        html += '<tr><td>' + item.x + '</td><td> ' + item.y + '</td></tr>';
    });
    html += '</tbody></table>';
    return html;
}