package test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.BoardService;
import vo.ArticlePageVO;
import vo.ArticleVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BoardService svc = context.getBean(BoardService.class);
		
		int currentPage=1;

		Scanner scan = new Scanner(System.in);
		
		boolean isEnd = false;
		int result = -2;
		
		ArticleVO article = null;
		
		int num = 0;
		
		String name = null;
		String password = null;
		String title = null;
		String content = null;

		while(!isEnd) {
			System.out.println("�ܼ� �Խ���");
			System.out.println("1.��Ϻ���  2.�۾���  3.���б�  4.�۳������  5.�ۻ���  0.����");
			System.out.print("-> ");
			int select = scan.nextInt();
			switch(select) {
			case 1:
				ArticlePageVO articlePage = svc.makePage(currentPage);
				if(articlePage.getTotalPage() == 0) {
					System.out.println("�ۼ��� ���� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("�������� : " + articlePage.getTotalPage());
				
				System.out.print("������ ����: ");
				currentPage = scan.nextInt();
				if(currentPage > articlePage.getTotalPage() || currentPage < 0)
					try {
						throw new Exception("������ ������ ������ �������ּ���");
					} catch (Exception e) {
						e.printStackTrace();
					}
				articlePage = svc.makePage(currentPage);
				for(ArticleVO articleFor: articlePage.getArticleList()) {
					System.out.print("No.: " + articleFor.getNum());
					System.out.print(" | ");
					System.out.println(articleFor.getTitle());
				}
				break;
			case 2:
				scan.nextLine();
				System.out.print("�̸� �Է�: ");
				name = scan.nextLine();
				System.out.print("��ȣ �Է�: ");
				password = scan.next();
				System.out.print("���� �Է�: ");
				title = scan.nextLine();
				System.out.println("���� �Է�: ");
				content = scan.next();
				
				article = new ArticleVO();
				article.setName(name);
				article.setPassword(password);
				article.setTitle(title);
				article.setContent(content);
				
				result = svc.write(article);
				if(result == 1) {
					System.out.println("�۾��� ����!");
				} else {
					System.out.println("�۾��� ����!");
				}
				break;
			case 3:
				System.out.print("�۹�ȣ ����: ");
				num = scan.nextInt();
				article = svc.read(num);
				System.out.println("������: " + article.getTitle());
				System.out.println("�۾���: " + article.getName());
				System.out.println("�ۼ���¥: " + article.getDate());
				System.out.println("�۳���: " + article.getContent());
				break;
			case 4:
				System.out.print("�۹�ȣ ����: ");
				num = scan.nextInt();
				scan.nextLine();
				System.out.print("�̸� ����: ");
				name = scan.nextLine();
				System.out.print("���� ����: ");
				title = scan.nextLine();
				System.out.print("���� ����: ");
				content = scan.next();
				
				article = new ArticleVO();
				article.setNum(num);
				article.setName(name);
				article.setTitle(title);
				article.setContent(content);
				
				result = svc.edit(article);
				if(result == 1) {
					System.out.println("�ۼ��� ����!");
				} else {
					System.out.println("�ۼ��� ����!");
				}
				break;
			case 5:
				System.out.print("�۹�ȣ ����: ");
				num = scan.nextInt();
				result = svc.delete(num);
				if(result == 1) {
					System.out.println("�ۻ��� ����!");
				} else {
					System.out.println("�ۻ��� ����!");
				}
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�");
				isEnd = true;
				return;
			default:
				break;
			}
		}
	}
}
