package ver3;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void my_around(ProceedingJoinPoint target) {
		
		// before
		System.out.println("�谡 ������"); 
		
		try {
			// �ٽ� ���ɻ��� �޼ҵ� ���� ����.
			target.proceed();
			// �ٽ� ���ɻ��� �޼ҵ尡 ����ǰ� �� ��
			
			// after returning(���� ����) 
			System.out.println("������ �Դ´�");
		} catch (Throwable e) {
			// after throwing(���� �߻�) 
			System.out.println(e.getMessage());
			System.out.println("����!!!!");
		} finally {
			// after
			System.out.println("�������� �Ѵ�");
		}
		
	}
}
