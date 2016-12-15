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
			System.out.println("콘솔 게시판");
			System.out.println("1.목록보기  2.글쓰기  3.글읽기  4.글내용수정  5.글삭제  0.종료");
			System.out.print("-> ");
			int select = scan.nextInt();
			switch(select) {
			case 1:
				ArticlePageVO articlePage = svc.makePage(currentPage);
				if(articlePage.getTotalPage() == 0) {
					System.out.println("작성된 글이 존재하지 않습니다.");
					break;
				}
				System.out.println("총페이지 : " + articlePage.getTotalPage());
				
				System.out.print("페이지 선택: ");
				currentPage = scan.nextInt();
				if(currentPage > articlePage.getTotalPage() || currentPage < 0)
					try {
						throw new Exception("지정된 페이지 내에서 선택해주세요");
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
				System.out.print("이름 입력: ");
				name = scan.nextLine();
				System.out.print("암호 입력: ");
				password = scan.next();
				System.out.print("제목 입력: ");
				title = scan.nextLine();
				System.out.println("내용 입력: ");
				content = scan.next();
				
				article = new ArticleVO();
				article.setName(name);
				article.setPassword(password);
				article.setTitle(title);
				article.setContent(content);
				
				result = svc.write(article);
				if(result == 1) {
					System.out.println("글쓰기 성공!");
				} else {
					System.out.println("글쓰기 실패!");
				}
				break;
			case 3:
				System.out.print("글번호 선택: ");
				num = scan.nextInt();
				article = svc.read(num);
				System.out.println("글제목: " + article.getTitle());
				System.out.println("글쓴이: " + article.getName());
				System.out.println("작성날짜: " + article.getDate());
				System.out.println("글내용: " + article.getContent());
				break;
			case 4:
				System.out.print("글번호 선택: ");
				num = scan.nextInt();
				scan.nextLine();
				System.out.print("이름 수정: ");
				name = scan.nextLine();
				System.out.print("제목 수정: ");
				title = scan.nextLine();
				System.out.print("내용 수정: ");
				content = scan.next();
				
				article = new ArticleVO();
				article.setNum(num);
				article.setName(name);
				article.setTitle(title);
				article.setContent(content);
				
				result = svc.edit(article);
				if(result == 1) {
					System.out.println("글수정 성공!");
				} else {
					System.out.println("글수정 실패!");
				}
				break;
			case 5:
				System.out.print("글번호 선택: ");
				num = scan.nextInt();
				result = svc.delete(num);
				if(result == 1) {
					System.out.println("글삭제 성공!");
				} else {
					System.out.println("글삭제 실패!");
				}
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				isEnd = true;
				return;
			default:
				break;
			}
		}
	}
}
