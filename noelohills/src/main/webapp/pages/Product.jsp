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
	out.println(${productList.get(1).p_categorycode});
	<div class="test1">
		<c:forEach items="${productList}" var="total">
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
		
		
	</div>
	
	<%-- <a href="../model2/view.do?idx=${row.idx }">${ row.title }</a> --%>
	
	<jsp:include page="./Footer.jsp" />
</body>
</html>