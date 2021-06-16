function loginCheak(obj){
	if(!obj.userid.value || obj.userid.value.trim(). length == 0){
		alert("아이디가 입력되지 않았습니다");
		obj.id.value = "";
		obj.id.focus();
		return false;
	}
	if(!obj.password.value || obj.password.value.trim(). length == 0){
		alert("비밀번호를 입력해주세요.");
		obj.password.value = "";
		obj.password.focus();
		return false;
		}
		return true;
		}