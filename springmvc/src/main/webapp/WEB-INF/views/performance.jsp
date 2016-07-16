<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header"><i class="fa fa fa-bars"></i> Pages</h3>
			<ol class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
				<li><i class="fa fa-bars"></i>Pages</li>
				<li><i class="fa fa-square-o"></i>Pages</li>
			</ol>
		</div>
	</div>
	<!-- page start-->
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading tab-bg-info">
					<ul class="nav nav-tabs">
						<li class="active">
							<a data-toggle="tab" href="#recent-activity">
								<i class="icon-home"></i>
								Real-Time
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#profile">
								<i class="icon-user"></i>
								Analysis
							</a>
						</li>
						<li class="">
							<a data-toggle="tab" href="#edit-profile">
								<i class="icon-envelope"></i>
								<!-- Edit Profile -->
							</a>
						</li>
					</ul>
				</header>
				<div class="panel-body">
					<div class="tab-content">
						<div id="recent-activity" class="tab-pane active">
							<img src="${pageContext.request.contextPath}/resources/img/analytic.jpg"><br/>
							<a style="margin-top:30px" class="btn btn-success btn-sm" href="" title="Bootstrap 3 themes generator">Share</a>
						</div>
						<!-- profile -->
						<div id="profile" class="tab-pane">
							<section class="panel">
								<div class="bio-graph-heading">
									<!-- You can see the future performance of your Identity Server   -->
								</div>
							</section>
							<section>
								<div class="row">

								</div>
							</section>
						</div>
						<!-- edit-profile -->
						<div id="edit-profile" class="tab-pane">
							<section class="panel">
							</section>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>