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
			<div>
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
					<h1>OUT STORY</h1>
					<ul>
						<li>
							<img src="../image/index/sub/sub_img1.png" alt="">
							<p>
								<span>NOELO HILLS</span>
								<span>Noelo는 하와이 원주민어로 ‘지식과 진리를 추구하다’라는 뜻입니다. 우리는 어린이 스킨케어가 조금 더 현명해져야한다고 믿어요.</span>
							</p>
						</li>
						<li>
							<img src="../image/index/sub/sub_img2.png" alt="">
							<p>
								<span>MILK ESSENCE LOTION</span>
								<span>안전성, 사용감, 효과, 감성. 노엘로힐스는 이 4가지 가치를 모든 제품에 반영합니다. 그리고 ‘밀크 에센스 로션’이야말로, 우리가 중시하는 요소를 완벽하게 담은 제품이죠.</span>
							</p>
						</li>
						<li>
							<img src="../image/index/sub/sub_img3.png" alt="">
							<p>
								<span>STUDY GROUP ANYONE?</span>
								<span>화장품 연구원, 의학 선생님들과 의논하며 다양한 의견이 오갔답니다. 그 결과 어린이 스킨케어를 조금 더 나은 관점에서 제공해야겠다는 생각이 싹텄죠. 노엘로힐스는 이렇게 시작되었습니다.</span>
							</p>
						</li>
						<li>
							<img src="../image/index/sub/sub_img4.png" alt="">
							<p>
								<span>FOOD GRADE</span>
								<span>푸드 그레이드 성분만으로 만들어서 안심할 수 있어요.</span>
							</p>
						</li>
					</ul>
					
					<div>
						<h2 class="fromLeft">왼쪽부터</h2>
					</div>
					
				</div> <!-- section -->
		    </div>
    		
			
		</div>
	
	<jsp:include page="./Footer.jsp" />
	
	<script src="${pageContext.request.contextPath}/js/Index.js"></script>
</body>
</html>