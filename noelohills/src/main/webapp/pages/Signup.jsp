<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/Signup.css?v=1" rel="stylesheet">
<body>
	<jsp:include page="Header.jsp" />
	
	<div class="test">
		<form class="test1" action="./pages/signup.do" method="post" onsubmit="">
			<h2>회원가입</h2>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="m_code" placeholder="아이디를 입력하세요."></td>
					<td>(영문 소문자/숫자, 4~16자)</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="m_pw" placeholder="비밀번호를 입력하세요."></td>
					<td>(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10~16자)</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="text" placeholder="비밀번호를 다시 입력하세요."></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="m_name" placeholder="이름을 입력하세요."></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="m_address" placeholder=""></td>
				</tr>
				<tr>
					<td>휴대전화</td>
					<td><input type="text" name="m_tel" placeholder=""></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="m_email" placeholder="이메일을 입력하세요."></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="location.href='./pages/signup.do'">회원가입</button>
						<button type="reset">초기화</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>