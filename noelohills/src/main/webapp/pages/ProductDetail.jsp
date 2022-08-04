<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/ProductDetail.css?v=1" rel="stylesheet">
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<div class="wrap">
		<form class="wrap_1" method="post" action="./basket.do?p_code${dto.p_code}">
			<input type="hidden" name="p_code" value="${dto.p_code}">
			<input type="hidden" name="p_name" value="${dto.p_name}">
			<input type="hidden" name="default_p_totalprice" value="${dto.p_totalprice}"><!-- 기본값 -->
			
			<input type="hidden" id="tprice" value="${dto.p_totalprice}"><!-- 실제 금액 -->
			
			
			<img id="main_img" src="../image/product/${dto.p_name}_1.jpg" alt="${dto.p_name} 대표이미지">
			<c:forEach var="i" items="${imgList}">
				<img id="small_img" class="small_img" src="../image/product/${dto.p_name}_${i.pr_imgnum}.jpg" alt="${dto.p_name} 이미지">
			</c:forEach>
				${dto.p_name}
				${dto.p_content}
				${dto.p_price}원
			<input type='button' onclick='count("minus")' value='-'/>
			<input type='button' onclick='count("plus")' value='+'/>
			
			<!-- 개수 --><input type="text" name="p_count" id="p_count" value="${dto.p_count}">
			
			<!-- 개수에 따른 금액 --><input type="text" name="p_totalprice" id="p_totalprice" value="${dto.p_totalprice}">
			
			<button type="submit" onclick="form.action='./order.do'">구매하기</button>

			<button type="submit">장바구니</button>

		</form>
	</div>
	
	<jsp:include page="./Footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/ProductDetail.js"></script>
</body>
</html>