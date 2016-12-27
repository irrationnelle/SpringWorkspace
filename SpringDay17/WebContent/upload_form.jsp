<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>업로드 폼</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile"><br>
		<input type="submit" value="전송">
	</form>
	
</body>
</html>