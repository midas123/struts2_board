<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javaScript">
	function checkIt(){
		var useinput = eval("document.userinput");
		if(!userinput.m_ID.value) {
			alert("ID�� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_passwd.value) {
			alert("��й�ȣ�� �Է��ϼ���");
			return false;
		}
		
		if(userinput.m_passwd.value != userinput.passwd2.value)
		{
			alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_name.value) {
			alert("����� �̸��� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_nickname.value) {
			alert("�г����� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_mobilephone.value) {
			alert("�޴�����ȣ�� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_region.value) {
			alert("�������� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_birthyear.value) {
			alert("��������� �Է��ϼ���");
			return false;
		}
		
		if(isNan(userinput.m_birthyear.value)) {
			alert("��������� ���ڷ� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.m_email.value) {
			alert("�̸����� �Է��ϼ���");
			return false;
		}
		
		
	}
	 // ���̵� �ߺ� ���θ� �Ǵ�
	function openConfirmid(userinput) {
		if(userinput.m_id.value == ""){
			alert("���̵� �Է��ϼ���");
			return;
		}
	//url�� ����� �Է� id�� �����մϴ�.	
	url = "confirmId.jsp?id=" + userinput.m_id.value;
	//���ο� �����츦 ���ϴ�.
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
				<font size="+1"><b>ȸ������</b></font></td>
		</tr>
		<tr>
			<td width="200"><b>���̵� �Է�</b></td>
			<td width="400"></td>
		</tr>
		<tr>
			<td width="200"> ����� ID </td>
			<td width="400">
				<input type="text" name="m_ID" size="10" maxlength="12">
<!-- 				<input type="button" name="confirm_id" value="ID�ߺ�Ȯ��" OnClick="openConfirmid(this.form)">
 -->			</td>	
		</tr>
		<tr>
			<td width="200">��й�ȣ</td>
			<td width="400">
				<input type="password" name="m_passwd" size="15" maxlength="12">
			</td>
		</tr>
		<tr>
			<td width="200">��й�ȣ Ȯ��</td>
			<td width="400">
				<input type="password" name="passwd2" size="15" maxlength="12">
			</td>
		</tr>				
		<tr>
			<td width="200"><b>�������� �Է�</b></td>
			<td width="400"> </td>
		</tr>
		<tr>
			<td width="200">�̸�</td>
			<td width="400">
				<input type="text" name="m_name" size="15" maxlength="10">
			</td>
		</tr>
		<tr>
			<td width="200">�г���</td>
			<td width="400">
				<input type="text" name="m_nickname" size="15" maxlength="10">
			</td>
		</tr>
		<tr>
			<td width="200">�޴��� ��ȣ</td>
			<td width="400">
				<input type="text" name="m_mobilephone" size="11">
				
			</td>
		</tr>				
		<tr>
			<td width="200">����</td>
			<td width="400">
				<input type="text" name="m_region" size="30">
			</td>
		</tr>
		<tr>
			<td width="200">�������</td>
			<td width="400">
				<input type="text" name="m_birthyear" size="10">
			</td>
		</tr>
		<tr>
			<td width="200">�̸���</td>
			<td width="400">
				<input type="text" name="m_email" size="50">
			</td>
		</tr>
		
		<!-- <tr>
			<td width="200">�����ȣ</td>
			<td><input type="text" name="zipcode" size="7">
				<input type="button" value="�����ȣã��" onclick="zipCheck()">
				�����ȣ�� �˻��ϼ���.</td>
		</tr> -->
		<tr>
			<td>�����ʻ���</td>
			<td>
			<s:file name="upload" theme="simple"/>
			
			</td>	
		</tr>				
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="confirm" value="�� ��" onclick="return checkIt()">
				<input type="reset" name="reset" value="�ٽ� �Է�">
				<input type="button" value="���� ����" onclick="javascript:window.location='main.jsp'">
			</td>
		</tr>			
	</table>
	</s:form>
</body>
</html>
