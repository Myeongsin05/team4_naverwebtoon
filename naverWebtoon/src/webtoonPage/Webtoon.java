package webtoonPage;

import java.util.Scanner;

public interface Webtoon {
	String getTitle();
	String getAuthor();
	double getRating();
	void setDescription(String description);
	String getDescription();
	
	void webtoonInfo(); // 웹툰 정보 출력
	void readEpisode(Scanner scanner); // 원하는 화 선택
	void readNextEp(); // 이전화
	void readPrevEp(); // 다음화
	void like(); // 좋아요 기능
	void rate(int rating); // 별점 주기
	void writeComment(String comment); // 댓글 기능
}
