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
<body class="orderListWrap">
	<jsp:include page="./Header.jsp" />
	
	<div class="orderList_">
		<div class="oList">
			<h2>주문내역</h2>
			<c:choose> 
				<c:when test="${empty orderList}">
					<div class="orderList_page_none">
						<p>구매내역이 존재하지 않습니다.</p>
						<input type="button" onclick="location.href='./product.do'" value="쇼핑하러가기">
					</div>
				</c:when>
				<c:otherwise>
					<span class="separator"></span>
					<div class="olist_nav">
						<ul>
							<li>주문일자</li>
							<li>이미지</li>
							<li>상품명</li>
							<li>수량</li>
							<li>주문금액</li>
						</ul>
					</div>
					<span class="separator"></span>
					<c:forEach items="${orderList}" var="total" varStatus="loop">
						<div class="orderList_page">
							<div>
								<a href="./orderdetail.do?o_code=${total.o_code}">주문 상세보기&nbsp;&#10093;</a>
							</div>
							<ul>	
								<li>
									${total.o_day}
								</li>
								<li>
									<a href="./orderdetail.do?o_code=${total.o_code}">
										<img src="../image/product/${total.o_name}_1.jpg" alt="${total.o_name} 이미지">
									</a>	
								</li>
								<li>
									${total.o_name}
								</li>
								<li>
									${total.o_count}
								</li>
								<li>
									${total.o_price}원
								</li>
							</ul>
							<%-- <input type="button" onclick="location.href='./orderdetail.do?o_code=${total.o_code}'" value="주문 상세보기"> --%>
						</div>
						<span class="separator"></span>
					</c:forEach>
					<div>
						<input type="button" onclick="location.href='./product.do'" value="쇼핑 계속하기">
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<jsp:include page="./Footer.jsp" />
</body>
</html>