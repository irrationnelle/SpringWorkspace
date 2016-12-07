package ver6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		// @Autowired ������̼����� ���� ������ �߻�. 10���ٺ��� ���� �߻�
		ApplicationContext context = new ClassPathXmlApplicationContext("ver6/applicationContext.xml");
		
		Car myCar = context.getBean("citroen", Car.class);
		
		myCar.printCarInfo(); 
	}
}
