<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ID �ߺ�üũ</title>
<script language="javascript">

function setid()
 {
	opener.document.userinput.m_ID.value="<s:property value='m_ID'/>";
 	self.close();
 } 


</script>
</head>
<body>


<s:if test="idcheckresult == 0">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td height="39"><s:property value="%{memberResult.m_ID}"/>�� �̹� ������� ���̵��Դϴ�.</td>
	</tr>	
</table>
<s:form name="checkForm" method="post" action="memberIdCheck.action">
<table width="200" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		�ٸ� ���̵� �Է��ϼ���.<p>
		<input type="text" size="10" maxlength="12" name="m_ID">
		<input type="submit" value="ID�ߺ�Ȯ��">
		</td>
	</tr>	
</table>
</s:form>
</s:if>
<s:elseif test="idcheckresult == 1">

<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
			<p>�Է��Ͻ� <s:property value="m_ID"/>�� ����Ͻ� �� �ִ� ID�Դϴ� </p>
			<input type="button" value="�ݱ�" onclick="setid()">
		</td>
	</tr>
</table>
</s:elseif>
</body>
</html>
