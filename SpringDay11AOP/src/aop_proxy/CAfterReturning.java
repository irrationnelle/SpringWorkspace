package aop_proxy;

public class CAfterReturning implements AfterReturning{

	@Override
	public void doAfterReturn() {
		System.out.println("������ �Դ´�.");
	}

}
