<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Report</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

<script>
function submitreport(id){
	$("#"+id).submit();
}
function submitform(id){
	$("#period").val(id);
	$("#reportget").submit();
}
</script>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<c:choose>
    <c:when test="${sessionScope.permission =='customer'}">
		<!-- Sidebar -->
		<ul class="navbar-nav bg-dark sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/FoodFamily/home">
				<div class="sidebar-brand-text mx-3">
					Food Family <sup>©</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseorder"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Order</span>
			</a>
				<div id="collapseorder" class="collapse"
					aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/FoodFamily/order/add">Place
							Order</a>
					</div>
				</div></li>
			<hr class="sidebar-divider d-none d-md-block">



			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsemenu"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Menu</span>
			</a>
				<div id="collapsemenu" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
					<a class="collapse-item" href="/FoodFamily/menu/">View
							Menu</a>
					</div>
				</div></li>

			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed"
				href="/FoodFamily/contact"> <span>Contact</span>
			</a></li>
			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed"
				href="/FoodFamily/aboutus"> <span>About Us</span>
			</a></li>
			

		</ul>
		<!-- End of Sidebar -->
        <br />
    </c:when>    
    <c:otherwise>
		<!-- Sidebar -->
		<ul class="navbar-nav bg-dark sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/FoodFamily/home">
				<div class="sidebar-brand-text mx-3">
					Food Family <sup>©</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseorder"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Orders</span>
			</a>
				<div id="collapseorder" class="collapse"
					aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded"> <a class="collapse-item" href="/FoodFamily/order/">View
							Orders</a>
					</div>
				</div></li>
			<hr class="sidebar-divider d-none d-md-block">



			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsemenu"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Menu</span>
			</a>
				<div id="collapsemenu" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/FoodFamily/menu/add">Create
							Menu</a> <a class="collapse-item" href="/FoodFamily/menu/">View
							Menu</a>
					</div>
				</div></li>
			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsestaff"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Staff</span>
			</a>
				<div id="collapsestaff" class="collapse"
					aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/FoodFamily/staff/add">Add Staff</a> 
						<a class="collapse-item" href="/FoodFamily/staff/">Staff
							List</a>
					</div>
				</div></li>
			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsereport"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Contact</span>
			</a>
				<div id="collapsereport" class="collapse"
					aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/FoodFamily/contact/list">View Queries</a>
					</div>
				</div></li>
				
				
				
			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed"
				href="/FoodFamily/customers"> <span>Customers</span>
			</a></li>
				
			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed"
				href="/FoodFamily/report"> <span>Reports</span>
			</a></li>
			<hr class="sidebar-divider d-none d-md-block">

			<li class="nav-item"><a class="nav-link collapsed"
				href="/FoodFamily/aboutus"> <span>About Us</span>
			</a></li>
			

		</ul>
		<!-- End of Sidebar -->
        <br />
    </c:otherwise>
</c:choose>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column"
			style="background-image: url('https://www.2yourdoor.ch/Content/Images/main-background-xs.jpg'); background-size: cover;">

			<!-- Main Content -->
			<div id="content">
			<div>
				<a href="/FoodFamily/register"><img
					src="${pageContext.request.contextPath}/resources/pics/logout.svg"
					alt="Submit"
					style="margin-right: 3%; width: 3%; height: 3%; float: right; margin-top: 2%;"></a> 
					</div>

						<!-- Trigger the modal with a button -->
					<button type="button" class="btn btn-danger btn-icon-split" style="float: right; margin-top: 2%;margin-right:3%" data-toggle="modal" data-target="#myModal">
					 <span class="icon text-white-50"> <i class="fas fa-receipt"></i></span> 
					<span class="text">Generate Report&nbsp;&nbsp;</span>
								
					</button>				
				
									<!-- Modal -->
					<div id="myModal" class="modal fade" role="dialog" >
					  <div class="modal-dialog">
					
					    <!-- Modal content-->
					    <div class="modal-content">
					      <div class="modal-header">
					        <h4 class="modal-title">Add Review</h4>
					      </div>
					      <div class="modal-body">
					      <form action="/FoodFamily/report" method="post" id="reviewForm">
					      <div style="display:flex;justify-content: space-between;" name="period">
					      <label for="period">Choose Time Period</label>
					      <select id="period" name="period" class="form-control">
					      <option value="daily">Daily</option>
					      <option value="weekly">Weekly</option>
					      <option value="monthly">Monthly</option>
					      </select>
					      </div>
					      <div>
					      <br>			      
							</div>
							</form>
							<br>
							<div style="display:flex;justify-content: space-between;">
					        <a id="mytag" href="javascript: submitreport('reviewForm');" class="btn btn-success btn-icon-split" >
								<span class="icon text-white-50"> 
								<i class="fas fa-registered"></i>
								</span> <span class="text">Submit Report&nbsp;&nbsp;</span>	
							</a>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					      </div>
					    </div>
				
				  </div>
				</div>
				
				
				</div>
				
				
				
				<form action="get" method="get" name="reportget">
				<input name="period" id="period" hidden>
				</form>
				
				<div class="container-fluid">
					<h1 style="margin-top: 5%; color: lightgrey">Sales Report</h1>
					<hr class="sidebar-divider bg-dark "
						style="width: 30%; float: left;">
					<br>
					<br> <img
						src="${pageContext.request.contextPath}/resources/pics/report.svg"
						alt="Image Not Found"
						style="width: 350px; height: 350px; float: right; margin-right: 2%;">
					<div class="dropdown mb-4">
						<button class="btn bg-light dropdown-toggle border-left-primary"
							style="margin-top: 2%; margin-left: 13.4%; color: #4e73df; padding: .45em 3em; font-size: large;"
							type="button" id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Select Report
							Period</button>
						<div class="dropdown-menu animated--fade-in"
							aria-labelledby="dropdownMenuButton" x-placement="bottom-start"
							style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 38px, 0px);">
							<a class="dropdown-item" style="color: #4e73df;" href="javascript: submitform('daily');">Daily</a>
							<a class="dropdown-item" style="color: #4e73df;" href="javascript: submitform('weekly');">Weekly</a>
							<a class="dropdown-item" style="color: #4e73df;" href="javascript: submitform('yearly');">Yearly</a>
						</div>
					</div>



					<div class="row " style="margin-top: 2%;">
						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4 ">
							<div class="card border-left-primary shadow h-100 py-2 ">
								<div class="card-body ">
									<div class="row no-gutters align-items-center ">
										<div class="col mr-2 ">
											<div
												class="text-s font-weight-bold text-primary text-uppercase mb-1 ">Total
												Sales</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800 "><c:out value="${report.getSales()}"/></div>
										</div>
										<div class="col-auto ">
											<i class="fas fa-clipboard-list fa-2x text-gray-300 "></i>
										</div>

									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4 ">
							<div class="card border-left-success shadow h-100 py-2 ">
								<div class="card-body ">
									<div class="row no-gutters align-items-center ">
										<div class="col mr-2 ">
											<div
												class="text-s font-weight-bold text-success text-uppercase mb-1 ">Total
												Profit</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800 "><c:out value="${report.getNetProfit()}"/></div>
										</div>
										<div class="col-auto ">
											<i class="fas fa-dollar-sign fa-2x text-gray-300 "></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4 ">
							<div class="card border-left-info shadow h-100 py-2 ">
								<div class="card-body ">
									<div class="row no-gutters align-items-center ">
										<div class="col mr-2 ">
											<div
												class="text-s font-weight-bold text-info text-uppercase mb-1 ">Total
												Order</div>
											<div class="row no-gutters align-items-center ">
												<div class="col " style="text-align: center;">
													<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800 "><c:out value="${report.getNoOfOrders}"/></div>
												</div>
											</div>
										</div>
										<div class="col-auto ">
											<i class="fas fa-cash-register fa-2x text-gray-300 "></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Begin Page Content -->



			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="main-footer ">
				<!-- To the right -->
				<div align="center ">
					<strong>Copyrights <a href="# ">Company</a> <sup>©</sup>
					</strong> Food Family &nbsp;
				</div>
				<!-- Default to the left -->
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded " href="#page-top "> <i
		class="fas fa-angle-up "></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js "></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js "></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js "></script>

</body>

</html>