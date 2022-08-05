<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/OrderList.css?v=1" rel="stylesheet">
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<div class="orderList">
		<div class="order_l">
			<c:choose> 
				<c:when test="${empty orderList}">
					<p>구매내역이 존재하지 않습니다.</p>
					<input type="button" onclick="location.href='./product.do'" value="쇼핑 계속하기">
				</c:when>
				<c:otherwise>
					<c:forEach items="${orderList}" var="total" varStatus="loop">
						
						<img src="../image/product/${total.o_name}_1.jpg" alt="${total.o_name} 이미지">
						${total.o_code}
						${total.o_day}
						${total.o_count}
						${total.o_name}
						${total.o_price}
						<%-- <input type="button" onclick="location.href='./orderdetail.do?o_code=${total.o_code}'" value="주문 상세보기"> --%>
						<a href="./orderdetail.do?o_code=${total.o_code}">주문 상세보기</a>
						<br>
					</c:forEach>
				
			
			<input type="button" onclick="location.href='./product.do'" value="쇼핑 계속하기">
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<jsp:include page="./Footer.jsp" />
</body>
</html>