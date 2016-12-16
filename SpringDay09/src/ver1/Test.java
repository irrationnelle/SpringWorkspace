package ver1;

// AOP 아닌 상태에서 객체 설계 및 테스트
public class Test {
	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.makeFood();
		
		Girl girl = new Girl();
		girl.makeFood();
	}
}
