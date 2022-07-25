<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		position: fixed;
		top: 100px;
		left: 0;
	}
	
</style>
</head>
<body>
	<%-- <jsp:include page="Header.jsp" /> --%>
	
	<c:forEach items="${productList }" var="total">
		<img src="../image/product/${total.p_name }_1.jpg">
	</c:forEach>
	
	<%-- <jsp:include page="Footer.jsp" /> --%>
</body>
</html>