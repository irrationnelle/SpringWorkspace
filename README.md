Spring
=============

# 자바 데이터베이스 개선 요구사항
1. 커넥션 관리 (DB에 연결하는 거)
2. close를 위한 try-catch-finally 구문
3. insert, update 등 인자가 많이 전달되는 쿼리 실행시 자료형과 순서를 개발자가 다 처리해야 하는 점
4. select 실행 후 결과 ResultSet을 직접 핸들링 해야하는가?

# 필요 dependency:
    ### Spring context, core, jdbc: 4.1.6 버전
    * http://mvnrepository.com/artifact/org.springframework/spring-context/4.1.6.RELEASE
    * http://mvnrepository.com/artifact/org.springframework/spring-core/4.1.6.RELEASE
    * http://mvnrepository.com/artifact/org.springframework/spring-jdbc/4.1.6.RELEASE
    ### commons-dbcp: 1.4 버전
    * http://mvnrepository.com/artifact/commons-dbcp/commons-dbcp/1.4
     
    ### mysql-connector: 5.16 버전
    * http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6

# 등장 객체:
    ### DataSource-JdbcTemplate-BookDao
    * 우리가 만든 클래스가 아니기 때문에 @annotation을 붙이지 못하고 bean 태그를 작성
    * DataSource 객체는 DB에 접속하는 용도(i.e. 드라이버 로딩, 커넥션 연결 등)
    * BookDao는 우리가 작성한 클래스이기 때문에 @annotation 붙여줘도 되고 bean 태그로 작성도 가능