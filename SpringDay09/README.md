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

## 예시 시나리오
* Boy: 배가 고프다 -> 냉면을 만든다 -> 음식을 먹는다 -> 설거지를 한다 (정상상황)
* Boy: 배가 고프다 -> 냉면을 만든다 -> 불이 났다! (예외 발생) -> 엄마를 부른다 (예외 처리) -> 설거지를 한다 (예외상황)

* Girl: 배가 고프다 -> 갈비를 만든다 -> 음식을 먹는다 -> 설거지를 한다 (정상상황)
* Girl: 배가 고프다 -> 갈비를 만든다 -> 고기가 없다!(예외 발생) -> 엄마를 부른다 (예외 처리) -> 설거지를 한다 (예외상황)

## 예시 시나리오에서 각 관심사항들
* Boy 핵심 관심사항 : 냉면을 만든다
* Girl 핵심 관심사항 : 갈비를 만든다
* Person인 Boy와 Girl의 공통 관심사항 : 배가 고프다. (정상상황시) 음식을 먹는다. (예외 발생시) 엄마를 부른다. (상황 종료 후) 설거지를 한다.

# applicationContext에 입력해야 하는 사항
### 입력 전에 먼저 applicationContext에서 namespace로 간 뒤 aop에 체크!
![체크할 것](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/aop_check.png)

    <bean id="jaemin" class="ver2.Boy"/>
	<bean id="yunmi" class="ver2.Girl"/>
	
	<bean id="myAspect" class="ver2.MyAspect"/>
	
	<aop:config>
		<!-- 공통 관심사항 (각 클래스에 공통적으로 적용할 내용) -->
		<aop:aspect ref="myAspect">
			<!-- 클래스 두 개를 지명. id는 매번 이름을 execution.. 식으로 길게 지을 수 없어서 간편하게 부르기 위해 지정 -->
			<aop:pointcut expression="execution(void makeFood())" id="myTarget"/>
			
			<!-- makefood(각 클래스의 핵심사항)라는 myTarget을 실행시키기 전에 해당 메소드를 먼저(before) 실행시켜라 -->
			<aop:before method="my_before" pointcut-ref="myTarget" /> 
			
			<!-- makefood가 정상 작동 했을 때 실행시켜라 -->
			<aop:after-returning method="my_after_returning" pointcut-ref="myTarget"/>
			
			<!-- makefood가 예외 발생 했을 때 실행시켜라 -->
			<aop:after-throwing method="my_after_throwing" pointcut-ref="myTarget"/>
			
			<!-- 정상 종료이든 예외 발생 후 종료이든 makefood가 종료된 시점에 실행시켜라 -->
			<aop:after method="my_after" pointcut-ref="myTarget"/>
		</aop:aspect>
	</aop:config>

### 여기서 공통 관심사항으로 처리되는 메소드들은 콜백 메소드(callback method)이다.
### 누군가가 명시적으로 호출하지 않기 때문. 이 '콜백 메소드를 호출하는 배후의 존재'를 프록시(Proxy)라 한다.