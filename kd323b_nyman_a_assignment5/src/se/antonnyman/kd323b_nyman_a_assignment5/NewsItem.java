package se.antonnyman.kd323b_nyman_a_assignment5;

public class NewsItem {
	String title;
	String summary;
	int image;
	public NewsItem(String title, String summary, int image) {
		super();
		this.title = title;
		this.summary = summary;
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public String getSummary() {
		return summary;
	}
	public int getImage() {
		return image;
	}
	

}
