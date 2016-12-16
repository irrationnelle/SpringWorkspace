package ver4;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void my_before(JoinPoint joinpoint) {
		System.out.println("배가 고프다");
		Object[] args = joinpoint.getArgs();
		System.out.println("before 준비물: " + args[0]);
	}
	
	public void my_after_returning(Object result) {
		System.out.println(result + " 맛있게 먹는다.");
	}
	
	public void my_after_throwing(Exception ex) {
		System.out.println(ex.getMessage() + "...엄마!!!");
	}
	
	public void my_after() {
		System.out.println("설거지를 한다");
	}
}
