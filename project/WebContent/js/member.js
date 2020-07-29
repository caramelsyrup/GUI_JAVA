var exp = /^[0-9]{3}[0-9]{4}[0-9]{4}$/;

$(document).ready(function(){
	$("#send").click(function(){
		
		if($("#userId").val()==""){
			alert('아이디를 입력하세요.');
			$("#userId").focus();
			return false;
		}
		if($("#pwd").val()==""){
			alert('비밀번호를 입력하세요.');
			$("#pwd").focus();
			return false;
		}
		if($("#name").val()==""){
			alert('이름을 입력하세요.');
			$("#name").focus();
			return false;
		}
		if($("#email").val()==""){
			alert('이메일을 입력하세요.');
			$("#email").focus();
			return false;
		}
		if(!$("#phone").val().match(exp)){
			alert('전화번호를 입력하세요.');
			$("#phone").focus();
			return false;
		}
	});
	
	// 아이디 중복확인
	$("#idChk").click(function(){
		window.open("idCheck.jsp","","width=800 height=600");
	});
	
});