$(function () {
        $('#heap').highcharts({
        	chart: {
                zoomType: 'x',
                spacingRight: 20,
                events: {
                    load: function() {
                        // set up the updating of the chart each second
                        var series = this.series[0];
                        setInterval(function() {
                            var x = (new Date()).getTime(), // current time
                                y = Math.random()*100;
                            series.addPoint([x, y], true, true);
                        }, 1000);
                    }
                }
            },
            title: {
                text: 'Heap Usage'
            },
            xAxis: {
                type: 'datetime',
                title: {
                    text: null
                }
            },
            yAxis: {
                title: {
                    text: 'Exchange rate'
                }
            },
            tooltip: {
                shared: true
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    lineWidth: 1,
                    marker: {
                        enabled: false
                    },
                    shadow: false,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
    
            series: [{
                type: 'area',
                name: 'USD to EUR',
                pointInterval: 24 * 3600 * 1000,
                pointStart: Date.UTC(2013, 12, 30),
                data: (function() {
                	
                	
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),i;
    
                    for (i = -19; i <= 0; i++) {
                    	$.ajax({
                    		contentType : "application/xml",
        					url : "HeapInfo2.xml",
        					success : function(xml) {
        						//xml을 jQuery로 감싸고 sample 노드를 찾 은 후 name 노드의 값을 반환
        						name = $(xml).find("heapinfo").find("heap").find("value").text();
        						//알림 메세지
//        						alert(name);

        					}
                    	});
                    	
                        data.push({
                            x: time + i * 1000,
                            y: Math.random()*100
                            	//name
                        });
                    }
                    return data;
                })()
            }]
        });
    });
    
