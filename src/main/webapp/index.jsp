<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="utf-8">
<title>Signup</title>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<style>
.mywrap {
	background-image:
		url("${pageContext.request.contextPath}/resources/pics/welcome.svg");
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
        checkError();
   });
    
    </script>
</head>

<body class="mywrap">

	<div class="container">
		<div class="row justify-content-center">

			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0 bg-light">
					<div class="row">
						<div class="col-lg-6 d-none d-lg-block">
							<img
								src="${pageContext.request.contextPath}/resources/pics/welcome.svg"
								alt="Italian Trulli" style="width: 100%; height: 100%;">

						</div>
						<div class="col-lg-6">
							<div class="p-5">
								<div class="text-center">
									<h1 class="text-dark">Register To Food Family</h1>
									<br>
								</div>
								<form class="user" action="register" method="post">
									<div class="form-group row">
										<input type="firstname" class="form-control form-control-user"
											style="border-radius: 25px;" name="fname"
											placeholder="First Name" required>
									</div>
									<div class="form-group row">
										<input type="lastname" style="border-radius: 25px;"
											class="form-control form-control-user" name="lname"
											placeholder="Last Name" required>
									</div>
									<div class="form-group row">

										<input type="username" class="form-control form-control-user"
											name="username" placeholder="username"
											style="border-radius: 25px;" required>

									</div>
									<div class="form-group row">
										<input type="email" class="form-control form-control-user"
											name="email" placeholder="Email Address"
											style="border-radius: 25px;" required>
									</div>
									<div class="form-group row">
										<input type="password" class="form-control form-control-user"
											name="password" placeholder="Password"
											style="border-radius: 25px;" required>
									</div>
									<div class="form-group row">
										<input type="tel" class="form-control form-control-user"
											name="contact" placeholder="Contact"
											style="border-radius: 25px;" required>
									</div>
									<button class="btn btn-primary btn-user btn-block row"
										type="submit" style="border-radius: 25px;">Signup</button>
								</form>
								<br>
								<div class="text-center">
									<form id="loginform" action="loginform" method="get">
										<a class="small" href="javascript: submitform()"
											style="border-radius: 25px;"><strong>Already
												have an account?</strong></a>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script> 
        function submitform() { $("#loginform").submit(); } 
    function checkError(){
    	var a = '${result}';
    	if(a == "Registration unsuccessful")
    		alert("Registration unsuccessful. username already exists");
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