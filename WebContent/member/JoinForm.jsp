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
		if(!userinput.id.value) {
			alert("ID�� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.passwd.value) {
			alert("��й�ȣ�� �Է��ϼ���");
			return false;
		}
		
		if(userinput.passwd.value != userinput.passwd2.value)
		{
			alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.name.value) {
			alert("����� �̸��� �Է��ϼ���");
			return false;
		}
		
		if(!userinput.jumin1.value || !userinput.jumin2.value)
			{
			alert("�ֹε�Ϲ�ȣ�� �Է��ϼ���");
			return false;
			}
	}
	 // ���̵� �ߺ� ���θ� �Ǵ�
	function openConfirmid(userinput) {
		if(userinput.id.value == ""){
			alert("���̵� �Է��ϼ���");
			return;
		}
	//url�� ����� �Է� id�� �����մϴ�.	
	url = "confirmId.jsp?id=" + userinput.id.value;
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

<form method="post" action="inputPro.jsp" name="userinput" onSubmit="return checkIt()">
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
				<input type="text" name="id" size="10" maxlength="12">
				<input type="button" name="confirm_id" value="ID�ߺ�Ȯ��" OnClick="openConfirmid(this.form)">
			</td>	
		</tr>
		<tr>
			<td width="200">��й�ȣ</td>
			<td width="400">
				<input type="password" name="passwd" size="15" maxlength="12">
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
				<input type="text" name="name" size="15" maxlength="10">
			</td>
		</tr>
		<tr>
			<td width="200">�޴��� ��ȣ</td>
			<td width="400">
				<input type="text" name="mobilephone" size="11">
				
			</td>
		</tr>				
		<tr>
			<td width="200">����</td>
			<td width="400">
				<input type="text" name="region" size="30">
			</td>
		</tr>
		<tr>
			<td width="200">�������</td>
			<td width="400">
				<input type="text" name="blog" size="10">
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
			<s:file name="pro_image" theme="simple"/>
			
			</td>	
		</tr>				
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="confirm" value="�� ��">
				<input type="reset" name="reset" value="�ٽ� �Է�">
				<input type="button" value="���� ����" onclick="javascript:window.location='main.jsp'">
			</td>
		</tr>			
	</table>
	</form>
</body>
</html>
