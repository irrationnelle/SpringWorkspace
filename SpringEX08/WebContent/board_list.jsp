<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Board List</title>
<!-- Material Design fonts -->
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/icon?family=Material+Icons">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Bootstrap Material Design -->
<link rel="stylesheet" type="text/css"
	href="bootstrap-material-design/dist/css/bootstrap-material-design.css">
<link rel="stylesheet" type="text/css" href="dist/css/ripples.min.css">
</head>
<body>

	<!-- 상단 네비바 -->
	<div class="bs-component">
		<div class="navbar navbar-warning">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-warning-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="board.do">게시판</a>
				</div>
				<div class="navbar-collapse collapse navbar-warning-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="writeForm.do">글쓰기</a></li>
						<li><a href="javascript:void(0)">Link</a></li>
						<li class="dropdown"><a href="bootstrap-elements.html"
							data-target="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="javascript:void(0)">Action</a></li>
								<li><a href="javascript:void(0)">Another action</a></li>
								<li><a href="javascript:void(0)">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Dropdown header</li>
								<li><a href="javascript:void(0)">Separated link</a></li>
								<li><a href="javascript:void(0)">One more separated
										link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control col-md-8"
								placeholder="Search">
						</div>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="javascript:void(0)">Link</a></li>
						<li class="dropdown"><a href="bootstrap-elements.html"
							data-target="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="javascript:void(0)">Action</a></li>
								<li><a href="javascript:void(0)">Another action</a></li>
								<li><a href="javascript:void(0)">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0)">Separated link</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- /example -->


	<!-- 게시판 테이블 -->
	<div class="bs-docs-section" style="margin-left: 30px; margin-right: 30px">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1 id="tables">Tables</h1>
				</div>

				<div class="bs-component">
					<table class="table table-striped table-hover ">
						<thead>
							<tr>
								<th>#</th>
								<th>글제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성날짜</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${empty articlePage.list}">
								<td>게시물이 없습니다. 게시물을 작성해주세요.</td>
							</c:when>
							<c:otherwise>
								<tbody>
									<c:forEach var="article" items="${articlePage.list}">
										<tr>
											<td>${article.articleNum}</td>
											<td>${article.title}</td>
											<td>${article.writer}</td>
											<td>${article.readCount}</td>
											<td>${article.writeDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
				<!-- /example -->
			</div>
		</div>
	</div>


	<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="bootstrap-material-design/dist/js/ripples.min.js"></script>
	<script src="bootstrap-material-design/dist/js/material.min.js"></script>
	<script src="//fezvrasta.github.io/snackbarjs/dist/snackbar.min.js"></script>


	<script
		src="//cdnjs.cloudflare.com/ajax/libs/noUiSlider/6.2.0/jquery.nouislider.min.js"></script>

</body>
</html>