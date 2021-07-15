<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<meta name="author" content="Kodinger">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Login Page </title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="css/my-login.css">
	<style>
		html,body {
	height: 100%;
}

body.my-login-page {
	background-color: #f7f9fb;
	font-size: 14px;
}

.my-login-page .brand {
	width: 90px;
	height: 90px;
	overflow: hidden;
	border-radius: 50%;
	margin: 40px auto;
	box-shadow: 0 4px 8px rgba(0,0,0,.05);
	position: relative;
	z-index: 1;
}

.my-login-page .brand img {
	width: 100%;
}

.my-login-page .card-wrapper {
	width: 400px;
}

.my-login-page .card {
	border-color: transparent;
	box-shadow: 0 4px 8px rgba(0,0,0,.05);
}

.my-login-page .card.fat {
	padding: 10px;
}

.my-login-page .card .card-title {
	margin-bottom: 30px;
}

.my-login-page .form-control {
	border-width: 2.3px;
}

.my-login-page .form-group label {
	width: 100%;
}

.my-login-page .btn.btn-block {
	padding: 12px 10px;
}

.my-login-page .footer {
	margin: 40px 0;
	color: #888;
	text-align: center;
}

@media screen and (max-width: 425px) {
	.my-login-page .card-wrapper {
		width: 90%;
		margin: 0 auto;
	}
}

@media screen and (max-width: 320px) {
	.my-login-page .card.fat {
		padding: 0;
	}

	.my-login-page .card.fat .card-body {
		padding: 15px;
	}
}
	</style>
</head>

<body class="my-login-page">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="img/pension.jpeg" alt="LOGIN" >
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">Login To Pension Portal</h4>
							<sf:form action="/entereddetails" modelAttribute="pensionerinput" method="post" name="form">
								<div class="form-group">
									<label for="name">Name</label>
									<sf:input path="name" id="name"
						name="name" /> <sf:errors style="color:red" path="name"></sf:errors>
						
									<div class="invalid-feedback">
										Invalid Name
									</div>
								</div>

								<div class="form-group">
									<label for="dateOfBirth">DOB</label>
									<sf:input path="dateOfBirth"  type="date" cssClass="datepicker-1" id="dateOfBirth" placeholder="dd-MM-yyyy"
						name="dateOfBirth"/>
				 <sf:errors style="color:red" path="dateOfBirth"></sf:errors>
									<div class="invalid-feedback">
										Invalid DOB
									</div>
								</div>

								<div class="form-group">
									<label for="pan">Pan Card</label>
									<sf:input path="pan" id="pan"
						name="pan" /> <sf:errors style="color:red" path="pan"></sf:errors>
									<div class="invalid-feedback">
										Invalid Pan-Card
									</div>
								</div>

								<div class="form-group">
									<label for="aadharNumber">Aadhar Card</label>
									<sf:input path="aadharNumber" id="aadharNumber"
						name="aadharNumber" /> <sf:errors style="color:red" path="aadharNumber"></sf:errors>
									<div class="invalid-feedback">
										Invalid Aadhar-Card
									</div>
								</div>
								
								<div class="form-group">
                                    <label for="pensionType">Pension Type</label>
                                    <select  class="form-control"  name="pensionType" id="pensionType">
                                    	<option value="Self" >Self</option>
                                    	<option value="Family" >Family</option>
                                    	<option value="Both" >Both</option>
                                    </select>
                                    </div>
								
								<div class="row">
                                <div class ="col-sm">

								<div class="form-group m-0">
									<button type="submit" id="submit" name="Submit"
					value="Submit" class="btn btn-primary btn-block">
										Login
									</button>
									</div>
								</div>
								<div class ="col-sm">

								<div class="form-group m-0">
									<button type="reset" id="Clear" class="btn btn-primary btn-block" name="Clear" value="Clear">Clear</button>
								
							</div>
						</div>
					</div>
							</sf:form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</section>
</body>
</html>