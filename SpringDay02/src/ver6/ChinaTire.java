package ver6;

import org.springframework.stereotype.Component;

@Component
public class ChinaTire implements Tire {

	@Override
	public String getMode() {
		return "´ë·ú";
	}

}
