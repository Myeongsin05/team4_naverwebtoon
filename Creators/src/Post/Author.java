// 작가 정보가 들어있는 클래스
package Post;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
	private String name; // 작가 이름
	private AuthorHome authorHome; // 작가홈 클래스
	private ArrayList<Work> workList; // 작품 클래스 리스트
	Scanner sc = new Scanner(System.in);

	public Author() {

	}

	public Author(String name) {
		this.name = name;
	}

	public AuthorHome getAuthorHome() {
		return authorHome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void createAuthorHome(AuthorHome authorHome) {

		this.authorHome = new AuthorHome(name); // 작가홈 개설
		System.out.println(name+"작가님 작가홈 개설에 성공했습니다!");

	}
}
