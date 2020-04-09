<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>


<!-- 	BootStrapAPI_nav  -------------------------------------------------->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath }">Point
					Project</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a
					href="${pageContext.request.contextPath }/point/pointList">Point</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">
		<div class="jumbotron">
			<h1>Member Add Form</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<form class="form-horizontal" action="./memberJoin" method="post">
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
			<label class="control-label col-sm-2" for="name">name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="Enter name" name="name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="eng">phone:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="phone"
					placeholder="Enter phone" name="phone">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="math">email:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email"
					placeholder="Enter email" name="email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="math">age:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="age"
					placeholder="Enter age" name="age">
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