// 정규식 표현
var exp = /^[0-9]{3}[1-9]{1}[0-9]{3}[0-9]{4}$/;


$(document).ready(function(){
	$("#send").click(function(){
		if($("#userName").val()==""){
			alert("이름을 입력하세요");
			$("#userName").focus();
			return false;
		}
		//아이디,비번,전화번호
		if($("#userID").val()==""){
			alert("아이디를 입력하세요.");
			$("#userID").focus();
			return false;
		}
		if($("#userPwd").val()==""){
			alert("암호를 입력하세요.");
			$("#userPwd").focus();
			return false;
		}
		if($("#userPwdchk").val()==""){
			alert("암호확인을 입력하세요.");
			$("#userPwdchk").focus();
			return false;
		}
		if($("#userPwd").val() != $("#userPwdchk").val()){
			alert("암호를 확인해 주세요.")
			return false;
		}
		if(!$("#userTel").val().match(exp)){
			alert("전화번호 양식을 맞춰주세요.");
			$("#userTel").focus();
			return false;
		}
		
		$("#frm").submit();
	});
	
	$("#idChk").click(function(){
		window.open("idCheck.jsp","","width=800 height=600");
	});
	
	$("#idCheckBtn").click(function(){
		if($("#userID").val()==""){
			alert("아이디를 입력하세요.");
			$("#userID").focus();
			return false;
		}
		$.ajax({
			type:"post",
			url:"idCheckPro.jsp",
			data:{"userID":$("#userID").val()},
			// 성공시 idCheckPro파일의 실행 된 결과를 출력해냄.
			success:function(userID){
				if(userID.trim()=="yes"){
					alert("사용 가능한 아이디 입니다.");
					$(opener.document).find("#userID").val($("#userID").val());
					$(opener.document).find("#uid").val($("#userID").val());
					self.close();
				}
				else{
					alert("사용 불가능한 아이디 입니다.");
				}
			},
			error:function(e){
				alert("error:"+e);
			}
		});	// $.ajax
	});	// click
	
});