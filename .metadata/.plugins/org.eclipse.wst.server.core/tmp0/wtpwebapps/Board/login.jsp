<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body>div {
   width:225px;
   margin:200px auto;
   padding:20px;
   border:1px solid #afafaf;   
}
tr > td input {
   width:100%;
}
</style>
</head>
<body>
	<div>
		<h1>로그인</h1>
		<form action="Controller?command=board_login" method="post">
			<table>
				<tr>
					<td>ID :</td>
					<td><input type="text" name="id" /></td>
				</tr>

				<tr>
					<td>PW :</td>
					<td><input type="password" name="pw" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>

				<tr>
					<td colspan="2"><a id="btn_join" class="btn_join" href="Join.jsp">회원가입</a></td>
				</tr>

			</table>
		</form>
	</div>

	<!-- <form action="Controller?command=board_login" method="post"> 
		ID : <input type="text" name="id"/> <br/>
		PW : <input type="password" name="pw"/> <br/>
		<input type="submit" value="로그인"/>
	</form>
	<a id="btn_join" class="btn_join" href="Join.jsp">회원가입</a><br/> -->
</body>
</html>






