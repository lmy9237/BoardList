<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%
	Object obj = request.getAttribute("listBoard");
	ArrayList<BoardVo> list1 = (ArrayList<BoardVo>) obj;   // 자-부 (X)
	
	int pageNum = (Integer) request.getAttribute("pageNum");
	int startPNum = (Integer) request.getAttribute("startPNum");
	int endPNum = (Integer) request.getAttribute("endPNum");
	int lastPageNum = (int) request.getAttribute("lastPageNum");
	
	String msg = (String) request.getAttribute("msg");
	request.setAttribute("msg", null);
%>
<%
	if(msg!=null) {
%>
		<script>alert("<%=msg%>");</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		$(function() {
			$("tr").click(function() {
				let bno = $(this).find(".bno").text();
				//alert("상세보기 가야돼 bno : " + bno);
				location.href = "Controller?command=board_detail&bno=" + bno;
			});
			$("#btn_write").click(function() {
				location.href = "Controller?command=board_write_form";
			});
			$("#btn_logout").click(function() {
				location.href = "Controller?command=board_logout";
			});

		});
	</script>
	<style>
		.fl { float: left; }
		.fr { float: right; }
		table { border-collapse: collapse; border: 1px solid grey; }
		td, th { font-size:14px; }
		#pagination { 
			font-size: 30px;
		    width: 300px;
	    	margin: 0 auto; 
		}
		#pagination a {
			text-decoration: none;
		}
	</style>		
</head>
<body>
	<div class="container">
		<h1>게시글 전체보기</h1>
		<button id="btn_logout" class="fr">로그아웃</button>
		<div style="clear:both;"></div>
		<table class="table table-striped" page="<%=pageNum%>">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
			<%
				for(BoardVo vo : list1) {
			%>
					<tr>
						<td class="bno"><%=vo.getBno() %></td>
						<td><%=vo.getTitle() %> <%=(vo.getNor()>0) ? "["+vo.getNor()+"]" : "" %></td>
						<td><%=vo.getWriter() %></td>
						<td><%=vo.getWritedate() %></td>
					</tr>
			<%
				}
			%>
		</table>
		<button id="btn_write">글쓰기</button>
		<div id="pagination">
			<% if(startPNum>1) { %>
				<a href="Controller?command=board_list&page=<%=startPNum-1%>">&lt;&lt;</a>
			<% } %>
			<% for(int i=startPNum; i<=endPNum; i++) { %>
			<%	if(i>lastPageNum) break; %>
			<%	if(i==pageNum) { %>
				<span><%=i %></span>
			<%  } else {  %>
				<a href="Controller?command=board_list&page=<%=i%>"><%=i %></a>
			<%  } %>
			<% } %>
			<% if(endPNum+1 <= lastPageNum) { %>
				<a href="Controller?command=board_list&page=<%=endPNum+1%>">&gt;&gt;</a>
			<% } %>
		</div>
	</div>	
</body>
</html>







