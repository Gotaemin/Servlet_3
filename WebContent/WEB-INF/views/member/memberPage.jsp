<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="../template/boot.jsp"></c:import>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>

<style type="text/css">

.btn_area{
	float: right;
}
</style>

</head>
<body>

	<!-- 	BootStrapAPI_nav  -------------------------------------------------->
	<c:import url="../template/header.jsp"></c:import>



	<div class="container">
		<div class="jumbotron">
			<h1>Member page</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>

		<h3>아이디 : ${member.id }</h3>
		<h3>이 름 : ${member.name }</h3>
		<h3>번 호 : ${member.phone }</h3>
		<h3>이메일 : ${member.email }</h3>
		<h3>나 이 : ${member.age }</h3>

	<div class="btn_area">
		<button class="btn btn-primary" id="update">Update</button>
		<button class="btn btn-danger" id="delete">Delete</button>
	</div>
		
	</div>
	
	<script type="text/javascript">
		$("#update").click(function() {
			location.href="./memberUpdate";
		});
	
	
		$("#delete").click(function() {
			var check = confirm("삭제하시겠습니까?");
			
			if(check){
				location.href="./memberDelete";
			}
		})
	
	
	
	</script>


</body>
</html>