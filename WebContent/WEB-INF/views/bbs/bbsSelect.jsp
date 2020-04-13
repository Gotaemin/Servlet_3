<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<c:import url="../template/boot.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>


	<div class="container">
		<div class="jumbotron">
			<h1>BBS Select Page</h1>
		</div>
		
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>no</th>
						<th>title</th>
						<th>name</th>
						<th>date</th>
						<th>contents</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${bbsDTO.no}</td>
						<td>${bbsDTO.title}</td>
						<td>${bbsDTO.name}</td>
						<td>${bbsDTO.day}</td>
						<td>${bbsDTO.contents}</td>
					</tr>
				</tbody>
			</table>
			
			
			<c:if test="${not empty member}">
				<c:if test="${member.id eq 'admin'}">
					<a class="btn btn-primary" style="float: right" id="btnDel">Delete</a>
					<a href="./bbsUpdate?no=${bbsDTO.no}" class="btn btn-primary" style="float: right" >Update</a>
				</c:if>		
			</c:if>
			
		</div>
	</div>




<script type="text/javascript">
	$("#btnDel").click(function() {
		var check = confirm("삭제하시겠습니까?");
		
		if(check){
			location.href ="./bbsDelete?no=${bbsDTO.no}";
		}
	})
	
	
</script>



</body>
</html>