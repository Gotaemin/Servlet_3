<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h1>BBS List Page</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>no</th>
						<th>title</th>
						<th>name</th>
						<th>date</th>
						<th>count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${bbsList}">
						<tr>
							<td>${list.no}</td>
							<td><a href="./bbsSelect?no=${list.no}">${list.title}</a></td>
							<td>${list.name}</td>
							<td>${list.day}</td>
							<td>${list.count}</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
			<c:if test="${not empty member}">
				<c:if test="${member.id eq 'admin'}">
					<a href="./bbsWrite" class="btn btn-primary" style="float: right">Write</a>
				</c:if>		
			</c:if>
			
		</div>
	</div>





</body>
</html>