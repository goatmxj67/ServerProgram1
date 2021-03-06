<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			fn_selectList();
			fn_insert();
		});
		function fn_selectList() {
			$.ajax({
				url: 'selectStaffList.do',
				type: 'get',
				dataType: 'json',
				success: function(arr) {
					fn_tableMaker(arr);
				},
				error: function(xhr, textStatus, errorThrown) {
					
				}
			});  
		}  
		function fn_tableMaker(arr) {
			$('#staff_list').empty();
			$.each(arr, function(i, staff){
				$('<tr>')
				.append( $('<td>').text(staff.sno) )
				.append( $('<td>').text(staff.name) )
				.append( $('<td>').text(staff.dept) )
				.append( $('<td>').text(staff.regdate) )
				.appendTo('#staff_list');
			});
		}
		function fn_insert(){
			$('#insert_btn').click(function(){
				var regSNO = /^[0-9]{5}$/;
				var regDEPT = /^[가-힣]{3,5}$/;
				if ( !regSNO.test($('#sno').val()) ) {
					alert('사원번호는 5자리 숫자입니다.');
					return;
				}
				if ( !regDEPT.test($('#dept').val()) ) {
					alert('부서는 3~5자리 한글입니다.');
					return;
				}
				$.ajax({
					url: 'insertStaff.do',
					type: 'post',
					data: $('#f').serialize(),
					dataType: 'json',
					success: function(obj) {
						if (obj.count > 0) {
							alert("사원 등록이 성공했습니다.");
							fn_selectList();  
						} else {
							alert("등록되지 않았습니다.");
						}
					},
					error: function(xhr, textStatus, errorThrown) {
						if (xhr.status == 3001 || xhr.status == 3002) {
							alert(xhr.responseText);
						}
					}
				})  
			});  
		}  
		
	</script>
	<style>
		.insert_form {
			margin-right: 20px;
		}
		table {
			width: 650px;
			border-collapse: collapse;
		}
		td {
			border-top: 1px solid black;
			border-bottom: 1px solid black;
		}
		td:nth-of-type(1) { width: 150px; }
		td:nth-of-type(2) { width: 100px; }
		td:nth-of-type(3) { width: 100px; }
		td:nth-of-type(4) { width: 150px; }
	</style>
</head>
<body>
	
	<h1>사원 정보 등록프로그램</h1>
	
	
	<div class="insert_form">
		<form id="f">
			<input type="text" name="sno" id="sno" placeholder="사원번호">
			<input type="text" name="name" id="name" placeholder="사원명">
			<input type="text" name="dept" id="dept" placeholder="부서명">
			<input type="button" value="등록하기" id="insert_btn">
		</form>
	</div>
	
	<hr>
	
	<div class="list_form">
		<table>
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>부서명</td>
					<td>입사일</td>
				</tr>
			</thead>
			<tbody id="staff_list">
				
			</tbody>
		</table>
	</div>
	
	
</body>
</html>