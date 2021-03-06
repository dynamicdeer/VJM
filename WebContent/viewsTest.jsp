<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Views</title>
		<meta name="description" content="Views" />
		<meta name="keywords" content="icon grid, hover, responsive, portfolio, template" />
		<meta name="author" content="Codrops" />
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/views_style.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/ui.totop2.css">
		<script src="js/modernizr.custom.js"></script>
	</head>
	<body>
		<div class="drop_container">
			<header class="clearfix">
				<span>OFeeldeuk <span class="bp-icon bp-icon-about" data-content="OFEELDEUK is the team getting what they want."></span></span>
				<h1>VJM Views</h1>
				<nav>
					<a href="index.html" class="bp-icon bp-icon-drop" data-info="Home"><span>Home</span></a>
					<a href="report.html" class="bp-icon bp-icon-archive" data-info="Report"><span>Report</span></a>
				</nav>
			</header>
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span4">
							<h1>My Device</h1>
						</div>
						<div class="span8" id="device" style="min-width:400px; height:320px;"></div>
					</div>
					<div class="row-fluid">
						<div class="span4">
							<h1>CPU</h1>
						</div>
						<div class="span8" id="cpu" style="min-width:400px; height:320px;"></div>
					</div>
					<div class="row-fluid">
						<div class="span4">
							<h1>Heap/PermGen</h1>
						</div>
						<div class="span8" id="heap" style="min-width:400px; height:320px;"></div>
					</div>
					<div class="row-fluid">
						<div class="span4">
							<h1>Threads</h1>
						</div>
						<div class="span8" id="thread" style="min-width:400px; height:320px;"></div>
					</div>
				</div>
			</div>
		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/easing.js" type="text/javascript"></script>
		<script src="js/jquery.ui.totop2.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop2({ easingType: 'easeOutQuart' });
		});
		</script>
		<a href="#" id="toTop2" style="display: inline;"><span id="toTopHover2"></span>To Top</a>
    	<script src="js/bootstrap.min.js"></script>
    	<script src="js/myDeviceBar.js"></script>
    	<script src="js/cpuSpline.js"></script>
    	<script src="js/heapZomable.js"></script>
    	<script src="js/threadPercentChart.js"></script>
    	<script src="http://code.highcharts.com/highcharts.js"></script>
		<script src="http://code.highcharts.com/modules/exporting.js"></script>
	</body>
	<div class="drop_container">
	<footer>
		<nav>
			<p> © 2013 VJM By OFEELDEUK <a href="https://github.com/dynamicdeer/VJM"><i class="fa fa-github"></i></a></p>
		</nav>
	</footer>
	</div>
</html>
