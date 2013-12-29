$(function () {
    $(thread).ready(function() {
        Highcharts.setOptions({
            global: {
            useUTC: false
            }
        });
    $('#thread').highcharts({
        chart: {
            type: 'areaspline',
            animation: Highcharts.svg, // don't animate in old IE
            marginRight: 10,
            events: {
                load: function() {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    var series2 = this.series[1];
                    var series3 = this.series[2];
                    var series4 = this.series[3];
                    var series5 = this.series[4];

                    setInterval(function() {
                        var x = (new Date()).getTime(), // current time
                            y = Math.random();
                            z = Math.random();
                            a = Math.random();
                            b = Math.random();
                            c = Math.random();
                        series.addPoint([x, y], false, true);
                        series2.addPoint([x,z], false, true);
                        series3.addPoint([x,a], false, true);
                        series4.addPoint([x,b], false, true);
                        series5.addPoint([x,c], true, true);
                    }, 1000);
                }
            }
        },

        title: {
            text: 'Thread'
        },
        xAxis: {
        	tickmarkPlacement: 'on',
            title:{
                text:'Time',
                enabled: false
                },
            type: 'datetime',
            tickPixelInterval: 100,
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
            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.percentage:.1f}%</b> ({point.y:,.0f} millions)<br/>',
            shared: true
        },
        plotOptions: {
            areaspline: {
                stacking: 'percent',
                lineColor: '#ffffff',
                lineWidth: 1,
                marker: {
                    lineWidth: 1,
                    lineColor: '#ffffff'
                }
            }
        },

        series: [{
            name: 'TooltipLevel1',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: Math.random()
                    });
                }
                return data;
            })()
        },
        {
            name: 'TooltipLevel2',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: Math.random()
                    });
                }
                return data;
            })()
        },
        {
            name: 'TooltipLevel3',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: Math.random()
                    });
                }
                return data;
                })()
        },
        {
        	name: 'TooltipLevel4',
        	data: (function() {
        		// generate an array of random data
        		var data = [],
        		time = (new Date()).getTime(),
        		i;

        		for (i = -19; i <= 0; i++) {
        			data.push({
        				x: time + i * 1000,
        				y: Math.random()
        			});
        		}
        		return data;
        	})()
        },
        {
        	name: 'TooltipLevel5',
        	data: (function() {
        		// generate an array of random data
        		var data = [],
        		time = (new Date()).getTime(),
        		i;

        		for (i = -19; i <= 0; i++) {
        			data.push({
        				x: time + i * 1000,
        				y: Math.random()
        			});
        		}
        		return data;
        	})()
        }],
        navigation: {
            menuItemStyle: {
                fontSize: '10px'
            }
        }
	});
    });
});  