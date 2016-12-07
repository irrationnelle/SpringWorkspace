package ver3_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		// 차량용품점 오픈
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/ver3_1/applicationContext.xml");
		
		Car myCar = context.getBean("citroen", Car.class);
		Tire tire = context.getBean("koreaTire", Tire.class);
		
		myCar.setTire(tire);	// 가져온 객체 조립
		myCar.printCarInfo();
	}
}
