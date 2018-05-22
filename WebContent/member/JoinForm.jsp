<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javaScript">
	function checkIt(){
		var useinput = eval("document.userinput");
		if(!userinput.id.value) {
			alert("ID를 입력하세요");
			return false;
		}
		
		if(!userinput.passwd.value) {
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		if(userinput.passwd.value != userinput.passwd2.value)
		{
			alert("비밀번호를 동일하게 입력하세요");
			return false;
		}
		
		if(!userinput.name.value) {
			alert("사용자 이름을 입력하세요");
			return false;
		}
		
		if(!userinput.jumin1.value || !userinput.jumin2.value)
			{
			alert("주민등록번호를 입력하세요");
			return false;
			}
	}
	 // 아이디 중복 여부를 판단
	function openConfirmid(userinput) {
		if(userinput.id.value == ""){
			alert("아이디를 입력하세요");
			return;
		}
	//url과 사용자 입력 id를 조합합니다.	
	url = "confirmId.jsp?id=" + userinput.id.value;
	//새로운 윈도우를 엽니다.
	open(url, "confirm", "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300, height=200");
	}
	
	function zipCheck(){
		url="Zipcheck.jsp?check=";
		window.open(url,"post","toolbar=no, width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
	}
	
	function zipCheck_daum() {
		url="Zipcheck_daum.jsp?check=";
		window.open(url,"post","toolbar=no, width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
	}
</script>
</head>

<body>

<form method="post" action="inputPro.jsp" name="userinput" onSubmit="return checkIt()">
	<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
		<tr>
			<td colspan="2" height="39" align="center" >
				<font size="+1"><b>회원가입</b></font></td>
		</tr>
		<tr>
			<td width="200"><b>아이디 입력</b></td>
			<td width="400"></td>
		</tr>
		<tr>
			<td width="200"> 사용자 ID </td>
			<td width="400">
				<input type="text" name="id" size="10" maxlength="12">
				<input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)">
			</td>	
		</tr>
		<tr>
			<td width="200">비밀번호</td>
			<td width="400">
				<input type="password" name="passwd" size="15" maxlength="12">
			</td>
		</tr>
		<tr>
			<td width="200">비밀번호 확인</td>
			<td width="400">
				<input type="password" name="passwd2" size="15" maxlength="12">
			</td>
		</tr>				
		<tr>
			<td width="200"><b>개인정보 입력</b></td>
			<td width="400"> </td>
		</tr>
		<tr>
			<td width="200">이름</td>
			<td width="400">
				<input type="text" name="name" size="15" maxlength="10">
			</td>
		</tr>
		<tr>
			<td width="200">휴대폰 번호</td>
			<td width="400">
				<input type="text" name="mobilephone" size="11">
				
			</td>
		</tr>				
		<tr>
			<td width="200">지역</td>
			<td width="400">
				<input type="text" name="region" size="30">
			</td>
		</tr>
		<tr>
			<td width="200">출생연도</td>
			<td width="400">
				<input type="text" name="blog" size="10">
			</td>
		</tr>
		<!-- <tr>
			<td width="200">우편번호</td>
			<td><input type="text" name="zipcode" size="7">
				<input type="button" value="우편번호찾기" onclick="zipCheck()">
				우편번호를 검색하세요.</td>
		</tr> -->
		<tr>
			<td>프로필사진</td>
			<td>
			<s:file name="pro_image" theme="simple"/>
			
			</td>	
		</tr>				
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="confirm" value="등 록">
				<input type="reset" name="reset" value="다시 입력">
				<input type="button" value="기입 안함" onclick="javascript:window.location='main.jsp'">
			</td>
		</tr>			
	</table>
	</form>
</body>
</html>
