<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/ProductDetail.css?v=1" rel="stylesheet">
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<div class="wrap">
		<div class="wrap_1">
			<img id="main_img" src="../image/product/${dto.p_name}_1.jpg" alt="${dto.p_name} 대표이미지">
			<c:forEach var="dd" items="${imgList}">
				<img id="small_img" class="small_img" src="../image/product/${dto.p_name}_${dd.pr_imgnum}.jpg" alt="${dto.p_name} 이미지">
			</c:forEach>
			
			
			${dto.p_name}
			<!-- 상품 내용 -->
			${dto.p_price}원
			
			<input type='button' onclick='count("minus")' value='-'/>
			<input type='button' onclick='count("plus")' value='+'/>
			<div class='result'>${dto.p_count}</div>
			<div><span class='result'>${dto.p_count}</span>개</div>
			<input type="hidden" id="tprice" value="${dto.p_totalprice}"><!--  -->
						
			<div>총 상품금액 : <span id="ptotalprice">${dto.p_totalprice}</span>원</div>
			<div><span id="pcount">${dto.p_count}</span>개</div>
			
			
			<div class="content_right">
 
			</div>
			<button type="button">구매하기</button>
			<button>장바구니</button>
			
		</div>
		
		
		
	</div>
	
	<jsp:include page="./Footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/ProductDetail.js"></script>
</body>
</html>