// 작가 정보가 들어있는 클래스
package Post;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
	private String name; // 작가 이름
	private AuthorHome authorHome; // 작가홈 클래스
	private ArrayList<Work> workList; // 작품 클래스 리스트
	Scanner sc = new Scanner(System.in);
	private int idx = 0;

	public Author() {

	}

	public Author(String name) {
		this.name = name;
		this.workList = new ArrayList<Work>();
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
	public void createWork() {
		workList.add(new Work());
		int idx = workList.size()-1;
		System.out.println((idx+1)+"번째 작품을 등록합니다.");
		workList.get(idx).createWork();
		
	}
	public void showWork() {
		System.out.println(this.name+"작가님은 "+workList.size()+"개의 작품이 있습니다.");
		System.out.println("등록된 작품 목록");
		for(int i=0; i<workList.size();i++) {
			System.out.println((i+1)+")제목: "+workList.get(i).getTitle());
		}
	}
}
