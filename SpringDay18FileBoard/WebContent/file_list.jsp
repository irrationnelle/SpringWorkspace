<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>file_list.jsp</title>
</head>
<body>
	<table>
		<tr>
			<th>���Ϲ�ȣ</th>
			<th>�����̸�</th>
			<th>����������</th>
		</tr>
		<c:choose>
			<c:when test="${empty fileList}">
				<tr>
					<td colspan="3">
						���ε� �� ������ �������� �ʽ��ϴ�.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fileList}" var="f">
					<tr>
						<td>${f.fileNum}</td>
						<td>${f.originalName}</td>
						<td>${f.savedPath}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<a href="uploadForm.do"><button>���ε�</button></a>
</body>
</html>