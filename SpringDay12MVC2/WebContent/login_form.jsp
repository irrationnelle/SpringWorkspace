<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>로그인 입력 화면</title>
</head>
<body>
<!-- login_form.jsp -->
<form action="login.do" method="post">
	ID:<input type="text" name="userId" size="10"><br>
	PW:<input type="password" name="userPw" size="10"><br>
	<input type="submit" value="로그인">
</form>

</body>
</html>