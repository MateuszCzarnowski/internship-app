

function simpleTemplating(data) {
    var html = '<table class="table table-striped table-bordered"><thead><th>Date</th><th>Value</th></thead><tbody>';
    $.each(data, function (index, item) {
        html += '<tr><td>' + item.x + '</td><td> ' + item.y + '</td></tr>';
    });
    html += '</tbody></table>';
    return html;
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

function validateCompare(interest, amount, dat1, dat2) {
    if (!isNaN(parseFloat(interest.val())) && !isNaN(parseFloat(amount.val())) && amount.val() !== "" && interest.val() !== "" && dat1 < dat2 && dat1 > new Date("1970-01-01") && dat2 < new Date("2100-01-01")) {
        return true;
    } else return false;

}

function validateIndex(dat1, dat2) {
    if (dat1 < dat2 && dat1 > new Date("1970-01-01") && dat2 < new Date("2100-01-01")) {
        return true;
    } else return false;

}