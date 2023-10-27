// 작가 정보가 들어있는 클래스
package Post;

import java.util.Scanner;

import Post.AuthorHome;

public class Author {
	private String name; //작가 이름
	private AuthorHome authorHome; // 작가홈 클래스
	Scanner sc = new Scanner(System.in);
	public Author() {
		
	}
	public Author(String name) {
		this.name = name;
	}
	
	public AuthorHome getAuthorHome() {
		return authorHome;
	}
	public void setAuthorHome(AuthorHome authorHome) {
		this.authorHome = authorHome;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void createAutourHome() {
		System.out.println("**작가홈 개설 화면입니다.**");
		System.out.print("작가홈을 개설하시길 원하시면 '네'를 입력해주세요");
		String answer = sc.nextLine();
		if(answer.equals("네")) {
			authorHome = new AuthorHome(); //작가홈 개설
		}
		
	}
}
