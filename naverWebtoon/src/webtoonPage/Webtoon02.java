package webtoonPage;

import java.io.*;
import java.util.*;


public class Webtoon02 implements Webtoon {	// 웹툰 인터페이스를 상속받은 개별 웹툰
	private String title="너는 그냥 개그만화나 그려라"; // 웹툰 제목
	private String author = "조석"; // 작가명
	private double rating = 9.94; // 평점
	private String desciption; // 웹툰 소개글
	private static final String BASE_PATH = "C:\\Users\\okw93\\git\\team4_naverwebtoon\\naverWebtoon\\"
			+ "src\\webtoonPage\\webtoon02\\";
	private int currentEp = 1;
	private int likeCount = 0;
	private List<Integer> ratings = new ArrayList<Integer>();
	private List<String> comments = new ArrayList<String>();
	
	public Webtoon02() {
		
	}
	
	public Webtoon02(String title, String author, double rating) {
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
		return "'마음의소리' 완결 후 3년, 조석 작가의 결코 소소하지 않은 일상 대공개!\r\n"
				+ "제목은... '너는 그냥 개그만화나 그려라'\r\n"
				+ "(그치만 다들 '마음의소리2'라 부를 거 다 앎)";
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
 
		System.out.print("읽어올 회차 번호를 입력하세요.. >> ");
		String epNum = scanner.nextLine();

			String epFilePath = BASE_PATH+"gag"+epNum+".txt";
			
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
	
	}
	@Override
	public void readNextEp() {
		int nextEp = currentEp + 1;
		String epFilePath = BASE_PATH + "gag"+ nextEp+".txt";
		
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
	    	String epFilePath = BASE_PATH + "gag" + prevEp + ".txt";
	    	
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
		ratings.add(rating);	
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
		comments.add(comment); 
		String commentFilePath = BASE_PATH + "comments.txt";
		try(FileWriter fw = new FileWriter(commentFilePath, false);  
			BufferedWriter bw = new BufferedWriter(fw)){
		   bw.write(comment);
		   bw.newLine(); 
		}catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
}