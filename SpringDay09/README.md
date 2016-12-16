SpringDay09
=============
# AOP(Aspect Oriented Programming)
### 스프링이란 프레임워크를 이야기하는 데 빼놓을 수 없는 최대 강점
### 큰 프로젝트에 반영했을 때 관리하는 게 효과적이다

# 프로그래밍 방법론의 진화
* 절차지향 프로그래밍
    * 순서대로 처리하되 몇몇 중복된 작업들만 함수화시켜서 대체
* 객체지향 프로그래밍
    * 개체들을 나누어 기능에 맞게 레고처럼 조립을 해두고, 필요할 때 조립한 것들의 인스턴스를 생성하여 적용
* 관점지향 프로그래밍
    * 다양한 기능들을 가진 클래스들 사이에서 '공통된 관심사!!'를 처리할 일이 생겼을 때
        * i.e. 회원 정보 클래스, 상품 정보 클래스들의 로그를 기록하는 작업
        * i.e. 각 클래스들의 정보를 암호화하는 작업
    * 이 경우, 여러 클래스에 로그 관련 작업을 만들어야 한다.
        * 설령 로그 관련 작업을 클래스로 만들어도, 결국 해당 클래스의 메소드를 호출하는 문장이라도 넣어야 한다.
    * 여기서 공통된 관심사를 공통 관심사항 또는 횡단 관심사항이라고 한다.
    * 그리고 각 클래스들의 핵심 관심사를 핵심 관심사항 혹은 종단 관심사항이라고 한다.
    ![공통 관심사항과 핵심 관심사항](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/aop_concept.png)

## 관점지향 프로그래밍은 이처럼 클래스들의 관심사항을 추출해서 관심사항에 따라 클래스들을 관리하는 프로그래밍이다.
    

# 필요 dependency:
### Spring context, core, aop
* http://mvnrepository.com/artifact/org.springframework/spring-context/
* http://mvnrepository.com/artifact/org.springframework/spring-core/
* http://mvnrepository.com/artifact/org.springframework/spring-aop

### AspectJ Runtime(rt)
* http://mvnrepository.com/artifact/org.aspectj/aspectjrt
    
### AspectJ Weaver
* http://mvnrepository.com/artifact/org.aspectj/aspectjweaver