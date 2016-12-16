SpringDay09
=============
# AOP(Aspect Oriented Programming)
### �������̶� �����ӿ�ũ�� �̾߱��ϴ� �� ������ �� ���� �ִ� ����
### ū ������Ʈ�� �ݿ����� �� �����ϴ� �� ȿ�����̴�

# ���α׷��� ������� ��ȭ
* �������� ���α׷���
    * ������� ó���ϵ� ��� �ߺ��� �۾��鸸 �Լ�ȭ���Ѽ� ��ü
* ��ü���� ���α׷���
    * ��ü���� ������ ��ɿ� �°� ����ó�� ������ �صΰ�, �ʿ��� �� ������ �͵��� �ν��Ͻ��� �����Ͽ� ����
* �������� ���α׷���
    * �پ��� ��ɵ��� ���� Ŭ������ ���̿��� '����� ���ɻ�!!'�� ó���� ���� ������ ��
        * i.e. ȸ�� ���� Ŭ����, ��ǰ ���� Ŭ�������� �α׸� ����ϴ� �۾�
        * i.e. �� Ŭ�������� ������ ��ȣȭ�ϴ� �۾�
    * �� ���, ���� Ŭ������ �α� ���� �۾��� ������ �Ѵ�.
        * ���� �α� ���� �۾��� Ŭ������ ����, �ᱹ �ش� Ŭ������ �޼ҵ带 ȣ���ϴ� �����̶� �־�� �Ѵ�.
    * ���⼭ ����� ���ɻ縦 ���� ���ɻ��� �Ǵ� Ⱦ�� ���ɻ����̶�� �Ѵ�.
    * �׸��� �� Ŭ�������� �ٽ� ���ɻ縦 �ٽ� ���ɻ��� Ȥ�� ���� ���ɻ����̶�� �Ѵ�.
    ![���� ���ɻ��װ� �ٽ� ���ɻ���](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/aop_concept.png)

## �������� ���α׷����� ��ó�� Ŭ�������� ���ɻ����� �����ؼ� ���ɻ��׿� ���� Ŭ�������� �����ϴ� ���α׷����̴�.
    

# �ʿ� dependency:
### Spring context, core, aop
* http://mvnrepository.com/artifact/org.springframework/spring-context/
* http://mvnrepository.com/artifact/org.springframework/spring-core/
* http://mvnrepository.com/artifact/org.springframework/spring-aop

### AspectJ Runtime(rt)
* http://mvnrepository.com/artifact/org.aspectj/aspectjrt
    
### AspectJ Weaver
* http://mvnrepository.com/artifact/org.aspectj/aspectjweaver

## ���� �ó�����
* Boy: �谡 ������ -> �ø��� ����� -> ������ �Դ´� -> �������� �Ѵ� (�����Ȳ)
* Boy: �谡 ������ -> �ø��� ����� -> ���� ����! (���� �߻�) -> ������ �θ��� (���� ó��) -> �������� �Ѵ� (���ܻ�Ȳ)

* Girl: �谡 ������ -> ���� ����� -> ������ �Դ´� -> �������� �Ѵ� (�����Ȳ)
* Girl: �谡 ������ -> ���� ����� -> ��Ⱑ ����!(���� �߻�) -> ������ �θ��� (���� ó��) -> �������� �Ѵ� (���ܻ�Ȳ)

## ���� �ó��������� �� ���ɻ��׵�
* Boy �ٽ� ���ɻ��� : �ø��� �����
* Girl �ٽ� ���ɻ��� : ���� �����
* Person�� Boy�� Girl�� ���� ���ɻ��� : �谡 ������. (�����Ȳ��) ������ �Դ´�. (���� �߻���) ������ �θ���. (��Ȳ ���� ��) �������� �Ѵ�.

# applicationContext�� �Է��ؾ� �ϴ� ����
### �Է� ���� ���� applicationContext���� namespace�� �� �� aop�� üũ!
![üũ�� ��](https://github.com/irrationnelle/SpringWorkspace/blob/master/imgs/aop_check.png)

    <bean id="jaemin" class="ver2.Boy"/>
	<bean id="yunmi" class="ver2.Girl"/>
	
	<bean id="myAspect" class="ver2.MyAspect"/>
	
	<aop:config>
		<!-- ���� ���ɻ��� (�� Ŭ������ ���������� ������ ����) -->
		<aop:aspect ref="myAspect">
			<!-- Ŭ���� �� ���� ����. id�� �Ź� �̸��� execution.. ������ ��� ���� �� ��� �����ϰ� �θ��� ���� ���� -->
			<aop:pointcut expression="execution(void makeFood())" id="myTarget"/>
			
			<!-- makefood(�� Ŭ������ �ٽɻ���)��� myTarget�� �����Ű�� ���� �ش� �޼ҵ带 ����(before) ������Ѷ� -->
			<aop:before method="my_before" pointcut-ref="myTarget" /> 
			
			<!-- makefood�� ���� �۵� ���� �� ������Ѷ� -->
			<aop:after-returning method="my_after_returning" pointcut-ref="myTarget"/>
			
			<!-- makefood�� ���� �߻� ���� �� ������Ѷ� -->
			<aop:after-throwing method="my_after_throwing" pointcut-ref="myTarget"/>
			
			<!-- ���� �����̵� ���� �߻� �� �����̵� makefood�� ����� ������ ������Ѷ� -->
			<aop:after method="my_after" pointcut-ref="myTarget"/>
		</aop:aspect>
	</aop:config>

### ���⼭ ���� ���ɻ������� ó���Ǵ� �޼ҵ���� �ݹ� �޼ҵ�(callback method)�̴�.
### �������� ��������� ȣ������ �ʱ� ����. �� '�ݹ� �޼ҵ带 ȣ���ϴ� ������ ����'�� ���Ͻ�(Proxy)�� �Ѵ�.