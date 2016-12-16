package ver3;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void my_around(ProceedingJoinPoint target) {
		
		// before
		System.out.println("배가 고프다"); 
		
		try {
			// 핵심 관심사항 메소드 실행 시점.
			target.proceed();
			// 핵심 관심사항 메소드가 실행되고 난 뒤
			
			// after returning(정상 실행) 
			System.out.println("음식을 먹는다");
		} catch (Throwable e) {
			// after throwing(예외 발생) 
			System.out.println(e.getMessage());
			System.out.println("엄마!!!!");
		} finally {
			// after
			System.out.println("설거지를 한다");
		}
		
	}
}
