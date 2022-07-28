<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;500;600&display=swap" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/Product.css" rel="stylesheet">
</head>
<body class="test">
	<jsp:include page="./Header.jsp" />
	
	<div class="test1">
	
		<c:choose>
				<c:when test="${empty cate_product}">
					<c:forEach items="${productList}" var="total" varStatus="loop">
						<%-- <input type="hidden" name="p_categorycode" value="${total.p_categorycode}"> --%>
						<a href="../pages/productDetail.do?p_code=${total.p_code}">
							<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg">
							<br>
							<span>${total.p_name}</span>
						</a>
						<p>${total.p_price}원</p>
					</c:forEach>
					
					<table width="100%">
						<tr align="center">
							<td>
								${map.pagingImg}
							</td>
						</tr>
					</table>
					
				</c:when>
				<c:otherwise>
					
					<c:forEach items="${cate_product}" var="total" varStatus="loop">
						<input type="hidden" name="p_categorycode" value="${total.p_categorycode}">
						<a href="../pages/productDetail.do?p_code=${total.p_code}">
							<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg">
							<br>
							<span>${total.p_name}</span>
						</a>
						<p>${total.p_price}원</p>
					</c:forEach>
					
				</c:otherwise>
			</c:choose>
	
	
		
		
		
		
	</div>
	
	
	<jsp:include page="./Footer.jsp" />
</body>
</html>