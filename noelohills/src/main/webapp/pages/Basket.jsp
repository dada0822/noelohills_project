<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<!-- 장바구니 비어있을 때랑 비어있지 않을 때 -->
	<div>
		<form method="post">
			<c:choose> 
				<c:when test="${empty basketList2}">
					<p>등록된 게시물이 없습니다.</p>
				</c:when>
				<c:otherwise>
					<c:forEach items="${basketList2}" var="total" varStatus="loop">
						<a href="./productDetail.do?p_code=${total.p_code}">
							<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg" alt="">
							<span>${total.p_name}</span>
						</a>
						<p>${total.b_count}</p>
						<p>${total.b_price}원</p>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
	
	<jsp:include page="./Footer.jsp" />
</body>
</html>