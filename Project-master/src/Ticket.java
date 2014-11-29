public class Ticket {
	private Movie movie;
	private Round round;
	private String movieTitle, date, seatNumber, ID, theater, cinemaName;

	private static int numberOfTicket = 1;
	double price, discount;

	Ticket(Movie movie, Round round, Seat seat) {
		this.movieTitle = movie.getTitle();
		this.date = round.getCurrentDay().toString() + " "
				+ round.getStart().toString();
		this.seatNumber = seat.getID();
		this.theater = round.getTheaterID();
		this.ID = String.valueOf(numberOfTicket);
		numberOfTicket++;
		this.price = price;
	}
}
