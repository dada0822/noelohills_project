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
<body class="productWrap">
	<jsp:include page="./Header.jsp" />
	
	<div class="product_">
	
		<div class="tab_menu">
		  <ul class="list">
		    <li class="selected">
		      <a href="#tab1" class="btn">Tab Button1</a>
		    </li>
		    <li>
		      <a href="#tab2" class="btn">Tab Button2</a>
		    </li>
		    <li>
		      <a href="#tab3" class="btn">Tab Button3</a>
		    </li>
		  </ul>
		</div>
		
		<div class="tab_menu">
			<h2>SHOP</h2>
			<ul class="list">
				<li class="is_on"><a class="btn" href="./product.do">ALL PRODUCTS</a></li>
				<li><a class="btn" href="./product.do?p_categorycode=${p_catecode.get(0).p_categorycode}">BABY</a></li>
				<li><a class="btn" href="./product.do?p_categorycode=${p_catecode.get(1).p_categorycode}">FAMILY</a></li>
				<li><a class="btn" href="./product.do?p_categorycode=${p_catecode.get(2).p_categorycode}">BATH GOODS</a></li>
				<li><a class="btn" href="./product.do?p_categorycode=${p_catecode.get(3).p_categorycode}">PRESENTS</a></li>
			</ul>
		</div>
		<c:choose> 
			<c:when test="${empty cate_product}">
				<img class="subimg" src="../image/product/subimg/allproducts_subslide.png" alt="slide image">
				<c:forEach items="${productList}" var="total" varStatus="loop">
					<%-- <input type="hidden" name="p_categorycode" value="${total.p_categorycode}"> --%>
					<a href="../pages/productDetail.do?p_code=${total.p_code}">
						<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg" alt="">
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
				<img class="subimg" src="../image/product/subimg/${cate_product.get(0).p_categorycode}_subslide.png" alt="${cate_product.get(0).p_categorycode} slide image">
				<c:forEach items="${cate_product}" var="total" varStatus="loop">
					<input type="hidden" name="p_categorycode" value="${total.p_categorycode}">
					<a href="../pages/productDetail.do?p_code=${total.p_code}">
						<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg" alt="">
						<br>
						<span>${total.p_name}</span>
					</a>
					<p>${total.p_price}원</p>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	

	
	</div>
	
	

	
	<jsp:include page="./Footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/Product.js"></script>
</body>
</html>