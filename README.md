Spring
=============

# 자바 데이터베이스 개선 요구사항
##(지금까지의 자바 데이터베이스가 불편해서 개선할 사항)
1. 커넥션 관리 (DB에 연결하는 거)
2. close를 위한 try-catch-finally 구문의 번거로움
3. insert, update 등 인자가 많이 전달되는 쿼리 실행시 자료형과 순서를 개발자가 다 처리해야 하는 점
4. select 실행 후 결과 ResultSet을 직접 핸들링 해야하는가?

# 필요 dependency:
# 만약 이클립스에서 기본클래스를 찾거나 로드할 수 없습니다 오류가 발생한다면 Spring context, core, jdbc 버전을 변경할 것! 
## pom.xml에 추가할 dependency를 의미
### 참조: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/pom.xml
### 참조 링크는 이클립스 에러로 Spring 4.0.2 버전 사용 중!
### Spring context, core, jdbc: 4.1.6 버전
* http://mvnrepository.com/artifact/org.springframework/spring-context/4.1.6.RELEASE
* http://mvnrepository.com/artifact/org.springframework/spring-core/4.1.6.RELEASE
* http://mvnrepository.com/artifact/org.springframework/spring-jdbc/4.1.6.RELEASE

### commons-dbcp: 1.4 버전
* http://mvnrepository.com/artifact/commons-dbcp/commons-dbcp/1.4
    
### mysql-connector: 5.16 버전
* http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6

# 테이블 생성
* create table book(
* book_num int primary key auto_increment,
* title varchar(100) not null,
* writer varchar(50) not null,
* price int not null,
* publisher varchar(50)
* );


# 등장 객체:
### DataSource-JdbcTemplate-BookDao
1. DataSource: 드라이버 로딩 및 커넥션 관리
   * 참조 13-19번 라인: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/src/test01_spring/applicationContext.xml
2. JdbcTemplate: DataSource 객체를 의존함. 인자 전달 등등 기능
   * 참조 <27-39></27-39>번 라인: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/src/test01_spring/applicationContext.xml
3. BookDao: JdbcTemplate
   * 하위 패키지 생성: test01_spring.vo
   * test01_spring.vo가 하위패키지로 들어가는 것을 보고 싶으면 아래처럼 하면 가능
   * ![test01_spring.vo 하위 패키지로 들어가는 것을 보기 위해서](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/SpringDay04/01.png)
   * 하위 vo 패키지에 vo 클래스 작성
   * 참조: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/src/test01_spring/BookDao.java

* DataSource와 JdbcTemplate는 우리가 만든 클래스가 아니기 때문에 @annotation을 붙이지 못하고 bean 태그를 작성
* DataSource 객체는 DB에 접속하는 용도(i.e. 드라이버 로딩, 커넥션 연결 등)
* BookDao는 우리가 작성한 클래스이기 때문에 @annotation 붙여줘도 되고 bean 태그로 작성도 가능