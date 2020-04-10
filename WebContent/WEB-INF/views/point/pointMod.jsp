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