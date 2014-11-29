import java.awt.Image;

import javax.swing.ImageIcon;


public class Movie implements Comparable {
	private String title;
	private double rating;
	private String summery;
	private int rate;
	private Image image;
	private String detail;
	private String genres;
	private Day releaseDay;
	private String Director;
	private String synopis;
	private String language;
	private Time dulation;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getSummery() {
		return summery;
	}
	public void setSummery(String summery) {
		this.summery = summery;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public Day getReleaseDay() {
		return releaseDay;
	}
	public void setReleaseDay(Day releaseDay) {
		this.releaseDay = releaseDay;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getSynopis() {
		return synopis;
	}
	public void setSynopis(String synopis) {
		this.synopis = synopis;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Time getDulation() {
		return dulation;
	}
	public void setDulation(Time dulation) {
		this.dulation = dulation;
	}
	public ImageIcon getImageIcon(){
		return new ImageIcon(image);
	}
	public Movie(){
		
	}
	public Movie(String title, double rating, String summery, int rate,
			Image image, String detail, String genres, Day releaseDay,
			String director, String synopis, String language, Time dulation) {
		super();
		this.title = title;
		this.rating = rating;
		this.summery = summery;
		this.rate = rate;
		this.image = image;
		this.detail = detail;
		this.genres = genres;
		this.releaseDay = releaseDay;
		Director = director;
		this.synopis = synopis;
		this.language = language;
		this.dulation = dulation;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", summery="
				+ summery + ", rate=" + rate + ", image=" + image + ", detail="
				+ detail + ", genres=" + genres + ", releaseDay=" + releaseDay
				+ ", Director=" + Director + ", synopis=" + synopis
				+ ", language=" + language + ", dulation=" + dulation
				+ ", getTitle()=" + getTitle() + ", getRating()=" + getRating()
				+ ", getSummery()=" + getSummery() + ", getRate()=" + getRate()
				+ ", getImage()=" + getImage() + ", getDetail()=" + getDetail()
				+ ", getGenres()=" + getGenres() + ", getReleaseDay()="
				+ getReleaseDay() + ", getDirector()=" + getDirector()
				+ ", getSynopis()=" + getSynopis() + ", getLanguage()="
				+ getLanguage() + ", getDulation()=" + getDulation()
				+ ", getImageIcon()=" + getImageIcon() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return title.compareTo(((Movie)o).getTitle());

	}
	
}
