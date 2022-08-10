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
				
					<a class="prev" onclick="moveSlides(-1)">&#10092;</a>
					<a class="next" onclick="moveSlides(1)">&#10093;</a>
			    	
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
					<h2 class="sa sa-up">Our Story</h2>
					<ul>
						<li class="sa sa-up">
							<div class="img_trans">
								<img src="../image/index/sub/sub1_img1.png" alt="ourstory 이미지1">
							</div>
							<p>
								<span>NOELO HILLS</span>
								<span>Noelo는 하와이 원주민어로<br>‘지식과 진리를 추구하다’라는 뜻입니다.<br>우리는 어린이 스킨케어가<br>조금 더 현명해져야한다고 믿어요.</span>
							</p>
						</li>
						<li class="sa sa-up">
							<div class="img_trans">
								<img src="../image/index/sub/sub1_img2.png" alt="ourstory 이미지2">
							</div>
							<p>
								<span>MILK ESSENCE LOTION</span>
								<span>안전성, 사용감, 효과, 감성.<br>‘밀크 에센스 로션’이야말로, <br>우리가 중시하는<br>요소를 완벽하게 담은 제품이죠.</span>
							</p>
						</li>
						<li class="sa sa-up">
							<div class="img_trans">
								<img src="../image/index/sub/sub1_img3.png" alt="ourstory 이미지3">
							</div>
							<p>
								<span>STUDY GROUP ANYONE?</span>
								<span>화장품 연구원, 의학 선생님들과<br>의논하며 다양한 의견이 오갔답니다.<br>그 결과 어린이 스킨케어를 조금 더 나은<br>관점에서 제공해야겠다는 생각이 싹텄죠.</span>
							</p>
						</li>
						<li class="sa sa-up">
							<div class="img_trans">
								<img src="../image/index/sub/sub1_img4.png" alt="ourstory 이미지4">
							</div>
							<p>
								<span>FOOD GRADE</span>
								<span>푸드 그레이드는 식품 원료로 <br>사용한 이력이 있는 성분을 말해요. <br>푸드 그레이드 성분만으로<br>만들어서 안심할 수 있어요.</span>
							</p>
						</li>
					</ul>
				</div> <!-- section -->
				<div class="section2">
					<div class="sa sa-up">
						<img src="../image/index/sub/sub2_img5.png" alt="세라마이드 이미지">
					</div>
					<h2 class="sa sa-up">PENTACERA™</h2>
					<p class="sa sa-up">피부 수분은 지키고 보습기능을 개선해주는 5중 세라마이드 복합체</p>
				</div> <!-- section2 -->
				<div class="section3">
					<h2 class="sa sa-up">Certifications</h2>
					<ul>
						<li class="sa sa-up">내 아이가 직접 사용하는 제품,</li>
						<li class="sa sa-up">아무 것이나 사용할 수 없기에 유해 논란이 있는 성분은 배제하고 
							<br>안심할 수 있는 성분으로 만들어 공신력 있는 기관의 실험을 통해 품질, 효과와 안전성을 관리하고 있습니다.</li>
					</ul>
					<ul>
						<li></li>
					</ul>
				</div>
		    </div>
		</div>
	
	<jsp:include page="./Footer.jsp" />
	
	<script src="${pageContext.request.contextPath}/js/Index.js"></script>
</body>
</html>