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
    <link href="${pageContext.request.contextPath}/resources/css/dropzone.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fileupload.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fileupload-ui.css">
    <!-- CSS adjustments for browsers with JavaScript disabled -->
    <noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fileupload-noscript.css"></noscript>
    <noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fileupload-ui-noscript.css"></noscript>
    <!-- Custom styles -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
    <!-- bootstrap -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dropzone.js"></script>
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
    <script src="//blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script>
    <!-- The Canvas to Blob plugin is included for image resizing functionality -->
    <script src="//blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
    <!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <!-- blueimp Gallery script -->
    <script src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
    <!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.iframe-transport.js"></script>
    <!-- The basic File Upload plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
    <!-- The File Upload processing plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload-process.js"></script>
    <!-- The File Upload image preview & resize plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload-image.js"></script>
    <!-- The File Upload audio preview plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload-audio.js"></script>
    <!-- The File Upload video preview plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload-video.js"></script>
    <!-- The File Upload validation plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload-validate.js"></script>
    <!-- The File Upload user interface plugin -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload-jquery-ui.js"></script>
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