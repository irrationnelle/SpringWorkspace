package ver5;

import java.util.Random;

public class Girl implements Person {

	@Override
	public String makeFood(int arg) throws Exception {
		System.out.println("���� �����" + arg);
		if(new Random().nextBoolean()) {
			throw new Exception("��Ⱑ ����!");
		}
		return "���� ������ ��������";
	}
	
}
