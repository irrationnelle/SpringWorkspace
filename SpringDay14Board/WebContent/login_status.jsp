<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 상태보기</title>
</head>
<body>
	<c:if test="${not empty sessionScope.loginID}">
		${sessionScope.loginID}님 로그인 상태입니다.
	</c:if>
	
	<c:if test="${empty sessionScope.loginID}">
		로그인 정보가 없습니다.<br>
		<a href="loginForm.do">[로그인 하러가기]</a>
	</c:if>	
</body>
</html>