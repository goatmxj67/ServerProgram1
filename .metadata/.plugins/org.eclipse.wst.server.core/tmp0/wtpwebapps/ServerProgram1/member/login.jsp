<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>

<style>
	.login_form {
		width: 300px;
		margin: 50px auto;
	}
	h3 {
		text-align: center;
	}
	#f input {
		padding: 5px;
		width: 100%;
		height: 50px;
	}
	#f button:hover {
		cursor: pointer;
	}
	.footer {
		width: 100%;
		display: flex;
		justify-content: space-between;
	}
</style>
<script>
	$(document).ready(function(){
		const f = $('#f');
		const id = $('#id');
		const name = $('#name');
		f.submit(function(event){
			if (id.val() == '') {
				alert('아이디와 이름은 필수입니다.');
				id.focus();
				event.preventDefault();
				return false;
			} 
			else if (name.val() == '') {
				alert('아이디와 이름은 필수입니다.');
				name.focus();
				event.preventDefault();
				return false;
			}
		})
	})
</script>

<div class="login_form">
	<h3>회원관리 프로그램</h3>
	<form action="/ServerProgram1/login.do" id="f" method="post">
		<input type="text" name="id" id="id" placeholder="ID"><br>
		<input type="text" name="name" id="name" placeholder="NAME"><br>
		<div class="footer">
			<button>로그인</button><a href="join.do">회원가입</a>
		</div>
	</form>
</div>