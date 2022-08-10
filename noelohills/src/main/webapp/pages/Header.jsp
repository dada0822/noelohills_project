<%@page import="product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ProductDAO dao = new ProductDAO();
	List<ProductDTO> p_catecode = dao.categoryCode(); // 카테고리코드 뽑아오기
	dao.close();
%>

<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;500;600;700&display=swap" rel="stylesheet">
<link href="../css/Header.css?v=1" rel="stylesheet">
	<header>
		<div class="header_in">
			<div id="logo">
				<a href="./Index.jsp"><img src="${pageContext.request.contextPath}/image/header/logo_new.png" alt="noelohills"></a>
			</div>
		
			<nav>
				<ul>
					<li>
						<a href="">ABOUT</a>
						<ul class="sub_nav">
							<li><a href="">BRAND STORY</a></li>
							<li><a href="">WHO WE ARE</a></li>
							<li><a href="">MAKE A WISH</a></li>
							<li><a href="">PRESS</a></li>
							<li><a href="">STOCKISTS</a></li>
						</ul>
					</li>
					<li>
						<a href="">TRUST</a>
						<ul class="sub_nav">
							<li><a href="">FOOD GRADE</a></li>
							<li><a href="">PENTACERA</a></li>
							<li><a href="">BABY SKINCARE</a></li>
							<li><a href="">CERIFICATIONS</a></li>
							<li><a href="">INGREDIENT</a></li>
						</ul>
					</li>
					<li>
						<a href="./product.do">SHOP</a>
						<ul class="sub_nav">
							<li><a href="./product.do">ALL PRODUCTS</a></li>
							<li><a href="./product.do?p_categorycode=<%=p_catecode.get(0).getP_categorycode()%>">BABY</a></li>
							<li><a href="./product.do?p_categorycode=<%=p_catecode.get(1).getP_categorycode()%>">FAMILY</a></li>
							<li><a href="./product.do?p_categorycode=<%=p_catecode.get(2).getP_categorycode()%>">BATH GOODS</a></li>
							<li><a href="./product.do?p_categorycode=<%=p_catecode.get(3).getP_categorycode()%>">PRESENTS</a></li>
						</ul>
					</li>
					<li>
						<a href="">REVIEW</a>
					</li>
					<li>
						<a href="">MEMBERS</a>
						<ul class="sub_nav">
							<li><a href="">MYPAGE</a></li>
							<li><a href="">ORDERLIST</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			
			<div class="profile">
				<c:choose>
            		<c:when test="${sessionScope.m_id eq null}">
            			<ul>
	            			<li><a class="login" href="./login.do" title="로그인"><img src="${pageContext.request.contextPath}/image/header/login.png" alt="login"></a></li>
	            			<li><a class="signup" href="./signup.do" title="회원가입"><img src="${pageContext.request.contextPath}/image/header/signup.png" alt="signup"></a></li>
	            		</ul>
            		</c:when>
            		<c:otherwise>
            			<ul>
	            			<li><a class="logout" href="./logout.do" title="로그아웃" onclick="return confirm('로그아웃하시겠습니까?');"><img src="${pageContext.request.contextPath}/image/header/logout.png" alt="logout"></a></li>
	            			<li><a class="mypage" href="./order.do" title="주문내역"><img src="${pageContext.request.contextPath}/image/header/shopping-list.png" alt="orderlist"></a></li>
	            			<li><a class="order" href="./basket.do" title="장바구니"><img src="${pageContext.request.contextPath}/image/header/cart.png" alt="cart"></a></li>
	            		</ul>
            		</c:otherwise>
            	</c:choose>
			</div>
		</div> <!-- .header_in -->
	</header> <!-- .header -->
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js" integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/Header.js"></script>