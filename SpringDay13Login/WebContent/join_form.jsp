<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>회원가입 창</title>
</head>
<body>
	<form action="join.do" method="post">
	<table border="1">
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" size="10"></td>
		</tr>
		<tr>
			<td>PASSWORD</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>




