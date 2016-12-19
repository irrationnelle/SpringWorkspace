package ver6;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Boy, Girl Ŭ�����鿡 �������� �����ϰ��� �ϴ� 
// ���� ���ɻ��� ���� Ŭ����

@Component
@Aspect
public class MyAspect {
	
	// ������ �Ǵ� ���� �޼ҵ�
	@Pointcut("execution(void makeFood())")
	public void my_point() {
		
	}
	
	// �ٽɰ��ɻ��� ������ �۾�
	@Before("my_point()")
	public void my_before() {
		System.out.println("�谡 ������.");
	}

	// �ٽɰ��ɻ��� ���� ������ �۾�
	@AfterReturning("my_point()")
	public void my_after_returning() {
		System.out.println("������ �Դ´�.");
	}

	@AfterThrowing("my_point()")
	// �ٽɰ������ ���� ������ �۾�
	public void my_after_throwing() {
		System.out.println("������ �θ���.");
	}

	// ���������̰� ���������̰� ��¶�� ������ �۾�
	@After("my_point()")
	public void my_after() {
		System.out.println("�������� �Ѵ�.");
	}
}
