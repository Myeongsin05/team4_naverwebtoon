package webtoonPage;

import java.io.*;
import java.util.*;

public class ReadPage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner epSc = new Scanner(System.in);

		while(true) {
			System.out.println("****************************************************************************************************");
			System.out.println("웹툰을 선택하세요!");
			System.out.println("1. 신의 탑 || 2.너는 그냥 개그 만화나 그려라 || 3. 신혼일기 || 4. 호랑이 형님 || 5. 웹툰 서비스 종료");
			System.out.println("****************************************************************************************************");
			System.out.print("번호를 입력하세요.. : ");
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				Webtoon wt01 = new Webtoon01();
				wt01.webtoonInfo();
				while (true) {
					System.out.println("0. 회차 선택 | 1. 이전화 | 2. 다음화 | 3. 좋아요 | 4. 별점주기 | 5. 댓글 작성 | 6. 뒤로 가기");
					System.out.print("원하는 기능을 선택하세요: ");
					String option = sc.nextLine();
					switch (option) {
					case "0" :
						wt01.readEpisode(epSc);
						break;
					case "1":
						wt01.readPrevEp();
						break;
					case "2":
						wt01.readNextEp();
						break;
					case "3":
						wt01.like();
						break;
					case "4":
						System.out.print("별점을 입력하세요 (1~10): ");
						int rating = Integer.parseInt(sc.nextLine());
						wt01.rate(rating);
						break;
					case "5":
						System.out.print("댓글을 입력하세요: ");
						String comment = sc.nextLine();
						wt01.writeComment(comment);
						break;
					case "6":
						// 뒤로 가기
						break;
					default:
						System.out.println("유효하지 않은 옵션입니다.");
					}
					if (option.equals("6")) {
						break;
					}
				}
				break;
			case "2":
				Webtoon wt02 = new Webtoon02();
				wt02.webtoonInfo();
				while (true) {
					System.out.println("0. 회차 선택 | 1. 이전화 | 2. 다음화 | 3. 좋아요 | 4. 별점주기 | 5. 댓글 작성 | 6. 뒤로 가기");
					System.out.print("원하는 기능을 선택하세요: ");
					String option = sc.nextLine();
					switch (option) {
					case "0" :
						wt02.readEpisode(epSc);
						break;
					case "1":
						wt02.readPrevEp();
						break;
					case "2":
						wt02.readNextEp();
						break;
					case "3":
						wt02.like();
						break;
					case "4":
						System.out.print("별점을 입력하세요 (1~10): ");
						int rating = Integer.parseInt(sc.nextLine());
						wt02.rate(rating);
						break;
					case "5":
						System.out.print("댓글을 입력하세요: ");
						String comment = sc.nextLine();
						wt02.writeComment(comment);
						break;
					case "6":
						// 뒤로 가기
						break;
					default:
						System.out.println("유효하지 않은 옵션입니다.");
					}
					if (option.equals("6")) {
						break;
					}
				}
				break;
			case "3":
				Webtoon wt03 = new Webtoon03();
				wt03.webtoonInfo();
				while (true) {
					System.out.println("0. 회차 선택 | 1. 이전화 | 2. 다음화 | 3. 좋아요 | 4. 별점주기 | 5. 댓글 작성 | 6. 뒤로 가기");
					System.out.print("원하는 기능을 선택하세요: ");
					String option = sc.nextLine();
					switch (option) {
					case "0" :
						wt03.readEpisode(epSc);
						break;
					case "1":
						wt03.readPrevEp();
						break;
					case "2":
						wt03.readNextEp();
						break;
					case "3":
						wt03.like();
						break;
					case "4":
						System.out.print("별점을 입력하세요 (1~10): ");
						int rating = Integer.parseInt(sc.nextLine());
						wt03.rate(rating);
						break;
					case "5":
						System.out.print("댓글을 입력하세요: ");
						String comment = sc.nextLine();
						wt03.writeComment(comment);
						break;
					case "6":
						// 뒤로 가기
						break;
					default:
						System.out.println("유효하지 않은 옵션입니다.");
					}
					if (option.equals("6")) {
						break;
					}
				}
				break;
			case "4":
				Webtoon wt04 = new Webtoon04();
				wt04.webtoonInfo();
				while (true) {
					System.out.println("0. 회차 선택 | 1. 이전화 | 2. 다음화 | 3. 좋아요 | 4. 별점주기 | 5. 댓글 작성 | 6. 뒤로 가기");
					System.out.print("원하는 기능을 선택하세요: ");
					String option = sc.nextLine();
					switch (option) {
					case "0" :
						wt04.readEpisode(epSc);
						break;
					case "1":
						wt04.readPrevEp();
						break;
					case "2":
						wt04.readNextEp();
						break;
					case "3":
						wt04.like();
						break;
					case "4":
						System.out.print("별점을 입력하세요 (1~10): ");
						int rating = Integer.parseInt(sc.nextLine());
						wt04.rate(rating);
						break;
					case "5":
						System.out.print("댓글을 입력하세요: ");
						String comment = sc.nextLine();
						wt04.writeComment(comment);
						break;
					case "6":
						// 뒤로 가기
						break;
					default:
						System.out.println("유효하지 않은 옵션입니다.");
					}
					if (option.equals("6")) {
						break;
					}
				}
				break;
			case "5":
				System.out.println("==============================");
				System.out.println("네이버 웹툰 종료.");
				return;
			default:
				System.out.println("1~5 중 입력 부탁드립니다.");
				
			}
		}
	}

}

