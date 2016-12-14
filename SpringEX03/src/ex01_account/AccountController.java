package ex01_account;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ex01_account.vo.AccountVO;

@Component
public class AccountController {
	public AccountController() { }
	
	@Autowired
	private AccountService svc;
	
	public void setSvc(AccountService svc) {
		this.svc = svc;
	}
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[������� ���α׷�]");
		System.out.println("1. ���� ����   2: �Ա�   3: ���   4: ������ȸ   5: �۱�   -1: ����");
		System.out.print("���ϴ� ��ȣ�� �Է����ּ���: ");
		int num = scan.nextInt();
		select(num);
	}
	
	public void select(int num) {
		Scanner scan = new Scanner(System.in);
		AccountVO account = new AccountVO();

		int accountNum = -1;
		String name = null;
		int amount = -1;
		String password = null;
		int result = -1;
		
		String verify = null;
		
		switch(num) {
		case 1:
			System.out.print("�̸� �Է�: ");
			name = scan.nextLine();
			account.setName(name);
			
			System.out.print("�ݾ� �Է�: ");
			amount = scan.nextInt();
			account.setAmount(amount);
			
			System.out.print("��ȣ �Է�: ");
			password = scan.next();
			account.setPassword(password);
			
			
			result = svc.makeAccount(account);
			
			if(result == 1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("���� ������ �����߽��ϴ�.");
			}
			break;
		case 2:
			System.out.print("���¹�ȣ �Է�: ");
			accountNum = scan.nextInt();
			account.setAccountNum(accountNum);
			
			System.out.print("��ȣ �Է�: ");
			password = scan.next();
			account.setPassword(password);
			
			System.out.print("�ݾ� �Է�: ");
			amount = scan.nextInt();
			account.setAmount(amount);
			
			result = svc.deposit(account);
			verify = svc.showAccount(accountNum).getPassword();
			
			if(result == 1 && password.equals(verify)) {
				System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("�Ա��� �����߽��ϴ�.");
			}
			break;
		case 3:
			System.out.print("���¹�ȣ �Է�: ");
			accountNum = scan.nextInt();
			account.setAccountNum(accountNum);
			
			System.out.print("��ȣ �Է�: ");
			password = scan.next();
			account.setPassword(password);
			
			System.out.print("�ݾ� �Է�: ");
			amount = scan.nextInt();
			account.setAmount(amount);
			
			result = svc.withdraw(account);
			verify = svc.showAccount(accountNum).getPassword();
			
			if(result == 1 && password.equals(verify)) {
				System.out.println("����� �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("����� �����߽��ϴ�.");
			}
			break;
		case 4:
			System.out.print("���¹�ȣ �Է�: ");
			accountNum = scan.nextInt();
			
			System.out.print("��ȣ �Է�: ");
			password = scan.next();
			
			account = svc.showAccount(accountNum);
			
			if(password.equals(account.getPassword())) {
				System.out.println("���¹�ȣ: "+account.getAccountNum());
				System.out.println("�̸�: "+account.getName());
				System.out.println("�ܱ�: "+account.getAmount());
			} else {
				System.out.println("������ȸ�� �����߽��ϴ�.");
			}
			break;
		case -1:
			System.out.println("���α׷��� �����մϴ�");
			return;
		default:
			System.out.println("��ȣ�� �ٽ� �Է����ּ���");
			break;
		}
	}
	
	
}