package ver1;

// AOP �ƴ� ���¿��� ��ü ���� �� �׽�Ʈ
public class Test {
	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.makeFood();
		
		Girl girl = new Girl();
		girl.makeFood();
	}
}