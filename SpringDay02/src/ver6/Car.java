package ver6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("citroen")
public class Car {
	@Autowired	// @Autowired 어노테이션의 위치: 변수 바로 위, 생성자 바로 위, setters 바로 위
	@Qualifier("koreaTire")
	private Tire tire;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자로 조립
	public Car(Tire tire) {
		this.tire = tire;
	}

	// set으로 조립
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printCarInfo() {
		System.out.println("현재 장착 타이어:"+tire.getMode());
	}
}
