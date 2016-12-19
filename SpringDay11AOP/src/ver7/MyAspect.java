package ver7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* makeFood(*))")
	public void my_point() {
		
	}
	
	@Around("my_point()")
	public void my_around(ProceedingJoinPoint target) {
		//before
		System.out.println("�谡 ������");
		
		// �ٽ� ���ɻ��� ���� ���� �Է� ������ �޾ƺ���
		Object[] args = target.getArgs();
		System.out.println(args[0] + "�κ� ������ ����ڴ�.");
		
		try {
			// �ٽ� ���ɻ��� �����Ű��
			Object result = target.proceed();
			
			// after returning �������� �� �۾�
			// �ٽ� ���ɻ��� ���� ��� ������ �޾ƺ���
			System.out.println(result);
		} catch (Throwable e) {
			// after throwing: �ٽ� ���ɻ��� ���� �� ���� �߻�
			System.out.println(e.getMessage() + "...����!!");
		} finally {
			// after : ����Ǿ��� ������ �� ������ ����
			System.out.println("�������� �Ѵ�.");
		}
	}
}
