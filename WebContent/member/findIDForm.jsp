<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script language="javascript">
function begin() {
	document.findid.m_name.focus();
}
function checkIt() {
	if(!document.findid.m_name.value){
		alert("�̸��� �Է����� �����̽��ϴ�.");
		document.myform.m_name.focus();
		return false;
	}
	if(!document.findid.m_email.value){
		alert("�̸����� �Է����� �����̽��ϴ�.");
		document.myform.m_email.focus();
		return false;
	}
}


</script>
<title>ID ã��</title>
</head>
<body onload="begin()">
<s:form name="findid" action="findIDPro" method="post" onsubmit="return checkIt();">
<table width="400" border=1 align="center">
	<tr height="30">
		<td colspan="2" align="center">
		<strong>���̵� ã��</strong>
		</td>
	</tr>
	<tr height="30">
		<td width="110" align=center>�̸�</td>
		<td width="150" align=center>
			<input type="text" name="m_name" size="15" maxlength="12" ></td>
	</tr>
	<tr height="30">
		<td width="110" align="center">�̸����ּ�</td>
		<td width="150" align="center">
			<input type="text" name="m_email" size="30" maxlength="30"></td>
	</tr>		
	<tr height="30">
		<td colspan="2" align="center" >
			<input type="submit" value="ã��">
			<input type="button" value="���" onClick="window.close();">
</td>
</tr>
</table>
</s:form>
</body>
</html>