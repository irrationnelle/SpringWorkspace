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
		System.out.println("배가 고프다");
		
		// 핵심 관심사항 수행 전에 입력 데이터 받아보기
		Object[] args = target.getArgs();
		System.out.println(args[0] + "인분 음식을 만들겠다.");
		
		try {
			// 핵심 관심사항 실행시키기
			Object result = target.proceed();
			
			// after returning 정상종료 후 작업
			// 핵심 관심사항 수행 결과 데이터 받아보기
			System.out.println(result);
		} catch (Throwable e) {
			// after throwing: 핵심 관심사항 수행 중 예외 발생
			System.out.println(e.getMessage() + "...엄마!!");
		} finally {
			// after : 어찌되었건 종료할 때 무조건 실행
			System.out.println("설거지를 한다.");
		}
	}
}
