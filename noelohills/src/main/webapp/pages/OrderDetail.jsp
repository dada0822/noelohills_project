<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/OrderDetails.css?v=1" rel="stylesheet">
</head>
<body class="orderDetailsWrap">
	<jsp:include page="./Header.jsp" />
	
	<div class="orderDetails_">
		<div class="oDetails">
			<h2>주문내역</h2>
			<div> <!-- 주문번호, 주문일자 -->
				${orderDetail.get(0).o_code}
				<span>&#124;</span>
				${orderDetail.get(0).o_day}
			</div>
			<span class="separator"></span>
			<div class="oDetails_title">
				<ul>
					<li>이미지</li>
					<li>상품명</li>
					<li>수량</li>
					<li>합계</li>
				</ul>
			</div> <!-- oDetails_title -->
			<span class="separator"></span>
			<c:forEach items="${orderDetail}" var="total" varStatus="loop">
				<div class="orderDetails_page">
					<ul>
						<li>	
							<a href="./productDetail.do?p_code=${total.p_code}">
								<img src="../image/product/${total.o_name}_1.jpg" alt="${total.o_name} 이미지">
							</a>
						</li>
						<li>${total.o_name}</li>
						<li>${total.o_count}</li>
						<li>${total.o_price}원</li>
					</ul>
				</div> <!-- orderDetails_page -->
				<span class="separator"></span>
			</c:forEach>
			<div>
				<span>총합 : <span id="point">${map.tprice}원</span></span>
				<br>
				<input type="button" onclick="location.href='./product.do'" value="쇼핑 계속하기">
			</div>
		</div> <!-- oDetails -->
	</div> <!-- orderDetails_ -->
		
	<jsp:include page="./Footer.jsp" />
</body>
</html>