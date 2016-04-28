$(function () {
    var data1 = "2015-07-01";
    var data2 = "2016-01-01";
    var resultList = [];
    $.ajax({
        url: "/getData/" + data1 + "/" + data2,
        success: function (result) {
            var parsedResult = $.parseJSON(result);
            for (var obj in parsedResult) {
                resultList.push({x: new Date(parsedResult[obj].date), y: parsedResult[obj].value});
            }
            //console.log(resultList);
            //$("#data").html(resultList);
            console.log(resultList[0]);
            var chart = new CanvasJS.Chart("chart",
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

                            dataPoints: resultList
                        }

                    ]
                });

            chart.render();
        }


    });


})
;
