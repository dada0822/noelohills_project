/* 선택 상품 삭제하기 */
function selectedDelConfirm(p_code){
	var isDel = confirm("선택한 상품을 삭제하시겠습니까?");
	if(isDel)
		location.href='./basketDelete.do?p_code='+p_code;
	else
		return;
}; 

/* 상품 전체 삭제하기 */
function allDelConfirm(){
	var isDel = confirm("장바구니를 비우시겠습니까?");
	if(isDel)
		location.href='./basketDelete.do'
	else
		return;
}; 
