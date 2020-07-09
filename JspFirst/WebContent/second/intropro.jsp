<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블연습1</title>
<style type="text/css">
	table{
		width: 600px;
		height: 400px;
	}
	table,th,td{
		border: 1px solid black;
	}
	.thColor{
		background-color: lime;
	}
	
	ol{
		list-style-type: armenian;	
	}
	
	ol.olType{
		list-style-type: decimal-leading-zero;
	}
</style>
</head>
<body>
	<form action="introproAction.jsp" method="post">
		<table>
			<thead>
				<tr>
					<th>성명</th>
					<td><input type="text" name="name" size="10"></td>
					<th>성별</th>
					<td  align="center">
						<input type="radio" name="gender" value="man">남
						<input type="radio" name="gender" value="woman">여
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="3" align="left">
						<input type="text" name="year" size="7">년
						<input type="text" name="month" size="3">월
						<input type="text" name="day" size="3">일
						<input type="radio" name="calendar" value="solar">양력
						<input type="radio" name="calendar" value="lunar">음력
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="3"><input type="text" name="address" size="50"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td colspan="3" align="left">
						<input type="text" name="phoneNumber1" size="5">-
						<input type="text" name="phoneNumber2" size="5">-
						<input type="text" name="phoneNumber3" size="5">
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th colspan="4" class="thColor">사용가능한 프로그램 선택하기</th>
				</tr>
				<tr>
					<td align="left" colspan="4">
						<ol class="olType" type="A">
							<li><input type="checkbox" name="PROGRAM" value="한글">한글</li>
							<li><input type="checkbox" name="PROGRAM" value="포토샵">포토샵</li>
							<li><input type="checkbox" name="PROGRAM" value="매크로미디어디렉터">매크로 미디어 디렉터</li>
							<li><input type="checkbox" name="PROGRAM" value="드림위버">드림위버</li>
							<li><input type="checkbox" name="PROGRAM" value="3DMAX">3D MAX</li>
						</ol>
					</td>
				</tr>
				<tr>
					<th colspan="4" class="thColor">가고싶은 여행지를 모두 선택하세요.</th>
				</tr>
				<tr>
					<td align="left" colspan="4">
						<select name="place" size="3" title="여행지" multiple="multiple">	
							<option value="Seoraksan">설악산</option>
							<option value="Haeundae">해운대</option>
							<option value="Geumjeongsanseong Fortress">금정산성</option>
							<option value="Gwangalli">광안리</option>
							<option value="DongnaeHotSpring">동래온천</option>
						</select>
					</td>
				</tr>
				<tr>
					<th colspan="4" class="thColor">미래의 꿈은 어떠한가요</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea rows="5" cols="50" name="memo"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="보내기">
						<input type="reset" value="취소">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>	
</body>
</html>