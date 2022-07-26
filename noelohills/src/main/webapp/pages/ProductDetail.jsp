<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/ProductDetail.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<div class="wrap">
		<div class="wrap_1">
			<img id="main_img" src="../image/product/${dto.p_name}_1.jpg" alt="${dto.p_name} 대표이미지">
			<c:forEach var="dd" items="${imgList}">
				<img id="small_img" src="../image/product/${dto.p_name}_${dd.pr_imgnum}.jpg" alt="${dto.p_name} 이미지">
			</c:forEach>
			
			
			${dto.p_name}
			${dto.p_price}원
			${dto.p_totalprice}원
			${dto.p_count}개
		</div>
	</div>
	
	<jsp:include page="./Footer.jsp" />
	<script src="../js/ProductDetail.js"></script>
</body>
</html>