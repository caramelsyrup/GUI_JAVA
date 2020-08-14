$(document).ready(function(){
	// 행사 추가 버튼 누를시
	$("#eventsinsertBtn").click(function(){
		location.href="eventsInsertForm.do";
	});
	
	// 행사 추가 페이지에서 추가 메소드 실행
	$("#eventsInsertBtn").click(function(){
		if($("#eventname").val()==""){
			alert('행사제목 입력하세요.');
			$("#eventname").focus();
			return false;
		}
		if($("#eventdescip").val()==""){
			alert('행사내용 입력하세요.');
			$("#eventdescip").focus();
			return false;
		}
		$("#eventsInsertform").submit();
	});
	
	// 행사 목록으로 가는 버튼
	$("#eventsListBtn").click(function(){
		location.href="eventslist.do";
	});
	
	// 행사 참석하기 버튼
	$("#reservationeventsBtn").click(function(){
		
	});
	
});