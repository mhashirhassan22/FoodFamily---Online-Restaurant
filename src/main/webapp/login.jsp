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
<title>Login</title>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<style>
.mywrap {
	background-image:
		url("https://www.2yourdoor.ch/Content/Images/main-background-xs.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
	min-height: 100%;
}

html, body {
	min-height: 100%;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>

    $(document).ready(function() {
        a();
   });
    
    </script>
</head>

<body class="mywrap">
	<div>
		<br>
		<br>
	</div>
	<div class="bg-gradient-primary">

		<div class="container">
			<div class="row justify-content-center">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0 bg-light">
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block">
								<img
									src="${pageContext.request.contextPath}/resources/pics\login.svg"
									alt="Italian Trulli" style="width: 100%; height: 100%;">

							</div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="text-dark">Welcome Back!</h1>
										<img
											src="${pageContext.request.contextPath}/resources/pics/love.svg"
											alt="Italian Trulli"
											style="width: 18%; height: 20%; margin-bottom: 2%;">
									</div>
									<form class="user" action="loginform" method="post">
										<div class="form-group row">
											<input type="text" class="form-control form-control-user"
												name="username" style="border-radius: 25px;"
												placeholder="Enter Username..." required>
										</div>
										<div class="form-group row">
											<input type="password" class="form-control form-control-user"
												name="password" placeholder="Password"
												style="border-radius: 25px;" required>
										</div>
										<button class="btn btn-primary btn-user btn-block row"
											type="submit" style="border-radius: 25px;">Login</button>
									</form>
									<br>
									<div class="text-center">
										<a class="small" href="forgot-password.html"
											style="border-radius: 25px;"><strong>Forgot
												Password?</strong></a>
									</div>
									<div class="text-center">
										<form id="signupform" action="register">
											<a class="small" href="javascript: submitform()"
												style="border-radius: 25px;"><strong>Create an
													Account!</strong></a>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>


			<script> 
    
        function submitform() { $("#signupform").submit(); } 
    function a(){
    	var a = '${msg}';
    	if(a == "error")
    		alert("Credentials Incorrect. Try Again!");
    	}
    
    </script>
			<footer class="main-footer">
				<!-- To the right -->
				<div align="center">
					<strong>Copyrights <a href="#">Company</a> <sup>©</sup>
					</strong> Food Family &nbsp;
				</div>
			</footer>
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