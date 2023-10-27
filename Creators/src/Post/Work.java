package Post;

import java.util.Scanner;

// 작품 클래스

public class Work extends Author{
	private Scanner sc = new Scanner(System.in);
	private String title; // 웹툰 제목
	private String [] genreSelect = {"로맨스","판타지","액션","일상","스릴러","개그",
			"무협/사극", "드라마", "감성", "스포츠"}; //웹툰 장르
	private String [] workFormatSelect = {"에피소드", "옴니버스", "스토리"}; // 웹툰 형식
	private String summary; // 한줄 요약
	
	public void createWork() {
		System.out.println("작품을 등록하는 화면입니다.");
		while(true) {
			System.out.print("작품명 입력: ");
			this.title = sc.nextLine();
			for(String genre:genreSelect) {
				System.out.print(genre+"\t");
			}
			System.out.println("중에 입력하세요.");
			System.out.println("장르 입력: ");
			String inputGenre = sc.nextLine();
			for(String format:workFormatSelect) {
				System.out.print(format+"\t");
			}
			System.out.println("중에 입력하세요.");
			System.out.println("웹툰 포맷 입력: ");
			String format = sc.nextLine();
			
			
			
			
		}
		
	}
}
