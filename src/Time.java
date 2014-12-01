
//elab-source: Time.java

public class Time {
	private int hour;
	private int minute;
	private int second;

	Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	Time(int duration) {
		this.hour = duration / 3600;
		duration %= 3600;
		this.minute = duration / 60;
		duration %= 60;
		this.second = duration;
	}

	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public int getSecond() {
		return this.second;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getDuration() {
		return 3600 * this.hour + 60 * this.minute + second;
	}

	public Time add(Time other) {
		int sec = (other.second + this.second) % 60;
		int min = (other.minute + this.minute + (this.second + other.second) / 60) % 60;
		int hour = other.hour
				+ this.hour
				+ (other.minute + this.minute + (this.second + other.second) / 60)
				/ 60;
		return new Time(hour, min, sec);
	}

	public int subtract(Time other){
		if(this.hour*3600+this.minute*60+this.second<other.hour*3600+other.minute*60+other.second)
		return 86400+(this.hour*3600+this.minute*60+this.second)-(other.hour*3600+other.minute*60+other.second);
			return Math.abs((this.hour-other.hour)*3600+(this.minute-other.minute)*60+(this.second-other.second));
	}

	public boolean equals(Time other) {
		if (other.hour == this.hour && other.minute == this.minute
				&& other.second == this.second)
			return true;
		return false;
	}

	public String toString() {
		return String.format("%02d:%02d:%02d", this.hour, this.minute,
				this.second);
	}
}