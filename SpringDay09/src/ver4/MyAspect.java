package ver4;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void my_before(JoinPoint joinpoint) {
		System.out.println("�谡 ������");
		Object[] args = joinpoint.getArgs();
		System.out.println("before �غ�: " + args[0]);
	}
	
	public void my_after_returning(Object result) {
		System.out.println(result + " ���ְ� �Դ´�.");
	}
	
	public void my_after_throwing(Exception ex) {
		System.out.println(ex.getMessage() + "...����!!!");
	}
	
	public void my_after() {
		System.out.println("�������� �Ѵ�");
	}
}
