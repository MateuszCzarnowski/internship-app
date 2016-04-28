$(function () {
    var date1 = $("#date1");
    var date2 = $("#date2");
    var interest = $("#interest-rate");
    var amount = $("#amount");

    var chart = initializeChart();

    date1.val("2015-01-01");
    date2.val("2016-04-01");
    amount.val("200");
    interest.val("5");


    sendRequest(chart, date1, date2, interest, amount);


    $("#submit").click(function () {
        sendRequest(chart, date1, date2, interest, amount);
    });

});


function sendRequest(chart, date1, date2, interest, amount) {
    var resultList = [];
    $.ajax({
        url: "/getData/" + date1.val() + "/" + date2.val(),
        success: function (result) {
            var parsedResult = $.parseJSON(result);
            for (var obj in parsedResult) {
                resultList.push({x: new Date(parsedResult[obj].date), y: parsedResult[obj].value});
            }

            chart.options.data[0].dataPoints = resultList;
            calculateProfits(chart, amount, interest, date1, date2);
            chart.render();

            initializePagination(resultList);

        }

    });
}
function calculateProfits(chart, amount, interest, date1, date2) {

    var profitsList = [];

    var startDate = new Date(date1.val());
    var endDate = new Date(date2.val());

    var currentDate = startDate;
    var currentAmount = parseInt(amount.val());
    console.log(currentDate.getFullYear());
    var numberOfMonths = endDate.getMonth() - startDate.getMonth() + (endDate.getFullYear() - startDate.getFullYear())*12;
    for (var i = 0; i < numberOfMonths; i++) {
        profitsList.push({x: new Date(currentDate.getFullYear(), currentDate.getMonth() + i, currentDate.getDay()), y: currentAmount});
        currentAmount = currentAmount + (currentAmount * parseInt(interest.val()) / 100 * 1/12);
    }
    //profitsList.push({ x: startDate, y: parseInt(amount.val())});
    //profitsList.push({ x: new Date("2015-02-01"), y: parseInt(amount.val())*1.05});

    chart.options.data[1].dataPoints = profitsList;
    console.log(chart.options.data[0].dataPoints);
    console.log(chart.options.data[1].dataPoints);

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
                },
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