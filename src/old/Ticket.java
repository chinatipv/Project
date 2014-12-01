package old;

public class Ticket {
	private Movie movie;
	private Round round;
	private String movieTitle,date,seat,ID,theater;
	private int numberOfTicket=1;
	double price, discount;

	Ticket(String movieTitle,String date ,String seat,String theater){
		this.movieTitle = movieTitle;
		this.date = date;
		this.seat = seat;
		this.theater = theater;
	}
	public Ticket printTicket(){
		return  this;
	}
	public String getMovieName(){
		return movie.getTitle();
	}
	public String getMovieBegin(){
		return round.getStart().toString();
	}
	public String getMovieEnd(){
		return round.getEnd().toString();
	}
	public String getSeat(){
		return seat;
	}
	public int getnumberOfTicket(){
		return numberOfTicket;
	}
}
