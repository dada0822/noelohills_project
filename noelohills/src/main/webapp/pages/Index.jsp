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
		<div class="indes">
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

			<div class="mySlides fade">
				  <div class="numbertext">1 / 6</div>
				  <img src="${pageContext.request.contextPath}/image/index/slide1.png" style="width:100%">
				  <div class="text">Caption One</div>
			</div>
			
			<div class="mySlides fade">
			  <div class="numbertext">2 / 6</div>
			  <img src="${pageContext.request.contextPath}/image/index/slide2.png" style="width:100%">
			  <div class="text">Caption Two</div>
			</div>
			
			<div class="mySlides fade">
			  <div class="numbertext">3 / 6</div>
			  <img src="${pageContext.request.contextPath}/image/index/slide3.png" style="width:100%">
			  <div class="text">Caption Three</div>
			</div>
			
			<div class="mySlides fade">
			  <div class="numbertext">4 / 6</div>
			  <img src="${pageContext.request.contextPath}/image/index/slide4.png" style="width:100%">

			</div>
			
			<div class="mySlides fade">
			  <div class="numbertext">5 / 6</div>
			  <img src="${pageContext.request.contextPath}/image/index/slide5.png" style="width:100%">
			  <div class="text">Caption Three</div>
			</div>
			
			<div class="mySlides fade">
			  <div class="numbertext">6 / 6</div>
			  <img src="${pageContext.request.contextPath}/image/index/slide6.png" style="width:100%">
			  <div class="text">Caption Three</div>
			</div>
			
			</div>
			<br>
			
			<div style="text-align:center">
			  <span class="dot"></span> 
			  <span class="dot"></span> 
			  <span class="dot"></span> 
			</div>
			
		</div>
	</div>
	
	<jsp:include page="./Footer.jsp" />
	
	<script src="${pageContext.request.contextPath}/js/Index.js"></script>
	<script type="text/javascript">
		function sliding() {
			move(-1);
		    if (currentIdx === sliderCloneLis.length -1)
		        setTimeout(() => {
		          slider.style.transition = 'none';
		          currentIdx = 1;
		          translate = -liWidth;
		          slider.style.transform = `translateX(${translate}px)`;
		        }, speedTime);
		}
	
		function showSliding() {
		    setInterval(sliding, 1500);
		}
	
		showSliding();
	</script>
</body>
</html>