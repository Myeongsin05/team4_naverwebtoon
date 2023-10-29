package Post;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		String path ="C:\\b01_javaexp\\workplace3\\Creators\\src\\";
//		String fname = "stipulation.txt";
//		int lineToRead = 4;
//		try {
//			FileReader fin = new FileReader(path+fname);
//			BufferedReader bfr = new BufferedReader(fin);
//			String line;
//			int currentLine = 0;
//			StringBuilder sbf = new StringBuilder();
//			while((line = bfr.readLine())!=null && currentLine < lineToRead) {
//				sbf.append(line).append("\n");
//				currentLine++;
//			}
//			
//			fin.close();
//			System.out.println("이용약관: "+sbf.toString());
//			System.out.println("이용약관 전문을 보시겠습니까? 보시길 원하면 Y를 눌러주세요.");
//			Scanner sc = new Scanner(System.in);
//			String input = sc.nextLine();
//			if(input.equals("Y")) {
//				System.out.println("이용약관 전문:");
//				while(true) {
//					FileReader fin2 = new FileReader(path+fname);
//					StringBuffer sbf2 = new StringBuffer();
//					
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch(IOException e) {
//			
//		}
		Scanner sc = new Scanner(System.in);
		System.out.println("★★★★크리에이터스에 오신걸 환영합니다.!!★★★★");
		System.out.println("작가가 되고 싶으신가요? 그러면 작가명을 입력해주세요.");
		String name = sc.nextLine();
		Author a01 = new Author(name); // 작가 클래스 생성
		System.out.println(a01.getName() + " 작가님 크리에이터스에 오신걸 환영합니다. ~~");
		outerLoop:while (true) {
			
			System.out.println("==============================================");
			System.out.println("1. 신규작품 등록 2. 내 작품 보기 3. 작가홈 가기");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				a01.createWork();
				break;
			case 2:
				a01.showWork();
				break;
			case 3:
				if (a01.getAuthorHome() == null) { // 개설된 작가홈이 없으면
					System.out.println(name + "작가님 작가홈을 개설하시겠습니까?\n 개설을 원하시면 '네'를 입력하세요");
					String answer = sc.nextLine();
					if (answer.equals("네")) {
						a01.createAuthorHome(new AuthorHome(name)); // 작가홈 만들기
					}

					System.out.println(a01.getName() + "작가홈 화면입니다.");
					
					while (true) {
						System.out.println("1. 새 게시물 등록 2. 게시물 목록 보기 3. 게시물 삭제 4. 게시물 수정 5. 메인화면으로 돌아가기" );
						int choice02 = Integer.parseInt(sc.nextLine());
						if (choice02 == 1)
							a01.getAuthorHome().createPost();
						if (choice02 == 2)
							a01.getAuthorHome().showPostList();
						if (choice02 == 3)
							a01.getAuthorHome().deletePost();
						if(choice02==5)
							continue outerLoop;
						if(choice==-1) break;
						else
							System.out.println("1~4까지 입력해주세요.");
					}
				}
				break;
			}
			if (choice == -1)
				break;

		}

	}

}
