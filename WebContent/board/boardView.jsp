<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��Ʈ����2 �Խ���</title>
<link rel="stylesheet" href="/Struts2_board/common/css.css" type="text/css">
<script type="text/javascript">
function open_win_noresizable (url, name) {
	var oWin = window.open(url, name, "scrollbars=no, status=no, resizable=no, width=300, height=150");
}
</script>
</head>
<body>
<table width="600" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center"><h2>��Ʈ����2 �Խ���</h2></td>
	</tr>
	<tr>
		<td height="20"></td>
	</tr>
</table>
<table width="600" border="0" cellspacing="0" cellpadding="0">
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	

	<tr>
		<td bgcolor="#F4F4F4">��ȣ</td>
		<td bgcolor="#FFFFFF">
		&nbsp;&nbsp;<s:property value="resultClass.no"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	
	
	<tr>
		<td width="100" bgcolor="#F4F4F4">����</td>
		<td width="500" bgcolor="#FFFFFF">
		&nbsp;&nbsp;<s:property value="resultClass.subject"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	
	<tr>
		<td bgcolor="#F4F4F4">�۾���</td>
		<td bgcolor="#FFFFFF">
		&nbsp;&nbsp;<s:property value="resultClass.name"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	
	<tr>
		<td bgcolor="#F4F4F4">����</td>
		<td bgcolor="#FFFFFF">
		&nbsp;&nbsp;<s:property value="resultClass.content"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	
	
	<tr>
		<td bgcolor="#F4F4F4">��ȸ��</td>
		<td bgcolor="#FFFFFF">
		&nbsp;&nbsp;<s:property value="resultClass.readhit"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	
		
	<tr>
		<td bgcolor="#F4F4F4">��ϳ�¥</td>
		<td bgcolor="#FFFFFF">
		&nbsp;&nbsp;<s:property value="resultClass.regdate"/>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>		
	
	<tr>
		<td bgcolor="#F4F4F4">÷������</td>
		<td bgcolor="#FFFFFF">
		&nbsp;&nbsp;
		<s:url id="download" action="fileDownloadAction">
		<s:param name="no">
		<s:property value="no"/>
		</s:param>
		</s:url>
		
		<s:a href="%{download}"><s:property value="resultClass.file_orgname"/>
		</s:a>
		</td>
	</tr>
	<tr bgcolor="#777777">
		<td height="1" colspan="2"></td>
	</tr>	
	<tr>
		<td height="10" colspan="2"></td>
	</tr>	
	
	<tr>
	<td align="right" colspan="2">
	<s:url id="modifyURL" action="modifyForm">
	<s:param name="no">
	<s:property value="no"/>
	</s:param>
	</s:url>
	
	<s:url id="deleteURL" action="deleteAction">
	<s:param name="no">
	<s:property value="no"/>
	</s:param>
	</s:url>
	
	<input name="list" type="button" value="��۾���" class="inputb" onClick="javascript:location.href='ReplyArticleForm.action?no=<s:property value="resultClass.no"/>&currentPage=<s:property value="currentPage"/>&ref=<s:property value="ref"/>&ref_level=<s:property value="ref_level"/>&ref_step=<s:property value="ref_step"/>'">
	<input name="list" type="button" value="����" class="inputb" onClick="javascript:open_win_noresizable('checkForm.action?no=<s:property value="resultClass.no"/>&currentPage=<s:property value="currentPage"/>','modify')">
	<input name="list" type="button" value="����" class="inputb" onClick="javascript:open_win_noresizable('checkForm.action?no=<s:property value="resultClass.no"/>&currentPage=<s:property value="currentPage"/>','delete')">
	<input name="list" type="button" value="���" class="inputb" onClick="javascript:location.href='listAction.action?no=<s:property value="resultClass.no"/>&currentPage=<s:property value="currentPage"/>'">
	
	</td>
	</tr>
	<tr>
	<td colspan="2" height="10">
	<form action="CommentWriteAction.action" method="post">
	<table>
						<tr>
							<td width="170">
								��&nbsp;&nbsp;&nbsp;&nbsp;�� <s:textfield name="commenter" theme="simple" value="" cssStyle="width:100px" maxlength="20" /><br>
								��й�ȣ <s:textfield name="passwd" theme="simple" value="" cssStyle="width:100px" maxlength="20" />
							</td>
							<s:hidden name="no" value="%{resultClass.no}" />
							<s:hidden name="currentPage" value="%{currentPage}" />
							<td align="left">
								<s:textarea name="comment" theme="simple" value="" cols="60" rows="5" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input name="submit" type="submit" value="�ۼ��Ϸ�" class="inputb">
							</td>
						</tr>
				</table>
				</form>
				<table>
				<tr bgcolor="#777777">
			<td colspan="2" height="1"></td>
			</tr>
	<s:iterator value="commentlist" status="stat">
		<tr>
			<td height="10" width="130" align="center">
				<s:property value="commenter" /><br>
				<s:property value="regdate" /><br><br>
				<s:property value="commentNum" /><br><br>
			</td>
			<td><s:property value="comment"/>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:open_win_noresizable('checkForm2.action?no=<s:property value="no"/>&commentNum=<s:property value="commentNum"/>&currentPage=<s:property value="currentPage"/>','cdelete')"><font color="red">X</font></a>		
			</td>
		</tr>
		
		</s:iterator>		
		<tr>
			<td colspan="2" height="10">
				<s:if test="commentlist.size() <= 0">
				��۾���
			</td>
		</tr>
				</s:if>			
		</table>		
</body>
</html>