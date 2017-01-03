<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
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
<title>글쓰기</title>
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

	<!-- 입력 폼 시작 -->
	<div class="bs-docs-section"
		style="margin-left: 30px; margin-right: 30px">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1 id="forms">글쓰기</h1>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="well bs-component">
					<form class="form-horizontal" action="write.do" method="post" enctype="multipart/form-data">
						<fieldset>
							<legend>Legend</legend>
							<div class="form-group">
								<label for="inputTitle" class="col-md-2 control-label">Title</label>

								<div class="col-md-10">
									<input type="text" class="form-control" name="title"
										id="inputTitle" placeholder="Title">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-md-2 control-label">Name</label>

								<div class="col-md-10">
									<input type="text" class="form-control" name="writer"
										id="inputName" placeholder="Name">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-2 control-label">Password</label>

								<div class="col-md-10">
									<input type="password" class="form-control" name="password"
										id="inputPassword" placeholder="Password">
								</div>
							</div>

							<div class="form-group">
								<label for="textArea" class="col-md-2 control-label">Textarea</label>

								<div class="col-md-10">
									<textarea class="form-control" rows="3" name="content"
										id="textArea"></textarea>
									<span class="help-block">A longer block of help text
										that breaks onto a new line and may extend beyond one line.</span>
								</div>
							</div>

							<div class="form-group">
								<label for="inputFile" class="col-md-2 control-label">File</label>

								<div class="input-group" style="margin-left: 15px; margin-right: 15px">
									<input type="text" readonly class="form-control"
										placeholder="Browse..."> <input type="file"
										id="inputFile" name="file" multiple> <span
										class="input-group-btn input-group-sm">
										<button type="button" class="btn btn-fab btn-fab-mini">
											<i class="material-icons">attach_file</i>
										</button>
									</span>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-2">
									<button type="button" class="btn btn-default">Cancel</button>
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 입력 폼 종료 -->


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