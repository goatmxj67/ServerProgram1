<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
	$(document).ready(function(){
		const delete_btn = $('#delete_btn');
		delete_btn.click(function(){
			if (confirm('탈퇴하시겠습니까?')) {
				location.href = '/ServerProgram1/delete.do';
			}
		})
	})
</script>
</head>
<body>
	<h1>회원 관리 시스템</h1>
	<a href="logout.m">로그아웃</a>
	<hr>
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${loginDTO.id}</td>
				<td><input type="text" id="name" name="name" value="${loginDTO.name}"></td>
				<td>${loginDTO.grade}</td>
				<td><input type="text" id="point" name="point" value="${loginDTO.point}"></td>
			</tr>
		</tbody>
		<tfoot>
			<tr colspan="4">
				<td>
					<input type="button" value="수정하기" id="update_btn">
					<input type="button" value="탈퇴하기" id="delete_btn">
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>