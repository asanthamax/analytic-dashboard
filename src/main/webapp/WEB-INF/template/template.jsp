<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Analytic dashboard for wso2 Identity server">
	<meta name="author" content="asantha">
	<meta name="keyword" content="Analytic,Dashboard,wso2,identity server,realtime,batch">

	<title>Analytic Dashboard</title>

	<!-- Bootstrap CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<!-- bootstrap theme -->
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet">
	<!--external css-->
	<!-- font icon -->
	<link href="${pageContext.request.contextPath}/resources/css/elegant-icons-style.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" />
	<!-- full calendar css-->
	<link href="${pageContext.request.contextPath}/resources/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
	<!-- easy pie chart-->
	<link href="${pageContext.request.contextPath}/resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- owl carousel -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.css" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
	<!-- Custom styles -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fullcalendar.css">
	<link href="${pageContext.request.contextPath}/resources/css/widgets.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/css/xcharts.min.css" rel=" stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />
<style>
   .dev-page{visibility: hidden;}            
</style>
</head>
<body>
    <section id="container" class="">
		<tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <section id="main-content">
            <section class="wrapper">
                <tiles:insertAttribute name="body" />
            </section>
        </section>
        <tiles:insertAttribute name="footer" />
	</section>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.4.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.min.js"></script>
   <script type="${pageContext.request.contextPath}/resources/text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
   <!-- bootstrap -->
   <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
   <!-- nice scroll -->
   <script src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.nicescroll.js" type="text/javascript"></script>
   <!-- charts scripts -->
   <script src="${pageContext.request.contextPath}/resources/assets/jquery-knob/js/jquery.knob.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.sparkline.js" type="text/javascript"></script>
   <script src="${pageContext.request.contextPath}/resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.js" ></script>
   <!-- jQuery full calendar -->
   <<script src="${pageContext.request.contextPath}/resources/js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
   <script src="${pageContext.request.contextPath}/resources/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
   <!--script for this page only-->
   <script src="${pageContext.request.contextPath}/resources/js/calendar-custom.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.rateit.min.js"></script>
   <!-- custom select -->
   <script src="${pageContext.request.contextPath}/resources/js/jquery.customSelect.min.js" ></script>
   <script src="${pageContext.request.contextPath}/resources/assets/chart-master/Chart.js"></script>

   <!--custome script for all page-->
   <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
   <!-- custom script for this page-->
   <script src="${pageContext.request.contextPath}/resources/js/sparkline-chart.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/easy-pie-chart.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery-jvectormap-1.2.2.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery-jvectormap-world-mill-en.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/xcharts.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.autosize.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.placeholder.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/gdp-data.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/morris.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/sparklines.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/charts.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>
   <script>

       //knob
       $(function() {
           $(".knob").knob({
               'draw' : function () {
                   $(this.i).val(this.cv + '%')
               }
           })
       });

       //carousel
       $(document).ready(function() {
           $("#owl-slider").owlCarousel({
               navigation : true,
               slideSpeed : 300,
               paginationSpeed : 400,
               singleItem : true

           });
       });

       //custom select box

       $(function(){
           $('select.styled').customSelect();
       });

       /* ---------- Map ---------- */
       $(function(){
           $('#map').vectorMap({
               map: 'world_mill_en',
               series: {
                   regions: [{
                       values: gdpData,
                       scale: ['#000', '#000'],
                       normalizeFunction: 'polynomial'
                   }]
               },
               backgroundColor: '#eef3f7',
               onLabelShow: function(e, el, code){
                   el.html(el.html()+' (GDP - '+gdpData[code]+')');
               }
           });
       });



   </script>
</body>
</html>