<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>upload_result.jsp</title>
</head>
<body>
upload_result.jsp<br>
<h3>업로드가 완료되었습니다</h3>
원래 이름: <b>${originalName}</b> <br>
서버에 저장된 경로 : <b>${savedPath}</b> <br>
title 파라미터: <b>${title}</b> <br>

<a href="uploadForm.do">업로드 한 번 더?</a>
</body>
</html>