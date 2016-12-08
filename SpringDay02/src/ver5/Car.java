package ver5;

import org.springframework.stereotype.Component;

@Component("citroen")
public class Car {
	private Tire tire;
	
	
	public Car() {
//		this.tire = tire;
	}
	
	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	public void printCarInfo() {
		System.out.println("현재 장착 타이어:"+tire.getMode());
	}
}
