<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
<div class="dev-page-content">
	<!-- page content container -->
	<div class="container">

		<!-- page title -->
		<div class="page-title">
			<h1>Devin Stephens</h1>
			<p>UI/UX designer, Web-Developer, Senior PHP Developer</p>

			<ul class="breadcrumb">
				<li><a href="index.html">Dashboard</a></li>
				<li>Edit Profile</li>
			</ul>
		</div>
		<!-- ./page title -->

		<div class="wrapper">
			<div class="row row-wider">
				<div class="col-md-3">
					<div class="profile margin-bottom-0">
						<div class="profile-image">
							<img src="${pageContext.request.contextPath}/resources/assets/images/users/user_1.jpg">
							<div class="profile-badges">
								<a href="#" class="profile-badges-left"><i
									class="fa fa-plus"></i></a> <a href="#"
									class="profile-badges-right"><i class="fa fa-camera"></i></a>
							</div>
							<div class="profile-status online"></div>
						</div>
						<div class="profile-info">
							<h4>Devin Stephens</h4>
							<span><i class="fa fa-map-marker"></i> UK, London</span>
						</div>
						<div class="profile-info text-left">
							Profile complete on <strong>70%</strong>
							<div class="progress progress-bar-xs">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 70%;"></div>
							</div>
						</div>
					</div>

					<div class="list-group">
						<a href="#" class="list-group-item active"><i
							class="fa fa-wrench"></i> Edit profile</a> <a href="#"
							class="list-group-item"><i class="fa fa-cog"></i> Settings</a> <a
							href="#" class="list-group-item"><i class="fa fa-comment"></i>
							Messages <span class="badge badge-info">2</span></a> <a href="#"
							class="list-group-item"><i class="fa fa-photo"></i> Gallery</a>
					</div>

					<div class="panel panel-default panel-muted">

						<div class="panel-body" style="border-bottom: 0px;">
							<div
								class="page-subtitle page-subtitle-centralized margin-bottom-0">
								<h3>Your Contacts</h3>
								<p>You can remove anyone from your contacts</p>
							</div>
						</div>

						<div class="panel-body list-contacts" style="border-bottom: 0px;">
							<a href="#" class="list-contacts-item contact-online"> <img
								src="${pageContext.request.contextPath}/resources/assets/images/users/user_1.jpg"> Devin Stephens
								<button
									class="btn btn-danger btn-clean btn-rounded btn-only-icon pull-right">
									<i class="fa fa-times"></i>
								</button>
							</a> <a href="#" class="list-contacts-item contact-online"> <img
								src="${pageContext.request.contextPath}/resources/assets/images/users/user_2.jpg"> John Doe
								<button
									class="btn btn-danger btn-clean btn-rounded btn-only-icon pull-right">
									<i class="fa fa-times"></i>
								</button>
							</a> <a href="#" class="list-contacts-item contact-away"> <img
								src="${pageContext.request.contextPath}/resources/assets/images/users/user_3.jpg"> Marissa George
								<button
									class="btn btn-danger btn-clean btn-rounded btn-only-icon pull-right">
									<i class="fa fa-times"></i>
								</button>
							</a>
						</div>
						<div class="panel-body" style="border-top: 0px;">
							<button class="btn btn-primary btn-rounded btn-clean pull-right">Load
								more</button>
						</div>
					</div>
				</div>
				<div class="col-md-9">

					<div class="page-subtitle margin-bottom-0">
						<h3>Authentication details</h3>
						<p>Important fields for your identity in our system</p>
					</div>
					<div class="form-group-one-unit margin-bottom-40">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group form-group-custom">
									<label>Login</label> <input type="text" class="form-control"
										value="johnny" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group form-group-custom">
									<label>Password:</label> <input type="password"
										class="form-control" value="password" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group form-group-custom">
									<label>Re-Password:</label> <input type="password"
										class="form-control" value="password" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group form-group-custom">
									<label>Email Address</label> <input type="text"
										class="form-control" value="johndoe@domain.com" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group form-group-custom">
									<label>Country</label> <input type="text" class="form-control"
										value="United Kingdom" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group form-group-custom">
									<label>City</label> <input type="text" class="form-control"
										value="London" />
								</div>
							</div>
						</div>
					</div>


					<div class="page-subtitle margin-bottom-0">
						<h3>Personal information</h3>
						<p>This information is important for us</p>
					</div>
					<div class="form-group-one-unit margin-bottom-40">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group form-group-custom">
									<label>First Name</label> <input type="text"
										class="form-control" value="John" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-group-custom">
									<label>Second Name</label> <input type="text"
										class="form-control" value="Doe" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group form-group-custom">
									<label>Birthday</label>
									<div class="form-select-wrapper">
										<select class="form-control">
											<option>01</option>
											<option>02</option>
											<option>03</option>
											<option>04</option>
											<option>05</option>
											<option>06</option>
											<option>07</option>
											<option>08</option>
											<option>09</option>
											<option>10</option>
											<option>11</option>
											<option>12</option>
											<option>13</option>
											<option selected="selected">14</option>
											<option>15</option>
											<option>16</option>
											<option>17</option>
											<option>18</option>
											<option>19</option>
											<option>20</option>
											<option>21</option>
											<option>22</option>
											<option>23</option>
											<option>24</option>
											<option>25</option>
											<option>26</option>
											<option>27</option>
											<option>28</option>
											<option>29</option>
											<option>30</option>
											<option>31</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group form-group-custom">
									<label>Month</label>
									<div class="form-select-wrapper">
										<select class="form-control">
											<option>01</option>
											<option selected="selected">02</option>
											<option>03</option>
											<option>04</option>
											<option>05</option>
											<option>06</option>
											<option>07</option>
											<option>08</option>
											<option>09</option>
											<option>10</option>
											<option>11</option>
											<option>12</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group form-group-custom">
									<label>Year</label>
									<div class="form-select-wrapper">
										<select class="form-control">
											<option>2000</option>
											<option>1999</option>
											<option>1998</option>
											<option>1997</option>
											<option>1996</option>
											<option>1995</option>
											<option>1994</option>
											<option>1993</option>
											<option>1992</option>
											<option>1991</option>
											<option>1990</option>
											<option selected="selected">1989</option>
											<option>1988</option>
											<option>1987</option>
											<option>1986</option>
											<option>1985</option>
											<option>1984</option>
											<option>1983</option>
											<option>1982</option>
											<option>1981</option>
											<option>1980</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="page-subtitle margin-bottom-0">
						<h3>About</h3>
						<p>Some information about yourself</p>
					</div>
					<div class="form-group-one-unit margin-bottom-40">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group form-group-custom">
									<label>University</label> <input type="text"
										class="form-control" value="National Aviation University" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-group-custom">
									<label>Profession</label> <input type="text"
										class="form-control" value="System Programmer" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group form-group-custom">
									<label>About</label>
									<textarea class="form-control" rows="5">After reading the January 1975 issue of Popular Electronics that demonstrated the Altair 8800, Gates contacted Micro Instrumentation and Telemetry Systems (MITS), the creators of the new microcomputer, to inform them that he and others were working on a BASIC interpreter for the platform.</textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger pull-right">Save</button>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!-- Copyright -->
		<div class="copyright">
			<div class="pull-left">
				&copy; 2016 <strong>Jobify</strong>. All rights reserved.
			</div>
			<div class="pull-right">
				<a href="#">Terms of use</a> / <a href="#">Privacy Policy</a>
			</div>
		</div>
		<!-- ./Copyright -->

	</div>
	<!-- ./page content container -->

</div>
</tiles:putAttribute>
</tiles:insertDefinition>