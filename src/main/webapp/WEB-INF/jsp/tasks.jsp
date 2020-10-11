<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="../../assets/images/favicon.png" />
<title>AdminBite admin Template - The Ultimate Multipurpose
	admin template</title>
<!-- Custom CSS -->
<link href="../../assets/libs/chartist/dist/chartist.min.css"
	rel="stylesheet" />
<link href="../../assets/extra-libs/c3/c3.min.css" rel="stylesheet" />
<link href="../../assets/libs/morris.js/morris.css" rel="stylesheet" />
<!-- Custom CSS -->
<link href="../../dist/css/style.min.css" rel="stylesheet" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header">
					<!-- This is for the sidebar toggle which is visible on mobile only -->
					<a class="nav-toggler waves-effect waves-light d-block d-md-none"
						href="javascript:void(0)"> <i class="ti-menu ti-close"></i>
					</a>
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<a class="navbar-brand" href="index.html"> <!-- Logo icon --> <b
						class="logo-icon"> <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
							<!-- Dark Logo icon --> <img
							src="../../assets/images/logo-icon.png" alt="homepage"
							class="dark-logo" /> <!-- Light Logo icon --> <img
							src="../../assets/images/logo-light-icon.png" alt="homepage"
							class="light-logo" />
					</b> <!--End Logo icon --> <!-- Logo text --> <span class="logo-text">
							<!-- dark Logo text --> <img
							src="../../assets/images/logo-text.png" alt="homepage"
							class="dark-logo" /> <!-- Light Logo text --> <img
							src="../../assets/images/logo-light-text.png" class="light-logo"
							alt="homepage" />
					</span>
					</a>
					<!-- ============================================================== -->
					<!-- End Logo -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- Toggle which is visible on mobile only -->
					<!-- ============================================================== -->
					<a class="topbartoggler d-block d-md-none waves-effect waves-light"
						href="javascript:void(0)" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation"> <i class="ti-more"></i>
					</a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent">
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-left mr-auto">
						<li class="nav-item d-none d-md-block"><a
							class="nav-link sidebartoggler waves-effect waves-light"
							href="javascript:void(0)" data-sidebartype="mini-sidebar"> <i
								class="sl-icon-menu font-20"></i>
						</a></li>
						<!-- ============================================================== -->
						<!-- mega menu -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown mega-dropdown"><a
							class="nav-link dropdown-toggle waves-effect waves-dark" href=""
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="ti-gift font-20"></i>
						</a>
							<div class="dropdown-menu animated bounceInDown">
								<div class="mega-dropdown-menu row">
									<div class="col-lg-3 col-xlg-2 m-b-30">
										<h5 class="m-b-20">Carousel</h5>
										<!-- CAROUSEL -->
										<div id="carouselExampleControls" class="carousel slide"
											data-ride="carousel">
											<div class="carousel-inner" role="listbox">
												<div class="carousel-item active">
													<div class="container p-0">
														<img class="d-block img-fluid"
															src="../../assets/images/big/img1.jpg" alt="First slide" />
													</div>
												</div>
												<div class="carousel-item">
													<div class="container p-0">
														<img class="d-block img-fluid"
															src="../../assets/images/big/img2.jpg" alt="Second slide" />
													</div>
												</div>
												<div class="carousel-item">
													<div class="container p-0">
														<img class="d-block img-fluid"
															src="../../assets/images/big/img3.jpg" alt="Third slide" />
													</div>
												</div>
											</div>
											<a class="carousel-control-prev"
												href="#carouselExampleControls" role="button"
												data-slide="prev"> <span
												class="carousel-control-prev-icon" aria-hidden="true"></span>
												<span class="sr-only">Previous</span>
											</a> <a class="carousel-control-next"
												href="#carouselExampleControls" role="button"
												data-slide="next"> <span
												class="carousel-control-next-icon" aria-hidden="true"></span>
												<span class="sr-only">Next</span>
											</a>
										</div>
										<!-- End CAROUSEL -->
									</div>
									<div class="col-lg-3 m-b-30">
										<h5 class="m-b-20">Accordion</h5>
										<!-- Accordian -->
										<div id="accordion">
											<div class="card m-b-5">
												<div class="card-header" id="headingOne">
													<h5 class="mb-0">
														<button class="btn btn-link" data-toggle="collapse"
															data-target="#collapseOne" aria-expanded="true"
															aria-controls="collapseOne">Collapsible Group
															Item #1</button>
													</h5>
												</div>
												<div id="collapseOne" class="collapse show"
													aria-labelledby="headingOne" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry.</div>
												</div>
											</div>
											<div class="card m-b-5">
												<div class="card-header" id="headingTwo">
													<h5 class="mb-0">
														<button class="btn btn-link collapsed"
															data-toggle="collapse" data-target="#collapseTwo"
															aria-expanded="false" aria-controls="collapseTwo">
															Collapsible Group Item #2</button>
													</h5>
												</div>
												<div id="collapseTwo" class="collapse"
													aria-labelledby="headingTwo" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry.</div>
												</div>
											</div>
											<div class="card m-b-5">
												<div class="card-header" id="headingThree">
													<h5 class="mb-0">
														<button class="btn btn-link collapsed"
															data-toggle="collapse" data-target="#collapseThree"
															aria-expanded="false" aria-controls="collapseThree">
															Collapsible Group Item #3</button>
													</h5>
												</div>
												<div id="collapseThree" class="collapse"
													aria-labelledby="headingThree" data-parent="#accordion">
													<div class="card-body">Anim pariatur cliche
														reprehenderit, enim eiusmod high life accusamus terry.</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-3 m-b-30">
										<h5 class="m-b-20">Contact Us</h5>
										<!-- Contact -->
										<form>
											<div class="form-group">
												<input type="text" class="form-control"
													id="exampleInputname1" placeholder="Enter Name" />
											</div>
											<div class="form-group">
												<input type="email" class="form-control"
													placeholder="Enter email" />
											</div>
											<div class="form-group">
												<textarea class="form-control" id="exampleTextarea" rows="3"
													placeholder="Message"></textarea>
											</div>
											<button type="submit" class="btn btn-info">Submit</button>
										</form>
									</div>
									<div class="col-lg-3 col-xlg-4 m-b-30">
										<h5 class="m-b-20">List style</h5>
										<!-- List style -->
										<ul class="list-style-none">
											<li><a href="javascript:void(0)"> <i
													class="fa fa-check text-success"></i> You can give link
											</a></li>
											<li><a href="javascript:void(0)"> <i
													class="fa fa-check text-success"></i> Give link
											</a></li>
											<li><a href="javascript:void(0)"> <i
													class="fa fa-check text-success"></i> Another Give link
											</a></li>
											<li><a href="javascript:void(0)"> <i
													class="fa fa-check text-success"></i> Forth link
											</a></li>
											<li><a href="javascript:void(0)"> <i
													class="fa fa-check text-success"></i> Another fifth link
											</a></li>
										</ul>
									</div>
								</div>
							</div></li>
						<!-- ============================================================== -->
						<!-- End mega menu -->
						<!-- ============================================================== -->
						<!-- ============================================================== -->
						<!-- Comment -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle waves-effect waves-dark" href=""
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="ti-bell font-20"></i>
						</a>
							<div class="dropdown-menu mailbox animated bounceInDown">
								<span class="with-arrow"> <span class="bg-primary"></span>
								</span>
								<ul class="list-style-none">
									<li>
										<div class="drop-title bg-primary text-white">
											<h4 class="m-b-0 m-t-5">4 New</h4>
											<span class="font-light">Notifications</span>
										</div>
									</li>
									<li>
										<div class="message-center notifications">
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="btn btn-danger btn-circle"> <i
													class="fa fa-link"></i>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Luanch Admin</h5>
													<span class="mail-desc">Just see the my new admin!</span> <span
														class="time">9:30 AM</span>
												</div>
											</a>
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="btn btn-success btn-circle"> <i
													class="ti-calendar"></i>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Event today</h5>
													<span class="mail-desc">Just a reminder that you
														have event</span> <span class="time">9:10 AM</span>
												</div>
											</a>
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="btn btn-info btn-circle"> <i
													class="ti-settings"></i>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Settings</h5>
													<span class="mail-desc">You can customize this
														template as you want</span> <span class="time">9:08 AM</span>
												</div>
											</a>
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="btn btn-primary btn-circle"> <i
													class="ti-user"></i>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Pavan kumar</h5>
													<span class="mail-desc">Just see the my admin!</span> <span
														class="time">9:02 AM</span>
												</div>
											</a>
										</div>
									</li>
									<li><a class="nav-link text-center m-b-5"
										href="javascript:void(0);"> <strong>Check all
												notifications</strong> <i class="fa fa-angle-right"></i>
									</a></li>
								</ul>
							</div></li>
						<!-- ============================================================== -->
						<!-- End Comment -->
						<!-- ============================================================== -->
						<!-- ============================================================== -->
						<!-- Messages -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle waves-effect waves-dark" href=""
							id="2" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="font-20 ti-email"></i>
						</a>
							<div class="dropdown-menu mailbox animated bounceInDown"
								aria-labelledby="2">
								<span class="with-arrow"> <span class="bg-danger"></span>
								</span>
								<ul class="list-style-none">
									<li>
										<div class="drop-title bg-danger text-white">
											<h4 class="m-b-0 m-t-5">5 New</h4>
											<span class="font-light">Messages</span>
										</div>
									</li>
									<li>
										<div class="message-center message-body">
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="user-img"> <img
													src="../../assets/images/users/1.jpg" alt="user"
													class="rounded-circle" /> <span
													class="profile-status online pull-right"></span>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Pavan kumar</h5>
													<span class="mail-desc">Just see the my admin!</span> <span
														class="time">9:30 AM</span>
												</div>
											</a>
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="user-img"> <img
													src="../../assets/images/users/2.jpg" alt="user"
													class="rounded-circle" /> <span
													class="profile-status busy pull-right"></span>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Sonu Nigam</h5>
													<span class="mail-desc">I've sung a song! See you at</span>
													<span class="time">9:10 AM</span>
												</div>
											</a>
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="user-img"> <img
													src="../../assets/images/users/3.jpg" alt="user"
													class="rounded-circle" /> <span
													class="profile-status away pull-right"></span>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Arijit Sinh</h5>
													<span class="mail-desc">I am a singer!</span> <span
														class="time">9:08 AM</span>
												</div>
											</a>
											<!-- Message -->
											<a href="javascript:void(0)" class="message-item"> <span
												class="user-img"> <img
													src="../../assets/images/users/4.jpg" alt="user"
													class="rounded-circle" /> <span
													class="profile-status offline pull-right"></span>
											</span>
												<div class="mail-contnet">
													<h5 class="message-title">Pavan kumar</h5>
													<span class="mail-desc">Just see the my admin!</span> <span
														class="time">9:02 AM</span>
												</div>
											</a>
										</div>
									</li>
									<li><a class="nav-link text-center link"
										href="javascript:void(0);"> <b>See all e-Mails</b> <i
											class="fa fa-angle-right"></i>
									</a></li>
								</ul>
							</div></li>
						<!-- ============================================================== -->
						<!-- End Messages -->
						<!-- ============================================================== -->
					</ul>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-right">
						<!-- ============================================================== -->
						<!-- Search -->
						<!-- ============================================================== -->
						<li class="nav-item search-box"><a
							class="nav-link waves-effect waves-dark"
							href="javascript:void(0)"> <i class="ti-search font-16"></i>
						</a>
							<form class="app-search position-absolute">
								<input type="text" class="form-control"
									placeholder="Search &amp; enter" /> <a class="srh-btn"> <i
									class="ti-close"></i>
								</a>
							</form></li>
						<!-- ============================================================== -->
						<!-- create new -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i
								class="flag-icon flag-icon-us font-18"></i>
						</a>
							<div
								class="dropdown-menu dropdown-menu-right animated bounceInDown"
								aria-labelledby="navbarDropdown2">
								<a class="dropdown-item" href="#"> <i
									class="flag-icon flag-icon-us"></i> English
								</a> <a class="dropdown-item" href="#"> <i
									class="flag-icon flag-icon-fr"></i> French
								</a> <a class="dropdown-item" href="#"> <i
									class="flag-icon flag-icon-es"></i> Spanish
								</a> <a class="dropdown-item" href="#"> <i
									class="flag-icon flag-icon-de"></i> German
								</a>
							</div></li>

						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							href="" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <img
								src="../../assets/images/users/1.jpg" alt="user"
								class="rounded-circle" width="31" />
						</a>
							<div
								class="dropdown-menu dropdown-menu-right user-dd animated flipInY">
								<span class="with-arrow"> <span class="bg-primary"></span>
								</span>
								<div
									class="d-flex no-block align-items-center p-15 bg-primary text-white m-b-10">
									<div class="">
										<img src="../../assets/images/users/1.jpg" alt="user"
											class="img-circle" width="60" />
									</div>
									<div class="m-l-10">
										<h4 class="m-b-0">Steave Jobs</h4>
										<p class="m-b-0">varun@gmail.com</p>
									</div>
								</div>
								<a class="dropdown-item" href="javascript:void(0)"> <i
									class="ti-user m-r-5 m-l-5"></i> My Profile
								</a> <a class="dropdown-item" href="javascript:void(0)"> <i
									class="ti-wallet m-r-5 m-l-5"></i> My Balance
								</a> <a class="dropdown-item" href="javascript:void(0)"> <i
									class="ti-email m-r-5 m-l-5"></i> Inbox
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="javascript:void(0)"> <i
									class="ti-settings m-r-5 m-l-5"></i> Account Setting
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="javascript:void(0)"> <i
									class="fa fa-power-off m-r-5 m-l-5"></i> Logout
								</a>
								<div class="dropdown-divider"></div>
								<div class="p-l-30 p-10">
									<a href="javascript:void(0)"
										class="btn btn-sm btn-success btn-rounded">View Profile</a>
								</div>
							</div></li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
					</ul>
				</div>
			</nav>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="menu2.jsp" />
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-5 align-self-center">
						<h4 class="page-title">Task of Project</h4>
						<div class="d-flex align-items-center"></div>
					</div>
					<div class="col-7 align-self-center">
						<div
							class="d-flex no-block justify-content-end align-items-center">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Library</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">

				<!-- ============================================================== -->
				<!-- Info box -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">Create Task</h4>
							</div>
							<hr class="m-t-0" />
							<form class="form-horizontal r-separator"
								action="/add-task" method="post" modelAttribute="task">
								<div class="card-body">
									<div class="form-group row p-b-15" hidden="">
										<label for="inputEmail3"
											class="col-sm-3 text-right control-label col-form-label">Task
											ID</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="inputEmail3"
												path="project_id" placeholder="Full Name Here" />
										</div>
									</div>
									<div class="form-group row p-b-15">
										<label for="inputEmail3"
											class="col-sm-3 text-right control-label col-form-label">Task
											Name</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="inputEmail3"
												path="project_name" placeholder="Full Name Here" />
										</div>
									</div>
									<div class="form-group row p-b-15">
										<label for="inputEmail3"
											class="col-sm-3 text-right control-label col-form-label">Due
											Date</label>
										<div class="col-sm-9">
											<input type="date" class="form-control" path="due_date" />
										</div>
									</div>
									<div class="form-group row p-b-15">
										<label class="col-sm-3 text-right control-label col-form-label">Lead</label>
										<div class="col-md-9">
											<select class="form-control custom-select">
												<option value="">User1</option>
												<option value="">User2</option>
												<option value="">User3</option>
												<option value="">User4</option>
											</select> 
										</div>
									</div>
									<div class="form-group row p-b-15">
										<label for="inputEmail3"
											class="col-sm-3 text-right control-label col-form-label">Description</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="inputEmail3"
												path="project_description" placeholder="Description Here" />
										</div>
									</div>
									



								</div>
								<div class="card-body bg-light">
									<div class="form-group m-b-0 text-right">
										<button type="submit"
											class="btn btn-info waves-effect waves-light">Save</button>
										<button type="submit"
											class="btn btn-dark waves-effect waves-light">
											Cancel</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<hr>

				<!-- ============================================================== -->
				<!-- Table -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">Default Table</h4>

								<div class="table-responsive">
									<table id="demo-foo-addrow"
										class="table m-t-30 no-wrap table-hover contact-list"
										data-page-size="10">
										<thead>
											<tr>
												<th>No</th>
												<th>Task Name</th>
												<th>Due Date</th>
												<th>Lead</th>
												<th>Description</th>
												<th>Status</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="task" items="${tasks}">
												<tr>
													<td>${task.id }</td>
													<td>${task.task_name }</td>
													<td>${task.due_date }</td>
													<td>${task.lead_id.username }</td>
													<td>${task.task_description}</td>
													<td>${task.status }</td>
													<td>
														<div class="button-box">
															<a type="button" class="btn btn-default"
																href="/edit-project/${project.project_id}">Edit</a>
															<!-- <a type="button" class="btn btn-primary"
																data-toggle="modal" data-target="#exampleModal"
																data-whatever="@mdo">Delete project</a> -->
															<a type="button" class="btn btn-danger"
																href="/delete-project/${project.project_id}">Delete</a>
															<a type="button" class="btn btn-success"
																href="/create-task">View Task </a>
														</div> <%-- <div class="modal fade" id="exampleModal" tabindex="-1"
															role="dialog" aria-labelledby="exampleModalLabel1">
															<div class="modal-dialog center" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<h4 class="modal-title" id="exampleModalLabel1">Do
																			You Want Delete Project</h4>
																	</div>
																	<div class="modal-body">
																		Delete Project Name:  <c:out value="${project.project_name}"/>
																	</div>
																	<div class="modal-footer">
																		<a type="button" class="btn btn-default"
																			href="/delete-project/${project.project_id}">Yes</a>
																		<button type="button" class="btn btn-primary"
																			data-dismiss="modal">No</button>
																	</div>
																</div>
															</div>
														</div> --%>
													</td>
												</tr>
											</c:forEach>
										</tbody>
										<tr>
											<td>1</td>
											<td>Test</td>
											<td>2020-12-12</td>
											<td>son</td>
											<td>...</td>
											<td>true</td>
											<td>
											<div class="button-box">
												<a type="button" class="btn btn-default"
													>Edit</a>
												<!-- <a type="button" class="btn btn-primary"
																data-toggle="modal" data-target="#exampleModal"
																data-whatever="@mdo">Delete project</a> -->
												<a type="button" class="btn btn-danger"
													>Delete</a> 
											</div>
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Recent comment and chats -->
				<!-- ============================================================== -->

				<!-- ============================================================== -->
				<!-- Recent comment and chats -->
				<!-- ============================================================== -->

				<!-- ============================================================== -->
				<!-- End Container fluid  -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- footer -->
				<!-- ============================================================== -->

				<!-- ============================================================== -->
				<!-- End footer -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Page wrapper  -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Wrapper -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- customizer Panel -->
		<!-- ============================================================== -->

		<div class="chat-windows"></div>
		<!-- ============================================================== -->
		<!-- All Jquery -->
		<!-- ============================================================== -->
		<script src="../../assets/libs/jquery/dist/jquery.min.js"></script>
		<!-- Bootstrap tether Core JavaScript -->
		<script src="../../assets/libs/popper.js/dist/umd/popper.min.js"></script>
		<script src="../../assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- apps -->
		<script src="../../dist/js/app.min.js"></script>
		<script src="../../dist/js/app.init.dark.js"></script>
		<script src="../../dist/js/app-style-switcher.js"></script>
		<!-- slimscrollbar scrollbar JavaScript -->
		<script
			src="../../assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
		<script src="../../assets/extra-libs/sparkline/sparkline.js"></script>
		<!--Wave Effects -->
		<script src="../../dist/js/waves.js"></script>
		<!--Menu sidebar -->
		<script src="../../dist/js/sidebarmenu.js"></script>
		<!--Custom JavaScript -->
		<script src="../../dist/js/custom.min.js"></script>
		<!--This page JavaScript -->
		<!--chartis chart-->
		<script src="../../assets/libs/chartist/dist/chartist.min.js"></script>
		<script
			src="../../assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
		<!--c3 charts -->
		<script src="../../assets/extra-libs/c3/d3.min.js"></script>
		<script src="../../assets/extra-libs/c3/c3.min.js"></script>
		<!--chartjs -->
		<script src="../../assets/libs/raphael/raphael.min.js"></script>
		<script src="../../assets/libs/morris.js/morris.min.js"></script>

		<script src="../../dist/js/pages/dashboards/dashboard1.js"></script>
</body>
<footer class="footer text-center">
	All Rights Reserved by AdminBite admin. Designed and Developed by <a
		href="https://wrappixel.com">WrapPixel</a>.
</footer>
</html>