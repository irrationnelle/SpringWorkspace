<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>업로드 폼</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		제목: <input type="text" name="title" size="10"><br>
		<input type="file" name="myFile"><br>
		<input type="submit" value="전송">
	</form>
	<a href="download.do">[파일 다운로드]</a>
</body>
</html>