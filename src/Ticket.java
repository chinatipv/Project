public class Ticket {
	//private Round round;
	private String movieTitle, date, seatNumber, ID, theater, cinemaName;

	private static int numberOfTicket = 1;
	double price, discount;

	Ticket(Movie movie, Round round, Seat seat) {
		//this.round=round;
		this.movieTitle = movie.getTitle();
		this.date = round.getCurrentDay().toString() + " "
				+ round.getStart().toString();
		this.seatNumber = seat.getID();
		this.theater = round.getTheaterID();
		this.ID = String.valueOf(numberOfTicket);
		numberOfTicket++;
		this.price = price;
		this.cinemaName = round.getTheater().getCinemaName();
	}

	@Override
	public String toString() {
		return "Ticket [movieTitle=" + movieTitle + ", date=" + date
				+ ", seatNumber=" + seatNumber + ", ID=" + ID + ", theater="
				+ theater + ", cinemaName=" + cinemaName + ", price=" + price
				+ ", discount=" + discount + "]";
	}

	
}
