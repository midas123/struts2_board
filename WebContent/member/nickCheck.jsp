<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�г��� �ߺ�üũ</title>
<script language="javascript">

function setnick()
 {
	opener.document.userinput.m_nickname.value="<s:property value='m_nickname'/>";
 	self.close();
 } 


</script>
</head>
<body>


<s:if test="nickcheckresult == 0">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td height="39"><s:property value="%{memberResult.m_nickname}"/>�� �̹� ������� �г����Դϴ�.</td>
	</tr>	
</table>
<s:form name="checkForm" method="post" action="memberNickCheck.action">
<table width="200" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		�ٸ� �г����� �Է��ϼ���.<p>
		<input type="text" size="20" name="m_nickname">
		<input type="submit" value="�г��� �ߺ�Ȯ��">
		</td>
	</tr>	
</table>
</s:form>
</s:if>
<s:elseif test="nickcheckresult == 1">

<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
			<p>�Է��Ͻ� [<s:property value="m_nickname"/>]�� ����Ͻ� �� �ִ� �г����Դϴ� </p>
			<input type="button" value="�ݱ�" onclick="setnick()">
		</td>
	</tr>
</table>
</s:elseif>
</body>
</html>
