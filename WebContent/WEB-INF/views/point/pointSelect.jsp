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
	<c:import url="../template/header.jsp"></c:import>


	<div class="container">
		<div class="jumbotron">
			<h1>Point Select Page</h1>
		</div>
		
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>총점</th>
						<th>평균</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${pointSelect.num}</td>
						<td>${pointSelect.name}</td>
						<td>${pointSelect.kor}</td>
						<td> ${pointSelect.eng}</td>
						<td>${pointSelect.math}</td>
						<td>${pointSelect.sum}</td>
						<td>${pointSelect.avg}</td>
					</tr>
				</tbody>
			</table>
			
			<a href="./pointDelete?num=${pointSelect.num}" class="btn btn-primary" style="float: right">Delete</a>
			<a href="./pointMod?num=${pointSelect.num}" class="btn btn-primary" style="float: right">Update</a>
		</div>
	</div>








</body>
</html>