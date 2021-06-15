<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		* {
			margin: 0;
			padding: 0;
		}
		.container {
			width: 400px;
			margin: 100px auto;
			text-align: center;
		}
		table {
			width: 100%;
		}
		td {
			padding: 5px;
			text-align: center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			const f = $('#f');
			f.submit(function(e){
				const id = $('#id');
				const name = $('#name');
				if (id.val() == '' || name.val() == '') {
					alert('가입 정보를 모두 입력하세요.');
					e.preventDefault();
					return false;
				}
			})
		})
	</script>
</head>
<body>
	<div class="container">
		<h3 style="magin-bottom: 10px;">회원 가입 폼</h3>
		<form id="f" action="join.do" method="post">
			<table>
				<tbody>
					<tr><td>아이디</td><td><input type="text" name="id" id="id"></td></tr>
					<tr><td>이름</td><td><input type="text" name="name" id="name"></td></tr>
				</tbody>
				<tfoot>
					<tr><td colspan="2"><button>회원가입</button><input type="button" value="돌아가기" onclick="location.href='loginPage.do'"></td></tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>