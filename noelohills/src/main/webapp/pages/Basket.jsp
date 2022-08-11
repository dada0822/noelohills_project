<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/Basket.css?v=1" rel="stylesheet">
</head>
<body class="basketWrap">
	<jsp:include page="./Header.jsp" />
	
	<!-- 장바구니 비어있을 때랑 비어있지 않을 때 -->
	<div class="basket_">
		<form class="basketForm" method="post" action="./order.do">
			<h2>장바구니</h2>
			<c:choose>
				<c:when test="${empty basketList2}">
					<div class="basket_page_none">
						<p>장바구니에 담긴 상품이 없습니다.</p>
						<input type="button" onclick="location.href='./product.do'" value="쇼핑하러가기">
					</div> <!-- basket_page_none -->
				</c:when>
				<c:otherwise>
					<span class="separator"></span>
					<c:forEach items="${basketList2}" var="total" varStatus="loop">
						<input type="hidden" name="m_code" value="${total.m_code}"><!-- 회원코드 -->
						<input type="hidden" name="p_name" value="${total.p_name}"><!-- 각각의 제품명 -->
						<input type="hidden" name="p_totalprice" value="${total.b_price}"><!-- 각각의 금액 -->
						<input type="hidden" name="totalprice" value="${map.totalprice}"> <!-- 총 금액 -->
						<input type="hidden" name="p_count" value="${total.b_count}"><!-- 각각의 개수 -->
						<input type="hidden" name="p_code" value="${total.p_code}"><!-- 제품코드 -->
						<div class="basket_page">
							<ul>
								<li>
									<a href="./productDetail.do?p_code=${total.p_code}">
										<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg" alt="">
									</a>
								</li>
								<li>
									<span>
										<a href="./productDetail.do?p_code=${total.p_code}">
											${total.p_name}
										</a>
									</span>
									<span>
										수량 : ${total.b_count}개
									</span>									
								</li>
								<li>	
									${total.b_price}원
								</li>
								<li>
									<input type="button" onclick="location.href='./basketDelete.do?p_code=${total.p_code}'" value="삭제하기">
								</li>
							</ul>
						</div> <!-- basket_page -->
						<span class="separator"></span>
					</c:forEach>
					
				<div class="basket_bottom">
					<div>
						<span>총합 : <span id="point">${map.totalprice}원</span></span>
						<br>
						<input type="submit" value="구매하기">
						<input type="button" onclick="location.href='./product.do'" value="쇼핑 계속하기">
					</div>
					<input type="button" onclick="location.href='./basketDelete.do'" onclick="return confirm('장바구니를 비우시겠습니까?');" value="장바구니 비우기">
				</div> <!-- basket_bottom -->
				</c:otherwise>
			</c:choose>
		</form> <!-- basketForm -->
	</div> <!-- basket_ -->
	
	<jsp:include page="./Footer.jsp" />
</body>
</html>