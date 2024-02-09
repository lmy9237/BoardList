<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
body>div {
	width: 250px;
	margin: 200px auto;
	padding: 20px;
	border: 1px solid #afafaf;
}
tr>td input {
	width: 100%;
}
</style>
</head>
<body>
	<div>
		<h1>회원가입</h1>
		<form action="Controller?command=register_member_insert" method="post">
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
					<td>Name :</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" class = "join_submit" value="작성완료"/></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>