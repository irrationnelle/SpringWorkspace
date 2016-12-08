package ver6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		// @Autowired 어노테이션으로 인해 에러가 발생. 10번줄부터 예외 발생
		ApplicationContext context = new ClassPathXmlApplicationContext("ver6/applicationContext.xml");
		
		Car myCar = context.getBean("citroen", Car.class);
		
		myCar.printCarInfo(); 
	}
}
