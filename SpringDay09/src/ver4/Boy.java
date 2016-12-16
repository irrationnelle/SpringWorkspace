package ver4;

import java.util.Random;

public class Boy implements Person {

	@Override
	public String makeFood(int arg) throws Exception {
		// 핵심 관심사항
		System.out.println("냉면을 만든다" + arg);
		if(new Random().nextBoolean()) {
			throw new Exception("불이 났다!");
		}
		// 핵심 관심사항 종료
		return "냉면이 적당히 만들어졌다";
	}
	
}
