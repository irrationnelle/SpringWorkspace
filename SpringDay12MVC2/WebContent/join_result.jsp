<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>join_result.jsp</title>
</head>
<body>
<h3>회원가입(임시) 완료</h3>
	<table>
		<tr>
			<td>이름</td>
			<td>${joinMember.name}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${joinMember.id}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${joinMember.email}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${joinMember.address}</td>
		</tr>
	</table>
</body>
</html>