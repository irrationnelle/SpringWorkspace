<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>�α��� ���º���</title>
</head>
<body>
	<c:if test="${not empty sessionScope.loginID}">
		${sessionScope.loginID}�� �α��� �����Դϴ�.
	</c:if>
	
	<c:if test="${empty sessionScope.loginID}">
		�α��� ������ �����ϴ�.<br>
		<a href="loginForm.do">[�α��� �Ϸ�����]</a>
	</c:if>	
</body>
</html>