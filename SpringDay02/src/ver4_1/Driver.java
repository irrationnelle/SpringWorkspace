package ver4_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ver4_1/applicationContext.xml");
		
		Car myCar = context.getBean("citroen", Car.class);
		
		myCar.printCarInfo(); 
	}
}
