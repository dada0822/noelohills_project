<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/Login.css?v=1" rel="stylesheet">
</head>
<body class="loginWrap">

	<script>
		function validateForm(form) {
			if(form.m_id.value == ""){
				alert("아이디를 입력하세요.");
				form.m_id.focus();
				return false;
			}
			
			if(form.m_pw.value == ""){
				alert("비밀번호를 입력하세요.");
				form.m_pw.focus();
				return false;
			}
		}
	</script>

	<jsp:include page="Header.jsp" />
	
	<div class="login_">
		<form class="loginForm" onsubmit="return validateForm(this)" action="../pages/login.do" method="post">
			<h2>로그인</h2>
   			<div class="login_input">
   				<input class="id_pw" type="text" name="m_id" placeholder="아이디를 입력하세요.">
   				<input class="id_pw" type="password" name="m_pw" placeholder="비밀번호를 입력하세요.">
				<input type="submit" value="로그인">
			</div>
		</form> <!-- loginForm -->
	</div> <!-- login_ -->
	
	
	<jsp:include page="Footer.jsp" />
</body>
</html>