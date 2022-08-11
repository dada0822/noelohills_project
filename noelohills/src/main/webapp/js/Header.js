/* header hover 시 css 변경 */
$(document).ready(function() {
	$('header').hover(function() {
		$(this).css('background','rgba(255,255,255,0.95)');
		$(this).css('border-bottom','1px solid #ddd');
	}, function() {
		$(this).css('background','rgba(255,255,255,0)');
		$(this).css('border-bottom','none');
	});
});


/* 스크롤 시 header css 변경 */
$(document).ready(function() {
  $(window).scroll(function() {
    var scroll = $(window).scrollTop();
    if (scroll > 1) {
		$('header').css('background', 'rgba(255,255,255,0.95)');
		$('header').css('border-bottom', '1px solid #ddd');
		
		$('header').mouseleave(function() {
			
			$('header').css('background', 'rgba(255,255,255,0.95)');
			$('header').css('border-bottom', '1px solid #ddd');
		});
		
    } else {
	
		$('header').css('background', 'none');   
		$('header').css('border', 'none');
		
		$('header').mouseenter(function() {
			
			$('header').css('background','rgba(255,255,255,0.95)');
			$('header').css('border-bottom','1px solid #ddd');
		});
		
		$('header').mouseleave(function() {
			
			$('header').css('background','rgba(255,255,255,0)');
			$('header').css('border-bottom','none');
		});
    }
  })
})

