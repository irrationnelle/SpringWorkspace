package ver5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		// 스프링 창고. 버전이 몇인지 찾을 것
		ApplicationContext context = new ClassPathXmlApplicationContext("ver5/applicationContext.xml");
		
		Car myCar = context.getBean("citroen", Car.class);
		Tire tire = context.getBean("koreaTire", Tire.class);
		
		myCar.setTire(tire);
		
		myCar.printCarInfo(); 
	}
}
