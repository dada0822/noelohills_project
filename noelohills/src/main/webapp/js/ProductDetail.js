/* 이미지 호버 시 이미지 바꾸기 */
let main_img = document.querySelector("#main_img");
let small_img = document.querySelectorAll(".small_img");

for(let i=0; i<small_img.length; i++){
    small_img[i].addEventListener("mouseover", showBig);
}

function showBig(){
   main_img.src = this.src;
}




/* 버튼 클릭 시 숫자 증가 감소 */
function count(type)  {
  // 결과를 표시할 element
  /*const resultElement = document.getElementById('result');*/
  
	resultElement = document.getElementsByClassName("result");
	ptotalpriceElement = document.getElementById("ptotalprice");
	
	for(var i = 0; i < resultElement.length; i++) {

		// 현재 화면에 표시된 값
		let number = resultElement[i].innerText;
  		let ptotalprice = ptotalpriceElement.innerText;
  		let totalprice = ptotalprice.replace(",", "");
  		console.log(totalprice);
		
		var ptprice=0;
		// 더하기/빼기
		if(type === 'plus') {
			var ptprice = 0;

			number = parseInt(number) + 1;
			ptprice = totalprice * number;
			if(number == 6){
				alert("최대 주문 수량은 5개입니다.");
				return;
			}
		} else if (type === 'minus') {
			number = parseInt(number) - 1;
			
    		if (number == 0) {
				alert("최소 주문 수량은 1개입니다.");
				return;
			}
  		}
  
	 	// 결과 출력
		/*resultElement.innerText = number;*/
		resultElement[i].innerText = number;
		// ptotalpriceElement.innerText = totalprice;
		ptotalpriceElement.innerText = ptprice;
  	}
}


/*const sell_price = document.getElementsByName("sell_price");
const amount = document.getElementsByName("amount");
const add = document.getElementsByName("add").values;
const minus = document.getElementsByName("minus");
const sum = document.getElementsByName("sum");


if(add) {
	add.addEventListener('click', function(){
		amount++;
		sum= amount*price;
		
	})
}*/












