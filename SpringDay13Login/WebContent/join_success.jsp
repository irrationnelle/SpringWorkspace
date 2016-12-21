<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>join_success.jsp</title>
</head>
<body>
<h2>회원가입이 완료되었습니다.</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${joinMemberInfo.id}</td>
			<td>${joinMemberInfo.phone}</td>
			<td>${joinMemberInfo.email}</td>
		</tr>
	</table>

</body>
</html>