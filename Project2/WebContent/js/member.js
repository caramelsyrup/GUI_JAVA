// 전화 번호 변수 저장
var exp = /^[0-9]{3}[0-9]{4}[0-9]{4}$/;

$(document).ready(function(){
	// 로그인 화면
	$("#loginbtn").click(function(){
		if($("#userid").val()==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus();
			return false;
		}
		
		if($("#userpwd").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#userpwd").focus();
			return false;
		}
		
		$.ajax({
			type:"post",
			url:"login.do",
			data:{"userid":$("#userid").val(),"userpwd":$("#userpwd").val()},
			success :function(value){
				if(value.trim()==-1){
					alert("회원아닙니다.");
				}else if(value.trim()==0){
					alert("일반회원.");
					location.href="main.do";
				}else if(value.trim()==1){
					alert("관리자.");
					location.href="memberlist.do";
				}else if(value.trim()==2){
					alert("암호가아닙니다.");
				}
			},
			error : function(e){
				alert("error : "+e);
			}
		});	// $.ajax
		
	})
	
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
					$(opener.document).find("#juserid").val($("#usr").val());
//					$(opener.document).find("#uid").val($("#usr").val());
					self.close();
				}else if(val.trim()=="no"){
					alert("사용불가능");
					$("#juserid").val("");
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
	
	// 주소 창이 빈칸일떄
	$("#addrChkF").click(function(){
		if($("#addrChk").val()==""){
			alert("동 주소를 입력하세요.");
			$("#addrChk").focus();
			return false;
		}
		// 기입한 주소 정보를 검색하여, 결과 값을 출력
		$.post("addrCheck.do",{"addrChk":$("#addrChk").val()},
				function(data){
					data = JSON.parse(data);
					var htmlStr="";
					htmlStr +="<table>";
					for(var i=0; i<data.jarr.length; i++){
						htmlStr+="<tr>";
						htmlStr+="<td>"+data.jarr[i].zipcode+"</td>";
						htmlStr+="<td>"+data.jarr[i].sido+"</td>";
						htmlStr+="<td>"+data.jarr[i].gugun+"</td>";
						htmlStr+="<td>"+data.jarr[i].dong+"</td>";
						htmlStr+="<td>"+data.jarr[i].bunji+"</td>";
						htmlStr+="</tr>";
					}
					htmlStr+="</table>";
					$("#area").html(htmlStr);
				}	// 콜백function
		);	// post
	
		// 출력값 영역을 클릭하면, 주소에 자동 입력
		$("#area").on("click","tr",function(){
			var address=$("td:eq(1)",this).text()+" "+$("td:eq(2)",this).text()+" "+$("td:eq(3)",this).text()+" "+$("td:eq(4)",this).text();
			$(opener.document).find("#userzipcode").val($("td:eq(0)",this).text());
			$(opener.document).find("#useraddr").val(address);
			self.close();
		});
	});
	
	// 회원 가입 버튼
	$("#joinbtn").click(function(){

		if($("#juserid").val()==""){
			alert("아이디를 입력하세요.");
			$("#juserid").focus();
			return false;
		}
		if($("#juserpwd").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#juserpwd").focus();
			return false;
		}
		if($("#username").val()==""){
			alert("이름을 입력하세요");
			$("#username").focus();
			return false;
		}
		if($("#usertel").val()==""){
			alert("전화번호를 입력하세요");
			$("#usertel").focus();
			return false;
		}
		if(!$("#usertel").val().match(exp)){
			alert("전화번호 양식을 맞춰주세요.");
			$("#usertel").focus();
			return false;
		}
		$("#joinform").submit();
	});
	
	// 관리자-회원 상세 정보 페이지 수정버튼
	$("#updatememberBtn").click(function(){
		if(confirm('정말로 수정 하시겠습니까?')){
			$("#memberUpdateform").submit();
		}
	});
	
	// 관리자-회원 상세 정보 페이지 삭제버튼
	$("#deletememberBtn").click(function(){
		if(confirm('정말로 삭제 하시겠습니까?')){
			$.ajax({
				type:"post",
				url:"memberdelete.do",
				data:{"userid":$("#upuserid").val()},
				success:function(val){
					alert('삭제되었습니다.');
					location.href="memberlist.do";
				},
				error:function(e){
					alert(e);
				}
			});
		}
	});
	
	// 관리자-회원 목록 가기 버튼
	$("#listmemberBtn").click(function(){
		location.href="memberlist.do";
	});
	
});
