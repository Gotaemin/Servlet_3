<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/boot.jsp"></c:import>
<style type="text/css">
a, a:hover {
	color: black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>

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