package ver5;

import org.springframework.stereotype.Component;

@Component
// �̶� Component ������̼ǿ� �̸� �� ���̸� 
// Ŭ�����̸��� ù���� �ҹ��ڷ� �ٲ� �̸��� �ڵ����� �����Ѵ�
public class KoreaTire implements Tire {
	@Override
	public String getMode() {
		return "����";
	}
}
