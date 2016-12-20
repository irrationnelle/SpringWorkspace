<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입화면</title>
</head>
<body>
	<form action="join.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="10"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="password" size="10"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" size="10"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="10"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" size="10"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>