<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header"><i class="fa fa-user-md"></i> Batch Analytic</h3>
			<ol class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
				<li><i class="icon_documents_alt"></i>Batch Analytic</li>
				<li><i class="fa fa-user-md"></i>Configurations</li>
			</ol>
		</div>
	</div>
	<div class="row">


		<!-- page start-->
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading tab-bg-info">
						<ul class="nav nav-tabs">
							<li class="active">
								<a data-toggle="tab" href="#recent-activity">
									<i class="icon-home"></i>
									Configurations
								</a>
							</li>
							<li>
								<a data-toggle="tab" href="#profile">
									<i class="icon-user"></i>
									Graphical View
								</a>
							</li>
							<li class="">
								<a data-toggle="tab" href="#edit-profile">
									<i class="icon-envelope"></i>
									Prediction
								</a>
							</li>
						</ul>
					</header>
					<div class="panel-body">
						<div class="tab-content">
							<div id="recent-activity" class="tab-pane active">
								<div class="profile-activity">
									<div class="bio-graph-heading">
										Analyze the IOT Divices
									</div> <br>

									<div class="form-group">
										<label class="col-lg-2 control-label">Name</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="c-name" placeholder=" ">
										</div></br>
									</div><br>

									<div class="form-group">
										<label class="col-lg-2 control-label">Dataset</label>
										<div class="col-lg-6">
											<select class="selectpicker">
												<option>please select</option>
												<option>IOT Divices dataset</option>
												<option>Dataset type1</option>
												<option>Dataset type1</option>
											</select>

										</div></br>
									</div><br>


									<div class="form-group">
										<label class="col-lg-2 control-label">Analytic type</label>
										<div class="col-lg-6">
											<select class="selectpicker">
												<option>please select</option>
												<option>Analyze IOT divice</option>
												<option>Analytic type 1</option>
												<option>Analytic type 1</option>
											</select>
										</div></br>
									</div><br>

									<div class="form-group">
										<label class="col-lg-2 control-label">Country</label>
										<div class="col-lg-6">
											<select class="selectpicker">
												<option>please select</option>
												<option>Sri Lanka</option>
												<option>America</option>
												<option>England</option>
												<option>India</option>
												<option>Canada</option>
											</select>
										</div></br>
									</div><br>
									<div class="form-group">

										<div class="col-lg-6">
											<button type="button" class="btn btn-primary">Save</button>
										</div></br>
									</div><br>

								</div>
							</div>
							<!-- profile -->
							<div id="profile" class="tab-pane">
								<section class="panel">
									<div class="bio-graph-heading">
										Analyze data using Charts
									</div>

									<div class="row">
										<div class="col-lg-12">
											<h3 class="page-header"><i class="icon_piechart"></i> Chart</h3>
											<ol class="breadcrumb">
												<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
												<li><i class="icon_piechart"></i>Chart</li>

											</ol>
										</div>
									</div>
									<div class="row">
										<!-- chart morris start -->
										<div class="col-lg-12">
											<section class="panel">
												<header class="panel-heading">
													<h3>General Chart</h3>
												</header>
												<div class="panel-body">
													<div class="tab-pane" id="chartjs">
														<div class="row">
															<!-- Line -->
															<div class="col-lg-6">
																<section class="panel">
																	<header class="panel-heading">
																		Line
																	</header>
																	<div class="panel-body text-center">
																		<canvas id="line" height="300" width="450"></canvas>
																	</div>
																</section>
															</div>
															<!-- Bar -->
															<div class="col-lg-6">
																<section class="panel">
																	<header class="panel-heading">
																		Bar
																	</header>
																	<div class="panel-body text-center">
																		<canvas id="bar" height="300" width="500"></canvas>
																	</div>
																</section>
															</div>
														</div>
														<div class="row">
															<!-- Radar -->
															<div class="col-lg-6">
																<section class="panel">
																	<header class="panel-heading">
																		Radar
																	</header>
																	<div class="panel-body text-center">
																		<canvas id="radar" height="300" width="400"></canvas>
																	</div>
																</section>
															</div>
															<!-- Polar Area -->
															<div class="col-lg-6">
																<section class="panel">
																	<header class="panel-heading">
																		Polar Area
																	</header>
																	<div class="panel-body text-center">
																		<canvas id="polarArea" height="300" width="400"></canvas>
																	</div>
																</section>
															</div>
														</div>
														<div class="row">

															<!-- Pie -->
															<div class="col-lg-6">
																<section class="panel">
																	<header class="panel-heading">
																		Pie
																	</header>
																	<div class="panel-body text-center">
																		<canvas id="pie" height="300" width="400"></canvas>
																	</div>
																</section>
															</div>
															<!-- Doughnut -->
															<div class="col-lg-6">
																<section class="panel">
																	<header class="panel-heading">
																		Doughnut
																	</header>
																	<div class="panel-body text-center">
																		<canvas id="doughnut" height="300" width="400"></canvas>
																	</div>
																</section>
															</div>
														</div>
													</div>
												</div>
											</section>
										</div>
                                    </div>
								</section>
							</div>
                        </div>
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
	</div>
    <script src="${pageContext.request.contextPath}/resources/js/chartjs-custom.js"></script>
</tiles:putAttribute>
</tiles:insertDefinition>