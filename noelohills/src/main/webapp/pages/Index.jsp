<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/Index.css?v=1" rel="stylesheet">
</head>
<body>
	<jsp:include page="./Header.jsp" />
	
	<div class="index">
		<div class="index_">
			<%-- <div class="kind_wrap">
			  <div class="kind_slider">
			    <ul class="slider">
			        <li><img src="${pageContext.request.contextPath}/image/index/slide1.png?text=1" alt=""></li>
			        <li><img src="${pageContext.request.contextPath}/image/index/slide2.png?text=2" alt=""></li>
			        <li><img src="${pageContext.request.contextPath}/image/index/slide3.png?text=3" alt=""></li>
			        <li><img src="${pageContext.request.contextPath}/image/index/slide4.png?text=4" alt=""></li>
			        <li><img src="${pageContext.request.contextPath}/image/index/slide5.png?text=5" alt=""></li>
			        <li><img src="${pageContext.request.contextPath}/image/index/slide6.png?text=6" alt=""></li>
			    </ul>
			  </div>
			  <div class="arrow">
			      <a href="" class="prev">이전</a>
			      <a href="" class="next">다음</a>
			  </div>
			</div> --%>
			
		
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
		      <a class="prev" onclick="moveSlides(-1)">&#10094;</a>
		      <a class="next" onclick="moveSlides(1)">&#10095;</a>
		    </div>
		    <br/>
		
		    <!-- The dots/circles -->
		    <div style="text-align:center">
		      <span class="dot" onclick="currentSlide(0)"></span>
		      <span class="dot" onclick="currentSlide(1)"></span>
		      <span class="dot" onclick="currentSlide(2)"></span>
		      <span class="dot" onclick="currentSlide(3)"></span>
		      <span class="dot" onclick="currentSlide(4)"></span>
		      <span class="dot" onclick="currentSlide(5)"></span>
		    </div>
    
    
			
		</div>
	</div>
	
	<%-- <jsp:include page="./Footer.jsp" /> --%>
	
	<script src="${pageContext.request.contextPath}/js/Index.js"></script>
</body>
</html>