package webtoonPage;

import java.io.*;
import java.util.*;


public class Webtoon {
	private String title; // 웹툰 제목
	private String author; // 작가명
	private double rating; // 평점
	private String desciption; // 웹툰 소개글
	public Webtoon() {
		
	}
	public Webtoon(String title, String author, double rating) {
		this.title = title;
		this.author = author;
		this.rating = rating;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	
}
