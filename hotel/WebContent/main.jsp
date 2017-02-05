<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="EUC-KR">
<head>
<title>Bootstrap Test</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.min.js"></script><!-- 
<script type="text/javascript" src="js/bootstrap-datepicker.js"></script> -->
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">

<script>
$( document ).ready(function() {

    var dateFormat = "yy-mm-dd";

	function getDate( element ) {
	    var date;
	    try {
	    	console&&console.log("=================");
	    	console&&console.log(dateFormat);
	    	console&&console.log(element.value);
	        date = $.datepicker.parseDate( dateFormat, element.value );
	    	console&&console.log(date);
	    } catch( error ) {
	    	console&&console.log(error);
	      date = null;
	    }
    	console&&console.log("return " + date);
	    return date;
	}
	
    var from = $( "#mypicker123" )
      .datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        dateFormat:dateFormat
      })
      .on( "change", function() {
        to.datepicker( "option", "minDate", getDate( this ) );
      }),
    to = $( "#mypicker321" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      dateFormat:dateFormat
    })
    .on( "change", function() {
      from.datepicker( "option", "maxDate", getDate( this ) );
    });
    
   	$('#example').DataTable();
    var rlist = $('#reservelist').DataTable({
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 7 ],
                "visible": false
            },
            {
            	"targets": [ 8 ],
            	"visible": false
            }
        ]
    });
    $('#reservelist tbody').on('click', 'tr', function () {
        var data = rlist.row( this ).data();
        alert('예약id는 '+data[0]+'이고 목적은 '+data[7]+'이며 취소사유는 '+data[8]+'이다');
    } );
});
</script>
<style>
div.container {
    width: 100%;
}

body {
	padding-top: 60px;
}
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 650px;
	padding-bottom: 11px;
}
/*.row.content {height: 450px}*/

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	/*background-color: #404040;*/
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
<script>
</script>


</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Admin</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="cust.bs?cmd=list">고객</a></li>
					<li><a href="room.bs?cmd=list">객실</a></li>
					<li><a href="reserve.bs?cmd=list">예약</a></li>
					<li><a href="main.bs?view=sales">매출</a></li>
					<li><a href="main.bs?view=log">로그</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
<!-- 				<p>
					<a href="#">Link1</a>
				</p>
				<p>
					<a href="#">Link2</a>
				</p>
				<p>
					<a href="#">Link3</a>
				</p> -->
				<c:choose>
					<c:when test="${left==null }">
						<jsp:include page="home.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="${left }.jsp" />
					</c:otherwise>
				</c:choose>				
			</div>
			<div class="col-sm-8 text-left">
				<c:choose>
					<c:when test="${center==null }">
						<jsp:include page="home.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="${center }.jsp" />
					</c:otherwise>
				</c:choose>
				<!-- <div id="container"
					style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div> -->
				<hr>
				<h3>test</h3>
			</div>
			<!-- <div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
				 -->
		</div>
	</div>


	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>
