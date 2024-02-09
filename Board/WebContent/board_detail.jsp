<%@page import="java.util.ArrayList"%>
<%@page import="vo.ReplyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BoardVo"%>
<%
	String loginId = "YG";   // 나중에, session.getAttribute("loginId") 로 변경할 것.
							 // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	BoardVo vo = (BoardVo) request.getAttribute("boardVO");
	ArrayList<ReplyVo> listReplyVo = (ArrayList<ReplyVo>)request.getAttribute("listReply");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="js/jquery-3.7.1.min.js"></script>
	<script>
		$(function() {
			$("#btn_to_list").click(function() {
				//history.back(-1);
				location.href = "Controller?command=board_list&page=1";   // (단순화) 1페이지 목록보기로 이동.
			});
			$("#btn_modify").click(function() {
				location.href = "Controller?command=board_modify_form&bno=<%=vo.getBno()%>";
			});
			$("#btn_delete").click(function() {
				location.href = "Controller?command=board_delete&bno=<%=vo.getBno()%>";
			});
			$(".btn_delete_reply").click(function() {
				let rno = $(this).parent().attr("rno");
				//alert(rno);
				$.ajax({
					url: 'Controller',
					type: 'post',
					data: {"rno":rno, "command":"ajax_reply_delete"},
					success: function(data) {
						if(data.result=='OKAY') {
							alert("삭제되었습니다.");
							$(".reply").each(function(index, item) {
								if($(item).attr("rno")==rno) {
									$(item).remove();
								}
							})
						}
					},
					error: function(request, status, error) {
						alert("에러 코드 : " + request.status);
					}
				});
			});
		});
	</script>
	<style>
		table { border-collapse: collapse; border: 1px solid grey; }
		td, th { font-size:14px; border: 1px solid grey; }
		th { width:150px; }
		td { width:650px; }
		.reply > span:nth-child(1) { display: inline-block; width: 20%; }
		.btn_delete_reply { font-weight:bold; color:red; }
	</style>
</head>
<body>
	<h1>게시글 상세보기</h1>
	<table>
		<tr>
			<th>글 번호</th>
			<td><%=vo.getBno() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=vo.getWriter() %></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=vo.getWritedate() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=vo.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=vo.getContent() %></td>
		</tr>
	</table>	
	<button id="btn_to_list">목록보기</button>
	<button id="btn_modify">수정하기</button>
	<button id="btn_delete">삭제하기</button>
	<div id="div_reply">
		<% for(ReplyVo replyVo : listReplyVo) { %>
		<div class="reply" rno="<%=replyVo.getRno()%>">
			<span><%=replyVo.getContent() %></span> 
			<span><%=replyVo.getWriter() %>님</span> 
			/ <%=replyVo.getWritedate().split(" ")[0] %>
			<% if(loginId.equals(replyVo.getWriter())) { %>
				<button class="btn_delete_reply">x</button>
			<% } %>
		</div>
		<% } %>		
	</div>
</body>
</html>





