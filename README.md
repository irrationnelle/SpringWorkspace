Spring
=============

# �ڹ� �����ͺ��̽� ���� �䱸����
##(���ݱ����� �ڹ� �����ͺ��̽��� �����ؼ� ������ ����)
1. Ŀ�ؼ� ���� (DB�� �����ϴ� ��)
2. close�� ���� try-catch-finally ������ ���ŷο�
3. insert, update �� ���ڰ� ���� ���޵Ǵ� ���� ����� �ڷ����� ������ �����ڰ� �� ó���ؾ� �ϴ� ��
4. select ���� �� ��� ResultSet�� ���� �ڵ鸵 �ؾ��ϴ°�?

# �ʿ� dependency:
# ���� ��Ŭ�������� �⺻Ŭ������ ã�ų� �ε��� �� �����ϴ� ������ �߻��Ѵٸ� Spring context, core, jdbc ������ ������ ��! 
## pom.xml�� �߰��� dependency�� �ǹ�
### ����: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/pom.xml
### ���� ��ũ�� ��Ŭ���� ������ Spring 4.0.2 ���� ��� ��!
### Spring context, core, jdbc: 4.1.6 ����
* http://mvnrepository.com/artifact/org.springframework/spring-context/4.1.6.RELEASE
* http://mvnrepository.com/artifact/org.springframework/spring-core/4.1.6.RELEASE
* http://mvnrepository.com/artifact/org.springframework/spring-jdbc/4.1.6.RELEASE

### commons-dbcp: 1.4 ����
* http://mvnrepository.com/artifact/commons-dbcp/commons-dbcp/1.4
    
### mysql-connector: 5.16 ����
* http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6

# ���̺� ����
* create table book(
* book_num int primary key auto_increment,
* title varchar(100) not null,
* writer varchar(50) not null,
* price int not null,
* publisher varchar(50)
* );


# ���� ��ü:
### DataSource-JdbcTemplate-BookDao
1. DataSource: ����̹� �ε� �� Ŀ�ؼ� ����
   * ���� 13-19�� ����: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/src/test01_spring/applicationContext.xml
2. JdbcTemplate: DataSource ��ü�� ������. ���� ���� ��� ���
   * ���� <27-39></27-39>�� ����: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/src/test01_spring/applicationContext.xml
3. BookDao: JdbcTemplate
   * ���� ��Ű�� ����: test01_spring.vo
   * test01_spring.vo�� ������Ű���� ���� ���� ���� ������ �Ʒ�ó�� �ϸ� ����
   * ![test01_spring.vo ���� ��Ű���� ���� ���� ���� ���ؼ�](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/SpringDay04/01.png)
   * ���� vo ��Ű���� vo Ŭ���� �ۼ�
   * ����: https://github.com/irrationnelle/SpringWorkspace/blob/master/SpringDay04DB/src/test01_spring/BookDao.java

* DataSource�� JdbcTemplate�� �츮�� ���� Ŭ������ �ƴϱ� ������ @annotation�� ������ ���ϰ� bean �±׸� �ۼ�
* DataSource ��ü�� DB�� �����ϴ� �뵵(i.e. ����̹� �ε�, Ŀ�ؼ� ���� ��)
* BookDao�� �츮�� �ۼ��� Ŭ�����̱� ������ @annotation �ٿ��൵ �ǰ� bean �±׷� �ۼ��� ����