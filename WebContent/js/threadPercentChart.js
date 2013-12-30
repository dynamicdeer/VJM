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
                            y = (Math.random()*10)+30;
                            z = (Math.random()*20)+50;
                            a = (Math.random()*5)+20;
                            b = Math.random()*0.8;
                            c = Math.random()*0.1;
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
            tickPixelInterval: 150,
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
            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.percentage:.1f}%</b> ({point.y:,.0f})<br/>',
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
            name: 'Runnable',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: (Math.random()*10)+30
                    });
                }
                return data;
            })()
        },
        {
            name: 'Waiting',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: (Math.random()*20)+50
                    });
                }
                return data;
            })()
        },
        {
            name: 'Sleeping',
            data: (function() {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i++) {
                    data.push({
                        x: time + i * 1000,
                        y: (Math.random()*5)+20
                    });
                }
                return data;
                })()
        },
        {
        	name: 'Blocked',
        	data: (function() {
        		// generate an array of random data
        		var data = [],
        		time = (new Date()).getTime(),
        		i;

        		for (i = -19; i <= 0; i++) {
        			data.push({
        				x: time + i * 1000,
        				y: Math.random()*0.8
        			});
        		}
        		return data;
        	})()
        },
        {
        	name: 'Terminated',
        	data: (function() {
        		// generate an array of random data
        		var data = [],
        		time = (new Date()).getTime(),
        		i;

        		for (i = -19; i <= 0; i++) {
        			data.push({
        				x: time + i * 1000,
        				y: Math.random()*0.5
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