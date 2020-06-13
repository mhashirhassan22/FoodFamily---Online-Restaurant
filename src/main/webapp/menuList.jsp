<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
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
<title>Menu</title>

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
		function submitform(id){
			$("#"+id).submit();
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

				<input type="image"
					src="${pageContext.request.contextPath}/resources/pics/logout.svg"
					alt="Submit"
					style="margin-right: 3%; width: 5%; height: 5%; float: right; margin-top: 2%;">

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<div>
						<div class="p-5 ">

							<div class="text-center ">
								<div class="font-weight-bold text-uppercase mb-4 "
									style="font-size: 40px; color: lightgray">
									Exortic Restaurant is Serving <img
										src="${pageContext.request.contextPath}/resources/pics/menu.svg"
										style="margin-left: 5%; color: #0275d8; width: 100px; height: 100px;">

									<!-- <i class="fas fa-shopping-bag fa-2x " style="float: right; color:#0275d8 "></i> -->
								</div>
								<br>
							</div>

							
							
							
							<table id=" menuTable"
								class="table table-bordered table-striped ">
								<thead>
									<tr style="color: lightgray;">
										<th>Sr.</th>
										<th>Item</th>
										<th>Price</th>
										<th>Available Qty.</th>
										
								<c:choose>
								    <c:when test="${sessionScope.permission =='customer'}">
								
								    </c:when>    
								    <c:otherwise>
										<th>Action</th>
								    </c:otherwise>
								</c:choose>
										
										
										
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${menufood}" var="m" varStatus="loop">
									    <tr style="color:lightgray; ">
									        <td><c:out value="${loop.count}"/></td>
									        <td><c:out value="${m.getFoodName()}"/></td>
									        <td><c:out value="${m.getRetailPrice()}"/></td>
									        <td><c:out value="${m.getQty()}"/></td>
									        
									        
									        										
								<c:choose>
								    <c:when test="${sessionScope.permission =='customer'}">
								
								    </c:when>    
								    <c:otherwise>
								    	        <td>
									        <div class="form-group row" style="margin-left: 1%">
									        <form id="${loop.count}edit" action="edit" method="get" style="text-decoration: underline;color: lightgrey;">
									        <a href="javascript: submitform('${loop.count}edit')" style="text-decoration: underline;color: lightgrey;">Edit</a><br>
									        <input value="${m.getFoodName()}" name="foodname" type="hidden">
									        </form>&nbsp;&nbsp;
									        <form id="${loop.count}" action="delete" method="post" style="text-decoration: underline;color: lightgrey;">
									        <a href="javascript: submitform('${loop.count}')" style="color: lightgray; text-decoration: underline;">Delete</a>
									        <input value="${m.getFoodName()}" name="foodname" type="hidden">
									        </form></div></td>
								    
								    </c:otherwise>
								</c:choose>
									    </tr>
									</c:forEach>
								<c:forEach items="${deallist}" var="m" varStatus="loop">
									    <tr style="color:lightgray; ">
									        <td><c:out value="${loop.count}"/></td>
									        <td><c:out value="${m.getName()}"/></td>
									        <td><c:out value="${m.getPrice()}"/></td>
									        <td><c:out value="As per Food Items"/></td>
									        
									        									        										
								<c:choose>
								    <c:when test="${sessionScope.permission =='customer'}">
								
								    </c:when>    
								    <c:otherwise>
								    
									        
									        <td>
									        <div class="form-group row" style="margin-left: 1%">
									        <form id="${loop.count}" action="deleteDeal" method="post" style="text-decoration: underline;color: lightgrey;">
									        <a href="javascript: submitform('${loop.count}')" style="color: lightgray; text-decoration: underline;">Delete</a>
									        <input value="${m.getName()}" name="dealname" type="hidden">
									        </form></div></td>
								    
								    </c:otherwise>
								</c:choose>
										
									        
									        
									        
									        

									         
									    </tr>
									</c:forEach>
								</tbody>
							</table>
							<br>
						</div>
					</div>

					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->
			</div>
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