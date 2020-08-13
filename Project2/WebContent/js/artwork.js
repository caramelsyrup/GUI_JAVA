$(document).ready(function(){
	$("#artworkInsertBtn").click(function(){
		// 작품 입력
		if($("#arttitle").val()==""){
			alert('작품제목을 입력하세요.');
			$("#arttitle").focus();
			return false;
		}
		if($("#afilename").val()==""){
			alert('파일 이름을 입력하세요.');
			$("#afilename").focus();
			return false;
		}
		$("#artowrkInsertform").submit();
	})
	
	// 작품 리스트로 가는 버튼
	$("#artworkListBtn").click(function(){
		location.href="artworkList.do";
	});
	
	// 작품 상세보기에서 삭제
	$("#artworkDeleteBtn").click(function(){
		if(confirm("해당 작품을 삭제하시겠습니까?")){
			$("#artworkDeleteform").submit();
		}
	});
	
	
	
});