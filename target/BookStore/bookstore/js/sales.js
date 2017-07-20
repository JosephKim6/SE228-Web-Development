const myChart = echarts.init(document.getElementById('chart'));



$('#searchUser').click(function () {
    var userID = $('#user').val();

    $.ajax({
        url: "searchSalesByUserPro",
        processData: true,
        data: {
            userID: userID
        },
        success: function (data) {
            var volume = 0;
            if (typeof(data) !== "object") {
                alert("Error! Please fill in all blanks!");
                return;
            }
            var parNode = document.getElementById("salesUserBody");
            var childs = parNode.childNodes;
            for(var i = childs.length - 1; i >= 0; i--) {
                parNode.removeChild(childs[i]);
            }
            var x = [];
            var y = [];
            for (i in data) {
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                td1.innerHTML = data[i][0];
                tr.appendChild(td1);
                var td2 = document.createElement("td");
                td2.innerHTML = data[i][1];
                tr.appendChild(td2);
                var td3 = document.createElement("td");
                td3.innerHTML = data[i][2];
                tr.appendChild(td3);
                var td4 = document.createElement("td");
                td4.innerHTML = data[i][3];
                tr.appendChild(td4);
                volume += data[i][2] * data[i][3];
                var td5 = document.createElement("td");
                td5.innerHTML = data[i][4];
                tr.appendChild(td5);
                parNode.appendChild(tr);
                volume = parseFloat((volume).toFixed(2));
                x.push(data[i][4]);
                y.push(data[i][2] * data[i][3]);
            }
            $("#userVolume").text(volume);
            const option = {
                title: {
                    text: 'Sales Chart'
                },
                tooltip: {      // mouse hover effect
                    trigger: 'axis',
                    position: function (pt) {
                        return [pt[0], '10%'];
                    }
                },
                legend: {
                    data:['Sales Volume']
                },
                xAxis: {
                    type: "category",
                    data: x,
                    boundaryGap: false
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name:'sales',
                        type:'line',
                        smooth:true,
                        symbol: 'none',
                        sampling: 'average',
                        itemStyle: {
                            normal: {
                                color: 'rgb(255, 70, 131)'
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgb(255, 158, 68)'
                                }, {
                                    offset: 1,
                                    color: 'rgb(255, 70, 131)'
                                }])
                            }
                        },
                        data: y
                    }
                ]
            };
            myChart.setOption(option);
        }
    });
});

$('#searchBook').click(function () {
    var bookID = $('#book').val();

    $.ajax({
        url: "searchSalesByBookPro",
        processData: true,
        data: {
            bookID: bookID
        },
        success: function (data) {
            var volume = 0;
            if (typeof(data) !== "object") {
                alert("Error! Please fill in all blanks!");
                return;
            }
            var parNode = document.getElementById("salesBookBody");
            var childs = parNode.childNodes;
            for(var i = childs.length - 1; i >= 0; i--) {
                parNode.removeChild(childs[i]);
            }
            var x = [];
            var y = [];
            for (i in data) {
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                td1.innerHTML = data[i][0];
                tr.appendChild(td1);
                var td2 = document.createElement("td");
                td2.innerHTML = data[i][1];
                tr.appendChild(td2);
                var td3 = document.createElement("td");
                td3.innerHTML = data[i][2];
                tr.appendChild(td3);
                var td4 = document.createElement("td");
                td4.innerHTML = data[i][3];
                tr.appendChild(td4);
                volume += data[i][2] * data[i][3];
                var td5 = document.createElement("td");
                td5.innerHTML = data[i][4];
                tr.appendChild(td5);
                parNode.appendChild(tr);
                volume = parseFloat((volume).toFixed(2));
                x.push(data[i][4]);
                y.push(data[i][2] * data[i][3]);
            }
            $("#bookVolume").text(volume);
            const option = {
                title: {
                    text: 'Sales Chart'
                },
                tooltip: {      // mouse hover effect
                    trigger: 'axis',
                    position: function (pt) {
                        return [pt[0], '10%'];
                    }
                },
                legend: {
                    data:['Sales Volume']
                },
                xAxis: {
                    type: "category",
                    data: x,
                    boundaryGap: false
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name:'sales',
                        type:'line',
                        smooth:true,
                        symbol: 'none',
                        sampling: 'average',
                        itemStyle: {
                            normal: {
                                color: 'rgb(255, 70, 131)'
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgb(255, 158, 68)'
                                }, {
                                    offset: 1,
                                    color: 'rgb(255, 70, 131)'
                                }])
                            }
                        },
                        data: y
                    }
                ]
            };
            myChart.setOption(option);
        }
    });
});

$('#searchDate').click(function () {
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();

    $.ajax({
        url: "searchSalesByDatePro",
        processData: true,
        data: {
            startDate: startDate,
            endDate: endDate
        },
        success: function (data) {
            var volume = 0;
            if (typeof(data) !== "object") {
                console.log(data);
                alert("Error! Please fill in all blanks!");
                return;
            }
            var parNode = document.getElementById("salesDateBody");
            var childs = parNode.childNodes;
            for(var i = childs.length - 1; i >= 0; i--) {
                parNode.removeChild(childs[i]);
            }
            var x = [];
            var y = [];
            for (i in data) {
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                td1.innerHTML = data[i][0];
                tr.appendChild(td1);
                var td2 = document.createElement("td");
                td2.innerHTML = data[i][1];
                tr.appendChild(td2);
                var td3 = document.createElement("td");
                td3.innerHTML = data[i][2];
                tr.appendChild(td3);
                var td4 = document.createElement("td");
                td4.innerHTML = data[i][3];
                tr.appendChild(td4);
                volume += data[i][2] * data[i][3];
                var td5 = document.createElement("td");
                td5.innerHTML = data[i][4];
                tr.appendChild(td5);
                parNode.appendChild(tr);
                volume = parseFloat((volume).toFixed(2));
                x.push(data[i][4]);
                y.push(data[i][2] * data[i][3]);
            }
            $("#dateVolume").text(volume);
            const option = {
                title: {
                    text: 'Sales Chart'
                },
                tooltip: {      // mouse hover effect
                    trigger: 'axis',
                    position: function (pt) {
                        return [pt[0], '10%'];
                    }
                },
                legend: {
                    data:['Sales Volume']
                },
                xAxis: {
                    type: "category",
                    data: x,
                    boundaryGap: false
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name:'sales',
                        type:'line',
                        smooth:true,
                        symbol: 'none',
                        sampling: 'average',
                        itemStyle: {
                            normal: {
                                color: 'rgb(255, 70, 131)'
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgb(255, 158, 68)'
                                }, {
                                    offset: 1,
                                    color: 'rgb(255, 70, 131)'
                                }])
                            }
                        },
                        data: y
                    }
                ]
            };
            myChart.setOption(option);
        }
    });
});