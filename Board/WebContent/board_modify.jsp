<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BoardVo"%>
<%
	BoardVo vo = (BoardVo) request.getAttribute("vo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정하기</h1>
	<form action="Controller?command=board_modify_action" method="post">
		<input type="hidden" name="bno" value="<%=vo.getBno()%>"/>
		제목 : <input type="text" name="title" value="<%=vo.getTitle()%>"/> <br/>
		내용 : <textarea name="content"><%=vo.getContent()%></textarea> <br/>
		<input type="submit" value="수정완료"/>
	</form>
</body>
</html>