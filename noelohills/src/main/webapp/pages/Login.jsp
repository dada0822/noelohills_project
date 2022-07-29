<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/Login.css?v=1" rel="stylesheet">
</head>
<body>
	<jsp:include page="Header.jsp" />
	
	
	<div class="loginWrap">
		
		<form class="loginForm" action="../pages/login.do" method="post">
			<h2>로그인</h2>
   			<input type="text" name="m_id">
   			<input type="password" name="m_pw">
			<input type="submit" value="로그인">
		</form>
		
	</div>
	
	
	<jsp:include page="Footer.jsp" />
</body>
</html>