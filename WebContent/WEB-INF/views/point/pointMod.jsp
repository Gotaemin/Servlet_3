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
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">
		<div class="jumbotron">
			<h1>Point Modify Form</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<form class="form-horizontal" action="./pointMod" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="Enter name" name="name" value="${pointSelect.name}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="num">num:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="num"
					placeholder="Enter num" name="num" value="${pointSelect.num}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="kor">kor:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="kor"
					placeholder="Enter kor" name="kor" value="${pointSelect.kor}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="eng">eng:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="eng"
					placeholder="Enter eng" name="eng" value="${pointSelect.eng}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="math">math:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="math"
					placeholder="Enter math" name="math" value="${pointSelect.math}">
			</div>
		</div>
		
		<h1></h1>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</div>
		
	</form>
	</div>


</body>
</html>