$(function () {
    $(document).ready(function() {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
    
        var chart;
        $('#cpu').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function() {
    
                        // set up the updating of the chart each second
                        var series = this.series[0];
                        var series1 = this.series[1];
                        setInterval(function() {
                            var x = (new Date()).getTime(), // current time
                                y = (Math.random()*80)+7;
                            	z = (Math.random()*20)+3;
                            series.addPoint([x, y], false, true);
                            series1.addPoint([x, z], true, true);
                        }, 1000);
                    }
                }
            },
            title: {
                text: 'CPU Usage'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 100
            },
            plotOptions: {
            	spline: {
                    stacking: 'percent',
                    lineColor: '#000000',
                    lineWidth: 1,
                    marker: {
                        lineWidth: 1,
                        lineColor: '#ffffff'
                    }
                }
            },
            yAxis: {
                title: {
                    text: 'Percent(%)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
            name: 'Unuse',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -12; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: (Math.random()*90)+8
                    });
                }
                return data;
            })()
        },
        {
            name: 'CPU Usage',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -12; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: (Math.random()*10)+1
                    });
                }
                return data;
            })()
        }]
        });
    });
    
});