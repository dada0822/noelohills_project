<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;500;600&display=swap" rel="stylesheet">
<link href="../css/Header.css?v=1" rel="stylesheet">
	<div class="header">
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
							<li><a href="./product.do?p_categorycode=${p_catecode.get(0).p_categorycode}">BABY</a></li>
							<li><a href="./product.do?p_categorycode=${p_catecode.get(1).p_categorycode}">FAMILY</a></li>
							<li><a href="./product.do?p_categorycode=${p_catecode.get(2).p_categorycode}">BATH GOODS</a></li>
							<li><a href="./product.do?p_categorycode=${p_catecode.get(3).p_categorycode}">PRESENTS</a></li>
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
					<li>
						<a href="">CS CENTER</a>
					</li>
				</ul>
			</nav>
			
			<div class="profile">
				<ul>
					<li><a href="./login.do"><img src="${pageContext.request.contextPath}/image/header/ico-login.png" alt="login"></a></li>
					<li><a href="./signup.do"><img src="${pageContext.request.contextPath}/image/header/ico-login.png" alt="signup"></a></li>
				</ul>
				
				<c:choose>
            		<c:when test="${sessionScope.m_id eq null}">
            			<ul>
	            			<li><a class="login" href="./login.do" title="로그인">로그인</a></li>
	            			<li><a class="signup" href="./signup.do" title="회원가입">회원가입</a></li>
	            		</ul>
            		</c:when>
            		<c:otherwise>
            			<ul>
	            			<li><a class="logout" href="./logout.do" onclick="return confirm('로그아웃하시겠습니까?');">로그아웃</a></li>
	            			<li><a class="mypage" href="./mypage.do">마이페이지</a></li>
	            			<li><a class="order" href="./basket.do" title="장바구니">장바구니</a></li>
	            		</ul>
            		</c:otherwise>
            	</c:choose>
			</div>
		</div> <!-- .header_in -->
	</div> <!-- .header -->