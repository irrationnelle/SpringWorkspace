<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>ȸ������ȭ��</title>
</head>
<body>
	<form action="join.do" method="post">
		<table border="1">
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id" size="10"></td>
			</tr>
			<tr>
				<td>�н�����</td>
				<td><input type="password" name="password" size="10"></td>
			</tr>
			<tr>
				<td>�̸���</td>
				<td><input type="email" name="email" size="10"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="name" size="10"></td>
			</tr>
			<tr>
				<td>�ּ�</td>
				<td><input type="text" name="address" size="10"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ȸ������"></td>
			</tr>
		</table>
	</form>
</body>
</html>