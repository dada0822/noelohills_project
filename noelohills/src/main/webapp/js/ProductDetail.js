/* 이미지 호버 시 이미지 바꾸기 */
let main_img = document.querySelector("#main_img");
let small_img = document.querySelectorAll(".small_img");

for(let i=0; i<small_img.length; i++){
    small_img[i].addEventListener("mouseover", showBig);
}

function showBig(){
   main_img.src = this.src;
}




/* 버튼 클릭 시 개수 증가와 감소& 금액 계산 */
function count(type)  {
	// 결과를 표시할 element
	resultElement = document.getElementsByClassName("result");
	ptotalpriceElement = document.getElementById("p_totalprice"); // 보여질 값
	hiddentpriceElement = document.getElementById("tprice").value; // 진짜 값
	
	// 현재 화면에 표시된 값
	let number = resultElement[0].innerText; // 개수
	
	let totalprice = hiddentpriceElement.replace(",", ""); // 금액 계산용
	

	var ptprice = 0;
	// +/- 개수 & 금액계산
	if(type === 'plus') {

		number = parseInt(number) + 1;
		ptprice = totalprice * number;
		if(number == 6){
			alert("최대 주문 수량은 5개입니다.");
			return;
		}
	} else if (type === 'minus') {
		number = parseInt(number) - 1;
		
		ptprice = (totalprice*(number+1)) - totalprice;
		console.log("여기여기" +ptprice);
		if (number == 0) {
			alert("최소 주문 수량은 1개입니다.");
			return;
		}
	}
 	// 결과 출력
	ptotalpriceElement.innerText = ptprice.toLocaleString();
	resultElement[0].innerText = number;

}














