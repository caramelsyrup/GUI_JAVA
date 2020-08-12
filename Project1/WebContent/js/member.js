

$(document).ready(function(){
	// 아이디 중복확인 페이지 이동
	$("#idChkBtn").click(function(){
		window.open("idCheckForm.do","","width=800 height=600");
	});
	
	// 아이디 중복확인 기능
	$("#idChkF").click(function(){
		if($("#usr").val()==""){
			alert("아이디를 입력하세요.");
			$("#usr").focus();
			return false;
		}
		
		$.ajax({
			type:"post",
			url:"idCheckForm.do",
			// userId라는 이름으로 id가 usr인 곳의 데이터를 저장.
			data:{"userId":$("#usr").val()},
			success:function(val){
				// 데이터를 url에 저장되어 있는 메소드와 비교
				if(val.trim()=="yes"){
					alert("사용가능");
					$(opener.document).find("#userid").val($("#usr").val());
					$(opener.document).find("#uid").val($("#usr").val());
					self.close();
				}else if(val.trim()=="no"){
					alert("사용불가능");
					$("#userid").val("");
				}
			},
			error:function(e){
				alert("error : "+e);
			}
		});	// ajax
		
	});
	
	// 주소 검색 버튼
	$("#addrBtn").click(function(){
		window.open("addrCheck.do","","width=800 height=600");
	});
	
	
	
});
