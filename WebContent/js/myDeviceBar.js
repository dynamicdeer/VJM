$(function () {
        $('#device').highcharts({
            chart: {
                type: 'bar'
            },
            title: {
                text: 'My Device Status'
            },
            xAxis: {
                categories: ['CPU','Memory']
            },
            yAxis: {
                min: 0,
            },
            legend: {
                backgroundColor: '#FFFFFF',
                reversed: true
            },
            plotOptions: {
                series: {
                    stacking: 'normal'
                }
            },
                series: [{
                name: 'Idle',
                data: [60, 30]
            }, {
                name: 'Use',
                data: [40, 70]
            }]
        });
    });
    
