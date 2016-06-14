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
			<h1>Upload CV</h1>
			<p>Register withus</p>

			<ul class="breadcrumb">
				<li><a href="index.html">Dashboard</a></li>
				<li>Upload CV</li>
			</ul>
		</div>
		<!-- ./page title -->


		<!-- validation forms -->
		<div class="wrapper wrapper-white">
			<div class="page-subtitle">
				<h3>Upload CV</h3>
				<p>Submit your credentials</p>
			</div>

			<div class="row">
				<form id="validate" role="form"
					action="javascript:alert('Form #validate submited');">
					<div class="col-md-6">
						<div class="form-group">
							<label>Position: <span>required position</span></label> <input
								type="text" class="form-control" name="login" />
						</div>
						<div class="form-group">
							<label>Job Categories: <span>required job category</span></label>
							<input type="password" class="form-control" name="password"
								id="password2" />
						</div>
						<div class="form-group">
							<label>Experience: <span>required experience</span></label> <input
								type="text" class="form-control" name="re-password" />
						</div>
						<div class="form-group">
							<label>Salery Expected: <span>required salary
									expected</span></label> <input type="text" value="" name="email"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Age: <span>min size = 18, max size = 100</span></label> <input
								type="text" class="form-control" name="age" />
						</div>
						<div class="form-group">
							<label>Date of birth: <span>required date</span></label> <input
								type="text" class="form-control datepicker" name="date" />
						</div>
						<div class="form-group">
							<label>Mobile: <span>required mobile</span></label> <input
								type="text" class="form-control" name="credit" />
						</div>
						<div class="form-group">
							<label>CV: <span>required CV</span></label> <input type="file"
								value="http://" name="site" class="form-control" />
						</div>
						<div class="pull-right margin-top-10">
							<button class="btn btn-warning hide-prompts" type="button">Hide
								prompts</button>
							<button class="btn btn-danger" type="submit">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- ./validation forms -->



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