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
<body class="productDetailWrap">
	<jsp:include page="./Header.jsp" />
	
	<div class="productDetail_">
		<form class="pDetail" method="post" action="./basket.do?p_code${dto.p_code}">
			<input type="hidden" name="p_code" value="${dto.p_code}">
			<input type="hidden" name="p_name" value="${dto.p_name}">
			<input type="hidden" name="default_p_totalprice" value="${dto.p_totalprice}"><!-- 기본값 -->
			<input type="hidden" id="tprice" value="${dto.p_totalprice}"><!-- 실제 금액 -->
			
			<div>
				<img id="main_img" src="../image/product/${dto.p_name}_1.jpg" alt="${dto.p_name} 대표이미지">
				<ul>
					<c:forEach var="i" items="${imgList}">
						<li>
							<img class="small_img" src="../image/product/${dto.p_name}_${i.pr_imgnum}.jpg" alt="${dto.p_name} 이미지">
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div>
				<ul>
					<li>${dto.p_name}</li>
					<li>${dto.p_content}</li>
					<li>${dto.p_price}원</li>
				</ul>
				<div class="pd_count_price">
					<div>	
						<span>수량</span>
						<input id="pd_buts" class="pd_buts" type='button' onclick='count("minus")' value='-'/>
						<input type="text" name="p_count" id="p_count" value="${dto.p_count}"> <!-- 개수 -->
						<input class="pd_buts" type='button' onclick='count("plus")' value='+'/>
					</div>
					<span>총 상품금액</span>
					<span><input type="text" name="p_totalprice" id="p_totalprice" value="${dto.p_totalprice}">원</span> <!-- 개수에 따른 금액 -->
				</div> <!-- pd_count_price -->
				
				<div>
					<button type="submit"  onclick="return confirm('구매하시겠습니까?');" onclick="form.action='./order.do'">구매하기</button>
					<button type="submit" onclick="return confirm('장바구니에 담겠습니까?');">장바구니</button>
				</div>	
			</div>
		</form> <!-- pDetail -->
	</div> <!-- productDetail_ -->
	
	<jsp:include page="./Footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/ProductDetail.js"></script>
</body>
</html>