<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/boot.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>


	<!-- 	BootStrapAPI_nav  -------------------------------------------------->
	<c:import url="../template/header.jsp"></c:import>



	<div class="container">
		<div class="jumbotron">
			<h1>Member Add Form</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<form class="form-horizontal" action="./memberLogin" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">id:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id"
						placeholder="Enter id" name="id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">pwd:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter pwd" name="pwd">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" name="remember">
							Remember me</label>
					</div>
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>