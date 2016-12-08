package ver5;

import org.springframework.stereotype.Component;

@Component
// 이때 Component 어노테이션에 이름 안 붙이면 
// 클래스이름의 첫글자 소문자로 바꾼 이름을 자동으로 설정한다
public class KoreaTire implements Tire {
	@Override
	public String getMode() {
		return "국산";
	}
}
