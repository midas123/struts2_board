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
		if(!userinput.m_ID.value) {
			alert("ID를 입력하세요");
			return false;
		}
		
		if(!userinput.m_passwd.value) {
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		if(userinput.m_passwd.value != userinput.passwd2.value)
		{
			alert("비밀번호를 동일하게 입력하세요");
			return false;
		}
		
		if(!userinput.m_name.value) {
			alert("사용자 이름을 입력하세요");
			return false;
		}
		
		if(!userinput.m_nickname.value) {
			alert("닉네임을 입력하세요");
			return false;
		}
		
		if(!userinput.m_mobilephone.value) {
			alert("휴대폰번호를 입력하세요");
			return false;
		}
		
		if(!userinput.m_region.value) {
			alert("지역명을 입력하세요");
			return false;
		}
		
		if(!userinput.m_birthyear.value) {
			alert("출생연도를 입력하세요");
			return false;
		}
		
		if(isNan(userinput.m_birthyear.value)) {
			alert("출생연도는 숫자로 입력하세요");
			return false;
		}
		
		if(!userinput.m_email.value) {
			alert("이메일을 입력하세요");
			return false;
		}
		
		
	}
	 // 아이디 중복 여부를 판단
	function openConfirmid(userinput) {
		if(userinput.m_id.value == ""){
			alert("아이디를 입력하세요");
			return;
		}
	//url과 사용자 입력 id를 조합합니다.	
	url = "confirmId.jsp?id=" + userinput.m_id.value;
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

<s:form method="post" action="MemberJoinAction.action" name="userinput" enctype="multipart/form-data">
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
				<input type="text" name="m_ID" size="10" maxlength="12">
<!-- 				<input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)">
 -->			</td>	
		</tr>
		<tr>
			<td width="200">비밀번호</td>
			<td width="400">
				<input type="password" name="m_passwd" size="15" maxlength="12">
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
				<input type="text" name="m_name" size="15" maxlength="10">
			</td>
		</tr>
		<tr>
			<td width="200">닉네임</td>
			<td width="400">
				<input type="text" name="m_nickname" size="15" maxlength="10">
			</td>
		</tr>
		<tr>
			<td width="200">휴대폰 번호</td>
			<td width="400">
				<input type="text" name="m_mobilephone" size="11">
				
			</td>
		</tr>				
		<tr>
			<td width="200">지역</td>
			<td width="400">
				<input type="text" name="m_region" size="30">
			</td>
		</tr>
		<tr>
			<td width="200">출생연도</td>
			<td width="400">
				<input type="text" name="m_birthyear" size="10">
			</td>
		</tr>
		<tr>
			<td width="200">이메일</td>
			<td width="400">
				<input type="text" name="m_email" size="50">
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
			<s:file name="upload" theme="simple"/>
			
			</td>	
		</tr>				
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="confirm" value="등 록" onclick="return checkIt()">
				<input type="reset" name="reset" value="다시 입력">
				<input type="button" value="기입 안함" onclick="javascript:window.location='main.jsp'">
			</td>
		</tr>			
	</table>
	</s:form>
</body>
</html>
