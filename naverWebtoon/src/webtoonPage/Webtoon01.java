package webtoonPage;

import java.io.*;
import java.util.*;


public class Webtoon01 implements Webtoon {	// 웹툰 인터페이스를 상속받은 개별 웹툰
	private String title="신의 탑"; // 웹툰 제목
	private String author= "SIU"; // 작가명
	private double rating=9.88; // 평점
	private String desciption; // 웹툰 소개글
	private static final String BASE_PATH = "C:\\Users\\okw93\\git\\team4_naverwebtoon\\naverWebtoon\\"
			+ "src\\webtoonPage\\webtoon01\\";
	private int currentEp = 1;
	private int likeCount = 0;
	private List<Integer> ratings = new ArrayList<Integer>();
	private List<String> comments = new ArrayList<String>();
	
	public Webtoon01() {
		
	}
	
	public Webtoon01(String title, String author, double rating) {
		this.title = title;
		this.author = author;
		this.rating = rating;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public String getAuthor() {
		return  author;
	}
	@Override
	public double getRating() {
		return rating;
	}
	@Override
	public void setDescription(String description) {
		
	}
	@Override
	public String getDescription() {
		return "자신의 모든 것이었던 소녀를 쫓아 탑에 들어온 소년\r\n"
				+ "그리고 그런 소년을 시험하는 탑\n\n";
	}
	@Override
	public void webtoonInfo() {
		System.out.println("@@ 클릭한 웹툰 정보 @@");
		System.out.println("제목 :"+getTitle());
		System.out.println("작가 :"+getAuthor());
		System.out.println("평점 :"+getRating());
		System.out.println("=======================");
		System.out.println("<소개>\n"+getDescription());
	}

	@Override
	public void readEpisode(Scanner scanner) {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is)); 
		System.out.print("읽어올 회차 번호를 입력하세요.. >> ");
		String epNum = scanner.nextLine();
//		try {
//			String epNum = reader.readLine();
			String epFilePath = BASE_PATH+"godTower"+epNum+".txt";
			
			try(FileReader fr = new FileReader(epFilePath); // 객체 생성, 경로에있는 파일 읽기
				BufferedReader br = new BufferedReader(fr)) { // 객체 생성, BufferedReader로 fr 읽기
				// 블럭 안에 있는 코드 자원 자동 해제 (close() 쓸 쓸 필요 없어짐)
				// 예외 처리를 간소화 해줌('try'블럭이 끝날 때 자동으로 리소스를 닫기 때문)
				String line;	// line이라는 변수에 readLine(); 메서드로 읽어온 글 저장
				System.out.println("===================================================");
				while((line = br.readLine()) != null) { //읽어올 줄이 없지 않으면 line 출력.
					System.out.println(line); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			

//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
	}
	@Override
	public void readNextEp() {
		int nextEp = currentEp + 1;
		String epFilePath = BASE_PATH + "godTower"+ nextEp+".txt";
		
		if(epExist(epFilePath)) {
			currentEp = nextEp;
			try(FileReader fr = new FileReader(epFilePath); 
				BufferedReader br = new BufferedReader(fr)) {
				String line;
				System.out.println("===================================================");
				while((line = br.readLine()) != null) { 
					System.out.println(line); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("다음 화가 없습니다.");
		}
	}
	
	@Override
	public void readPrevEp() {
	    if (currentEp > 1) {
	    	int prevEp = currentEp - 1;
	    	String epFilePath = BASE_PATH + "godTower" + prevEp + ".txt";
	    	
	    	if(epExist(epFilePath)) {
	    		currentEp = prevEp;
	    		try(FileReader fr = new FileReader(epFilePath); 
	    				BufferedReader br = new BufferedReader(fr)) {
	    			String line;
	    			System.out.println("===================================================");
	    			while((line = br.readLine()) != null) { 
	    				System.out.println(line); 
	    			}
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	    	}else {
	    		System.out.println("이전 화가 없습니다.");
	    	}
	    	
	    } else {
	    	System.out.println("가장 첫 화입니다.");
	    }
	        
	}

	public boolean epExist(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
	
	public void like() {
		System.out.println("좋아요 +1 되었습니다.");
		likeCount++;
	}

	@Override
	public void rate(int rating) {
		ratings.add(rating);	// 별점을 리스트에 추가하고 평균을 구하여 rating 변수에 저장
		if(!ratings.isEmpty()) {
			int sum = 0;
			for (int r : ratings) {
				sum += r;
			}
			this.rating = (double) sum / ratings.size(); 
		}
	}

	@Override
	public void writeComment(String comment) {
		comments.add(comment); // 댓글을 리스트에 추가
		String commentFilePath = BASE_PATH + "comments.txt";
		try(FileWriter fw = new FileWriter(commentFilePath, false); // false = 새로운 내용을 파일에 추가 
			BufferedWriter bw = new BufferedWriter(fw)){
		   bw.write(comment);
		   bw.newLine(); // 입력 후 라인 바꾸기.
		}catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
}
