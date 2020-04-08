<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<style type="text/css">
a, a:hover {
	color: black;
}
</style>
<title>Insert title here</title>
</head>
<body>
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
			<h1>Point List Page</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>평균</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${pointList}">
						<tr>
							<td>${list.num}</td>
							<td><a href="./pointSelect?num=${list.num}">${list.name}</a></td>
							<td>${list.avg}</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			<a href="./pointAdd" class="btn btn-primary" style="float: right">Write</a>
		</div>
	</div>





</body>
</html>