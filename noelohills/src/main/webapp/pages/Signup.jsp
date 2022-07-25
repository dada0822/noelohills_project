<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	
	<form>
		<h2>회원가입</h2>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" placeholder="아이디를 입력하세요."></td>
				<p>(영문 소문자/숫자, 4~16자)</p>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" placeholder="비밀번호를 입력하세요."></td>
				<p>(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10~16자)</p>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" placeholder="비밀번호를 다시 입력하세요."></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" placeholder="이름을 입력하세요."></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" placeholder="아이디를 입력하세요."></td>
			</tr>
			<tr>
				<td>휴대전화</td>
				<td><input type="text" placeholder="아이디를 입력하세요."></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" placeholder="아이디를 입력하세요."></td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="Footer.jsp" />
</body>
</html>