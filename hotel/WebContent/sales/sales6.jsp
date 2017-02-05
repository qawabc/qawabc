<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="js/jquery.js"></script><!-- 맨먼저 와야 한다. -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<style>
#main_center{
	width:800px;
	height:400px;
	background:white;
	margin: 0px auto;
}
#container{
	width:700px;
	height:300px;
}
</style>  
<script>
$(document).ready(function(){
	function display1(){//lineChart
	    Highcharts.chart('container', {
	        chart: {
	            type: 'column',
	            options3d: {
	                enabled: true,
	                alpha: 10,
	                beta: 25,
	                depth: 70
	            }
	        },
	        title: {
	            text: '상품별 가격 현황'
	        },
	        subtitle: {
	            text: '상품별 가격 현황'
	        },
	        plotOptions: {
	            column: {
	                depth: 25
	            }
	        },
	        xAxis: {
	        	//categories: data.name
	        	categories: ['바지', '상품', '니트']
	        },
	        yAxis: {
	            title: {
	                text: null
	            }
	        },
 	        series: [{
	            name: 'Price',
	            data: [1000, 2000, 30000]
	        }]
	        //series: data.price //-->
	    });
		
	};//end-display1	
	//------------------------------------------------	
	//ajax로 데이타 요청? --> 받은데이타를 hi-chart로 그린다.//AJAX의 한글깨짐???
	//alert('GET DATA ......!');
/*	$.ajax({
		url:'chart.bank',//chart servlet
		dataType:'json',
		success:function(data){
			//alert(data);
			display1(data);
		}
		
	});//end-ajax
*/
 display1();
});//end-ready
</script>
<h1>salesmenu6page</h1>
<div id="container">
</div>