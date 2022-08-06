<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="../css/OrderDetails.css?v=1" rel="stylesheet">
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<div class="orderDetail">
		<div class="order_d">
			${orderDetail.get(0).o_code}
			${orderDetail.get(0).o_day}
				
			<c:forEach items="${orderDetail}" var="total" varStatus="loop">
				<img src="../image/product/${total.o_name}_1.jpg" alt="${total.o_name} 이미지">
				${total.o_count}
				${total.o_name}
				${total.o_price}
				<br>
			</c:forEach>
			총합 : ${map.tprice}
			
			<input type="button" onclick="location.href='./product.do'" value="쇼핑 계속하기">
		</div>
	</div>
		
	<jsp:include page="./Footer.jsp" />
</body>
</html>