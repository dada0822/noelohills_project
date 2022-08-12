function checkMember(){
	let regExpId = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,16}$/; // 영문 숫자 4~16
	let regExpPasswd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,16}$/; // 영문 숫자 특수기호 10~16
	let regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	let regExpName = /^[가-힣|a-z|A-Z]*$/; // 한글 영어
	let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/; // 3자리 - 3or4자리 - 4자리
	let regExpAddress = /^([a-zA-Z가-힣0-9_-])*$/;
	
	let form = document.signup_frm;
	let m_address = form.m_address.value;
	
	
	if(form.m_id.value== ""){
		alert("아이디를 입력하세요.");
		form.m_id.value.focus();
		return false;
	} 
	if (!regExpId.test(form.m_id.value)) {
		alert("아이디는 4~16글자로 숫자와 영문을 조합해서 작성해 주세요.");
		form.m_id.value.select();
		return false;
	}
	
	if(form.m_pw.value== ""){
		alert("비밀번호를 입력하세요.");
		form.m_pw.focus();
		return false;	
	}
	
	if(form.m_pw_re.value== ""){
		alert("비밀번호 재확인을 입력하세요.");
		form.m_pw_re.focus();
		return false;
	}
	
	if(!regExpPasswd.test(form.m_pw.value)){
		alert("비밀번호는 10~16글자로 영문과 숫자, 특수기호를 조합해서 작성해 주세요.");
		form.m_pw.value.select();
		return false;
	}
	
	if(form.m_pw.value != form.m_pw_re.value){
		alert("비밀번호 값이 다릅니다.");
		form.m_pw.value="";
		form.m_pw_re.value="";
		form.m_pw.value.focus();
		return false;
	}
	
	if(form.m_email.value== ""){
		alert("이메일을 입력하세요.");
		form.m_email.focus();
		return false;
	}
	
	if (!regExpEmail.test(form.m_email.value)) {
		alert("이메일 형식을 확인해 주세요. (dada@naver.com)");
		form.m_email.value.select();
		return false;
	}
	
	if(form.m_name.value== ""){
		alert("이름을 입력하세요.");
		form.m_name.focus();
		return false;
	}
	
	if (!regExpName.test(form.m_name.value)) {
		alert("이름은 한글이나 영어로만 작성해 주세요.");
		form.m_name.value.select();
		return false;
	}
	
	if(form.m_address.value== ""){
		alert("주소를 입력하세요.");
		form.m_address.focus();
		return false;
	}
	
	if (!regExpAddress.test(m_address.replace(/\s/gi, ""))) {
		alert("주소에 특수문자는 '-'와 '_'만 들어갈 수 있습니다.");
		form.m_address.value.select();
		return false;
	}
	
	if(form.m_tel.value== ""){
		alert("연락처를 입력하세요.");
		form.m_tel.focus();
		return false;
	}
	
	if (!regExpPhone.test(form.m_tel.value)) {
		alert("연락처 형식을 확인해 주세요. (010-1111-1111)");
		form.m_tel.value.select();
		return false;
	} 
	form.submit();
	
}