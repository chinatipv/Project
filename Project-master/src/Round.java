import java.util.ArrayList;

public class Round implements Comparable {
	private Movie movie;
	private Day currentDay;
	private Time start, end;
	private ArrayList<Seat[][]> seatInEachtype = new ArrayList<Seat[][]>();
	private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	private String theaterID;
	private Theater theater;
	// []=row
	// [][]=column

	Round(Theater theater, Time start, Time end, Movie movie) {
		initSeat(theater);
		this.start = start;
		this.end = end;
		this.movie = movie;
		this.theaterID = theater.getID(); 
		this.theater=theater;
	}

	public String getTheaterID() {
		return theaterID;
	}

	public Day getCurrentDay() {
		return currentDay;
	}
	public boolean booking(ArrayList<int[]> seat){
		for(int i=0;i<seat.size();i++){
			if(booking(seat.get(i)[0],seat.get(i)[1])){
			}
			else{
				System.out.println("can't book");
				return false;
			}
		}
		return true;
	}
	public boolean booking(int row, int column) {
		int[] input = convert(row, column);
		if (seatInEachtype.get(input[0])[input[1]][input[2]].canBook()) {
			ticketList.add(new Ticket(movie,this,seatInEachtype.get(input[0])[input[1]][input[2]]));
			seatInEachtype.get(input[0])[input[1]][input[2]].book();
			return true;
		}
		return false;
	}

	private void initSeat(Theater theater) {
		for (int i = 0; i < theater.getNumberOfTypeOfSeat(); i++) {
			System.out.println(theater.getNumbeOfRow()[i]);
			seatInEachtype.add(new Seat[theater.getNumbeOfRow()[i]][theater
					.getNumberOfColumn()]);
		}
		for (int i = 0; i < seatInEachtype.size(); i++) {
			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
					seatInEachtype.get(i)[j][k] = new Seat(
							theater.getTypeOfSeat()[i], theater.getPrice()[i],
							getSeatInString(i, j, k));
					System.out.print(getSeatInString(i, j, k) + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}

	}

	public int[] convert(int row, int column) {
		int aToZ = 65;
		ArrayList<String> list = new ArrayList<String>();
		int type = 0;
		for (int i = 0; i < seatInEachtype.size(); i++) {
			if (row - seatInEachtype.get(i).length <= 0) {
				type = i;
				break;
			}
			row -= seatInEachtype.get(i).length + 1;
			System.out.println(row);
		}
		System.out.println(type + " " + row + " " + column);
		return new int[] { type, row, column };
	}

	public String getSeatInString(int type, int row, int column) {
		int aToZ = 65;
		ArrayList<String> list = new ArrayList<String>();
		int totalRow = 0;
		for (int i = 0; i < seatInEachtype.size(); i++) {
			totalRow += seatInEachtype.get(i).length;
		}
		for (int i = 0; i < totalRow; i++) {
			list.add(String.valueOf((char) aToZ));
			aToZ++;
		}
		int newRow = 0;
		for (int i = 0; i < type; i++) {
			newRow += seatInEachtype.get(i).length;
		}
		newRow += row;
		return list.get(newRow) + column;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}
	public Theater getTheater(){
		return theater;
	}
	public void setTheater(Theater theater){
		this.theater=theater;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(movie.compareTo(((Round) o).getMovie())==0){
			return theater.compareTo(((Round)o).getTheater());
		}
		return movie.compareTo(((Round) o).getMovie());
	}

	@Override
	public String toString() {
		return "Round [movie=" + movie + ", currentDay=" + currentDay
				+ ", start=" + start + ", end=" + end + ", seatInEachtype="
				+ seatInEachtype + ", ticketList=" + ticketList
				+ ", theaterID=" + theaterID + ", theater=" + theater
				+ ", getTheaterID()=" + getTheaterID() + ", getCurrentDay()="
				+ getCurrentDay() + ", getMovie()=" + getMovie()
				+ ", getStart()=" + getStart() + ", getEnd()=" + getEnd()
				+ ", getTheater()=" + getTheater() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
