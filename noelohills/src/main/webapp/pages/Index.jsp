<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/Index.css?v=1" rel="stylesheet">
</head>
<body class="indexWrap">
	<jsp:include page="./Header.jsp" />
	
		<div class="index_">
		
		    <div class="slideshow-container">
				<!-- Full-width images with number and caption text -->
				<div class="mySlides fade">
					<img src="${pageContext.request.contextPath}/image/index/slide1.png" style="width:100%">
				</div>
				
				<div class="mySlides fade">
					<img src="${pageContext.request.contextPath}/image/index/slide2.png" style="width:100%">
				</div>
				
				<div class="mySlides fade">
					<img src="${pageContext.request.contextPath}/image/index/slide3.png" style="width:100%">
				</div>
				
				<div class="mySlides fade">
					<img src="${pageContext.request.contextPath}/image/index/slide4.png" style="width:100%">
				</div>
				
				<div class="mySlides fade">
					<img src="${pageContext.request.contextPath}/image/index/slide5.png" style="width:100%">
				</div>
				
				<div class="mySlides fade">
					<img src="${pageContext.request.contextPath}/image/index/slide6.png" style="width:100%">
				</div>
			
				<!-- Next and previous buttons -->
				<a class="prev" onclick="moveSlides(-1)">&#10092;</a>
				<a class="next" onclick="moveSlides(1)">&#10093;</a>
		    	
				<!-- The dots/circles -->
				<div class="dots">
					<span class="dot" onclick="currentSlide(0)"></span>
					<span class="dot" onclick="currentSlide(1)"></span>
					<span class="dot" onclick="currentSlide(2)"></span>
					<span class="dot" onclick="currentSlide(3)"></span>
					<span class="dot" onclick="currentSlide(4)"></span>
					<span class="dot" onclick="currentSlide(5)"></span>
				</div>
		    </div> <!-- slide  -->
			
			<div class="section">
				<h1>NOELO HILLS</h1>
				<ul>
					<li>
						<img src="../image/index/sub/sub_img1.png" alt="">
						<h2></h2>
					
					</li>
				</ul>
			</div>
		    
    
			
		</div>
	
	<jsp:include page="./Footer.jsp" />
	
	<script src="${pageContext.request.contextPath}/js/Index.js"></script>
</body>
</html>