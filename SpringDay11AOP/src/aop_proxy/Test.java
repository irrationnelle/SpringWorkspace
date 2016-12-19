package aop_proxy;

public class Test {

	public static void main(String[] args) throws Exception {
		Person boy = new Boy();
		Person girl = new Girl();
		
		PersonProxy proxy = new PersonProxy();
		
		proxy.setBefore(new CBefore()); // proxy�� �ٽɰ��ɻ��� ���� �� before�� �����ϵ��� Ʋ�� ��������
		proxy.setAfter(new CAfter());
		proxy.setAfterReturning(new CAfterReturning());
		proxy.setAfterThrowing(new CAfterThrowing());
		
		proxy.setPerson(boy); //boy�� �ٽɰ��ɻ����� Ʋ�� ���� ����
		proxy.makeFood(100); //boy����
		
		System.out.println();
		
		proxy.setPerson(girl); //girl�� �ٽɰ��ɻ����� Ʋ�� �������
		proxy.makeFood(100); //girl����
	}
}
