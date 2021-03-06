$(function () {
    var date1 = $("#date1");
    var date2 = $("#date2");
    var interest = $("#interest-rate");
    var amount = $("#amount");

    var chart = initializeChart();
    chart.options.title.text = "Investments rate over time vs percentage profits";

    date1.val("2015-01-01");
    date2.val("2016-04-01");
    amount.val("200");
    interest.val("5");


    getDataWithProfits(chart, date1, date2, interest, amount);


    $("#submit").click(function () {
        var dat1 = new Date(date1.val());
        var dat2 = new Date(date2.val());

        if (validateCompare(interest, amount, dat1, dat2)) {
            $("#submit").removeClass("btn-danger");
            $("#submit").addClass("btn-primary");
            getDataWithProfits(chart, date1, date2, interest, amount);
        } else {
            $("#submit").removeClass("btn-primary");
            $("#submit").addClass("btn-danger");

        }
    });

});


function getDataWithProfits(chart, date1, date2, interest, amount) {
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
    var numberOfMonths = endDate.getMonth() - startDate.getMonth() + (endDate.getFullYear() - startDate.getFullYear()) * 12;
    for (var i = 0; i < numberOfMonths; i++) {
        profitsList.push({
            x: new Date(currentDate.getFullYear(), currentDate.getMonth() + i, currentDate.getDay()),
            y: currentAmount
        });
        currentAmount = currentAmount + (currentAmount * parseInt(interest.val()) / 100 * 1 / 12);
    }

    chart.options.data[1].dataPoints = profitsList;
}

