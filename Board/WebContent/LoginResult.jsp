<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 굳이안만들고 login.jsp로 보내도되는지
	boolean result = (boolean) request.getAttribute("result");
	if(result) {  // 로그인 성공시
%>
		<script>
			alert("로그인 되었습니다.");
			location.href = "Controller?command=board_list";
		</script>
<%
	} else {   // 로그인 실패시
%>
		<script>
			alert("로그인 정보가 잘못되었습니다.");
			location.href = "login.jsp";
		</script>
<%
	}
%>