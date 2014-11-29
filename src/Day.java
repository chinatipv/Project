public class Day {

	private int day;
	private int month;
	private int year;

	Day(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDayTillTheMoviePermier(Day currentDay){
		if((this.day-currentDay.day+(this.month-currentDay.month)*30+(this.year-currentDay.year)*365)>0)
			return (this.day-currentDay.day+(this.month-currentDay.month)*30+(this.year-currentDay.year)*365);
		return -1; // already show
	}
	public String toString(){
		return day+"/"+month+"/"+year;
	}
}