package Post;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 


public class AuthorHome extends Author{
	private final String PATH = "C:\\b01_javaexp\\workplace3\\Creators\\src\\AuthorPost\\";
	private Scanner sc = new Scanner(System.in);
 // 작가홈 구현 class
	/*
	 작가홈을 위해 필요한 정보 
	 * */
	public AuthorHome() {
		System.out.println(getName()+"님 작가홈입니다.");
	}
	
	
	public void createPost() { //게시글 등록 메서드
		
		System.out.print("게시글 제목을 입력하십시오.:");
		String post_title = sc.nextLine(); // 게시글 제목 변수 + txt 파일로 만듦
		// post_title명으로 파일명 만들기
		
		String post_file = post_title+".txt"; // 사용자 입력에 .txt 확장자를 붙여준다.
		// 게시글을 관리하는 폴더 경로
		try {
			// 파일 생성
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH+post_file));
			// 생성한 파일에 내용을 입력받기
			System.out.println("게시글 내용을 입력하십시오. (입력을 마치려면 빈 줄을 입력하세요.Enter키 누르기): ");
			String line; // 사용자가 입력한 본문 내용
			while(!(line = sc.nextLine()).isEmpty()) { // 빈줄을 입력받기 전까지 파일에 내용물을 write 해준다.
				writer.write(line);
				writer.newLine();
			}
			writer.close(); // writer 메모리 해제
			System.out.println(post_title+" 게시물을 등록했습니다."); // 게시글 게시 완료를 사용자에게 보여줌.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close(); //scanner는 반드시 닫아준다.
		}		
		
	}
	/**
	 * @param name
	 */
	public AuthorHome(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	/**
 * 
 */

	public void showPost() { // 등록된 포스트을 보여주는 메서드
		System.out.println("등록된 포스트명");
		File dir = new File(PATH);
		String [] postList = dir.list();
		for(String post:postList) {
			System.out.println(post);
		}
	}
	public void deletePost() {
		showPost();
		System.out.println("삭제할 포스트명을 입력하십시오.(확장자 제외)");
		String input = sc.nextLine();
		/*
		 PATH+input+".txt" delete
		 * */		
	}
	public void readPost() {
		showPost(); //포스트명 보여주기
		System.out.println("읽을 포스트 제목를 입력해주세요. ");
		String readFile = sc.nextLine();
	}
	
}
