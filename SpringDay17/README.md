SpringDay17
=============
# [프로젝트 다운로드](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/SpringDay17.zip)
# 파일 업로드
* 파일 업로드/다운로드는 ViewResolver를 통해서 view를 리턴하지 않는데,
* view는 화면이기 때문에 파일 업로드/다운로드에서는 화면이 보여질 필요가 없기 때문이다.
* 따라서 파일 업로드/다운로드에서는 ModelAndView 객체가 필요없다.

### MultiPartResolver: 파일 업로드에 관여하는 객체
### 파일 다운로드의 경우:
* 파일 다운로드를 할 경우 서버 컴퓨터의 저장소로부터 InputStream으로 읽어 들여 DispatchServlet에 보내고,
* DispatcherServlet은 OutputStream으로 클라이언트에게 파일을 보내준다.
* 이 때 다운로드 요청시 응답하는 것은 html이 아닌 파일(예: octocat.jpg)을 주어야 한다.

# 필요 dependencies:
### Spring context, core, web, webmvc
* http://mvnrepository.com/artifact/org.springframework/spring-context/
* http://mvnrepository.com/artifact/org.springframework/spring-core/
* http://mvnrepository.com/artifact/org.springframework/spring-web
* http://mvnrepository.com/artifact/org.springframework/spring-webmvc

### commons-fileupload
* http://mvnrepository.com/artifact/commons-fileupload/commons-fileupload
    
### commons-io
* http://mvnrepository.com/artifact/commons-io/commons-io

### jstl
* http://mvnrepository.com/artifact/javax.servlet/jstl

# 파일 단일 업로드:
* [WebContent/WEB-INF/web.xml](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/WEB-INF/web.xml)
    * web.xml 편집창에서 Ctrl + Space를 눌러 자동완성이 뜨게 하면,
    * 최하단에 파란색 #으로 시작하는 부분에서 dispatcherservlet을 선택해준다.
    * ![web.xml에서 자동완성](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/autocomplete_dispatcherservlet.png)
* [WebContent/WEB-INF/web-beans.xml](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/WEB-INF/web-beans.xml)
* [WebContent/index.jsp](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/index.jsp)
* [WebContent/upload_form.jsp](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/upload_form.jsp)
* [WebContent/upload_result.jsp](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/upload_result.jsp)
* [src/controller/FileController.java](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/src/controller/FileController.java)
    * osX에서는 파일 경로 입력하는 방식이 다름. [참조사이트](http://stackoverflow.com/questions/5972026/path-to-file-on-a-mac-filenotfoundexception)
* [src/vo/Book.java](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/src/vo/Book.java)

# 파일 여러 개 업로드(브라우저에서 테스트 시, /uploadFormMovie.do 로 접속할 것)
* [src/controller/FileController.java](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/src/controller/FileController.java)
    * osX에서는 파일 경로 입력하는 방식이 다름. [참조사이트](http://stackoverflow.com/questions/5972026/path-to-file-on-a-mac-filenotfoundexception)
* [src/vo/Movie.java](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/src/vo/Movie.java)
* [WebContent/upload_form_movie.jsp](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/upload_form_movie.jsp)
* [WebContent/upload_movie_result.jsp](https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay17/WebContent/upload_movie_result.jsp)
