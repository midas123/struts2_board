<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>스트럿츠2 게시판</title>
<link rel="stylesheet" href="/Struts2_board/common/css.css" type="text/css">
</head>
<body>
<table width="600" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center"><h2>스트럿츠2 게시판</h2></td>
	</tr>
	<tr>
		<td height="20"></td>
	</tr>
</table>
<table width="600" border="0" cellspacing="0" cellpadding="1">
	<tr align="center" bgcolor="#F3F3F3">
	<td width="50"><strong>번호</strong></td>
	<td width="350"><strong>제목</strong></td>
	<td width="70"><strong>글쓴이</strong></td>
	<td width="80"><strong>날짜</strong></td>
	<td width="50"><strong>조회</strong></td>
</tr>
<tr bgcolor="#777777">
<td height="1" colspan="5"></td>
</tr>

<!--게시글 출력 시작  -->

<s:iterator value="list" status="stat">
<!--아래 url태그는 viewURL id에 viewAction클래스로 URL링크를 걸고 listAction의 프로퍼티 no와 currentPage를 같은 이름의 파라미터로 get방식으로 전송  -->
<s:url id="viewURL" action="viewAction">
<s:param name="no">
<s:property value="no"/>
</s:param>
<s:param name="currentPage">
<s:property value="currentPage"/>
</s:param>
<s:param name="ref">
<s:property value="ref"/>
</s:param>
<s:param name="ref_level">
<s:property value="ref_level"/>
</s:param>
<s:param name="ref_step">
<s:property value="ref_step"/>
</s:param>
</s:url>

<tr bgcolor="#FFFFFF" align="center">
<td><s:property value="no"/></td>
<td align="left">
<s:if test="ref_level!=0">
<c:forEach var = "i" end = "${ref_level}" begin = "0">
&nbsp;</c:forEach>→
</s:if><s:a href="%{viewURL}"><s:property value="subject"/></s:a></td>
<td align="center"><s:property value="name"/></td>
<td align="center"><s:property value="regdate"/></td>
<td><s:property value="readhit"/></td>
</tr>
<tr bgcolor="#777777">
<td height="1" colspan="5"></td>
</tr>
</s:iterator>

<!-- 게시글 출력 종료 -->


<!-- 게시글이 없을 경우 -->
<s:if test="list.size() <= 0">
<tr bgcolor="#FFFFFF" align="center">
<td colspan="5">등록된 게시물이 없습니다.</td>
</tr>
<tr bgcolor="#777777">
<td height="1"colspan="5"></td>
</tr>
</s:if>

<!-- 게시글이 없을 경우, 종료 -->


<!-- 페이징 넘버 출력  -->
<tr align="center">
<td colspan="5"><s:property value="pagingHtml" escape="false"/></td>
</tr>
<tr align="right">
<td colspan="5">
<input type="button" value="글쓰기" class="inputb" onclick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage"/>&ref_level=<s:property value="ref_level"/>';">
</td>
</tr>
</table>
<table align="center">
<tr>
<form action="listSearchAction.action" method="post">
<select name="searchn">
<option value="0">작성자</option>
<option value="1">제목</option>
<option value="2">내용</option>
</select>

<input type="text" name="search" size="15" maxlength="50"/>
<input type="submit" value="검색"/>
</form>
</tr>
</table>
</body>
</html>