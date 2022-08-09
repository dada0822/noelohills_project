<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/Product.css" rel="stylesheet">
</head>
<body class="productWrap">
	<jsp:include page="./Header.jsp" />
	
	<div class="product_">
		<div class="prod">
			<c:choose> 
				<c:when test="${empty cate_product}">
					<div class="product_page_top">
						<h2>SHOP</h2>
						<div>
							<ul>
								<li><a href="./product.do">ALL PRODUCTS</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(0).p_categorycode}">BABY</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(1).p_categorycode}">FAMILY</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(2).p_categorycode}">BATH GOODS</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(3).p_categorycode}">PRESENTS</a></li>
							</ul>
						</div>
					</div>
					<img src="../image/product/subimg/allproducts_subslide.png" alt="slide image">
					<div class="product_page_under">
						<c:forEach items="${productList}" var="total" varStatus="loop">
							<%-- <input type="hidden" name="p_categorycode" value="${total.p_categorycode}"> --%>
								<div>
									<a href="../pages/productDetail.do?p_code=${total.p_code}">
										<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg" alt="">
									</a>	
									<a href="../pages/productDetail.do?p_code=${total.p_code}">	
										<span>${total.p_name}</span>
									</a>
									<p>${total.p_price}원</p>
								</div>
						</c:forEach>
						<table width="100%">
							<tr align="center">
								<td>
									${map.pagingImg}
								</td>
							</tr>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div class="product_page_top">
						<h2>SHOP</h2>
						<div>
							<ul>
								<li><a href="./product.do">ALL PRODUCTS</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(0).p_categorycode}">BABY</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(1).p_categorycode}">FAMILY</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(2).p_categorycode}">BATH GOODS</a></li>
								<li><a href="./product.do?p_categorycode=${p_catecode.get(3).p_categorycode}">PRESENTS</a></li>
							</ul>
						</div>
					</div>
					<img src="../image/product/subimg/${cate_product.get(0).p_categorycode}_subslide.png" alt="${cate_product.get(0).p_categorycode} slide image">
					<div id="cate_page" class="product_page_under">
						<c:forEach items="${cate_product}" var="total" varStatus="loop">
							<input type="hidden" name="p_categorycode" value="${total.p_categorycode}">
							<div>
								<a href="../pages/productDetail.do?p_code=${total.p_code}">
									<img src="${pageContext.request.contextPath}/image/product/${total.p_name}_1.jpg" alt="">
								</a>	
								<a href="../pages/productDetail.do?p_code=${total.p_code}">	
									<span>${total.p_name}</span>
								</a>
								<p>${total.p_price}원</p>
							</div>
						</c:forEach>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<jsp:include page="./Footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/Product.js"></script>
</body>
</html>