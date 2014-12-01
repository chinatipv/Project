import java.util.ArrayList;

public class Round implements Comparable {
	private Movie movie;
	private Day currentDay =new Day(10,10,10);
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
	public ArrayList<Ticket> getTicketList(){
		return ticketList;
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
	public boolean booking(int type,int row, int column) {

		if (seatInEachtype.get(type)[row][column].canBook()) {
			ticketList.add(new Ticket(movie,this,seatInEachtype.get(type)[row][column]));
			seatInEachtype.get(type)[row][column].book();
		
//			System.out.println("round");
//			for (int i = 0; i < seatInEachtype.size(); i++) {
//				for (int j = 0; j < seatInEachtype.get(i).length; j++) {
//					for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
//						System.out.print(seatInEachtype.get(i)[j][k].isBooked+ " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				System.out.println();
//			}
//			
			
			return true;
		}
		return false;
	}

	private void initSeat(Theater theater) {
		for (int i = 0; i < theater.getNumberOfTypeOfSeat(); i++) {
			seatInEachtype.add(new Seat[theater.getNumbeOfRow()[i]][theater
					.getNumberOfColumn()[i]]);
		}
		for (int i = 0; i < seatInEachtype.size(); i++) {
			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
					seatInEachtype.get(i)[j][k] = new Seat(
							theater.getTypeOfSeat()[i], theater.getPrice()[i],
							getSeatInString(i, j, k),new int[]{i,j,k});
			//		System.out.print(getSeatInString(i, j, k) + " ");
				}
		//		System.out.println();
			}
//			System.out.println();
//			System.out.println();
		}

	}
	public void cancelSeat(int type,int row, int column){
		seatInEachtype.get(type)[row][column].cancel();
		
//		System.out.println("Cancel");
//		for (int i = 0; i < seatInEachtype.size(); i++) {
//			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
//				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
//					System.out.print(seatInEachtype.get(i)[j][k].isBooked+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
//		}
	}
	public void clearSeat(){
		for (int i = 0; i < seatInEachtype.size(); i++) {
			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
					if(seatInEachtype.get(i)[j][k].isBooked){
						cancelSeat(i, j, k);
					}
				}
//				System.out.println();
			}
//			System.out.println();
//			System.out.println();
		}
//		
//
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
//
//		for (int i = 0; i < seatInEachtype.size(); i++) {
//			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
//				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
//					System.out.print(seatInEachtype.get(i)[j][k].isBooked+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
//		}
	}
	private String getseatInEachtypeInString(){
		String s ="";
		for (int i = 0; i < seatInEachtype.size(); i++) {
			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
					s+=seatInEachtype.get(i)[j][k].toString()+" ";
					}
				}
			}
		return s;
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
		}
		return new int[] { type, row, column };
	}
	public ArrayList<Seat> searchSeat(int row, int column){
		ArrayList<Seat> seatList = new ArrayList<Seat>();

					seatList.add(seatInEachtype.get(convert(row, column)[0])[convert(row, column)[1]][convert(row, column)[2]]);

		return seatList;
	}
	public ArrayList<Seat> searchSeatBooked(){
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		for (int i = 0; i < seatInEachtype.size(); i++) {
			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
					if(!seatInEachtype.get(i)[j][k].canBook())
						seatList.add(seatInEachtype.get(i)[j][k]);
				}
			}
		}
		return seatList;
	}
	public ArrayList<Seat> searchSeatUnBooked(){
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		for (int i = 0; i < seatInEachtype.size(); i++) {
			for (int j = 0; j < seatInEachtype.get(i).length; j++) {
				for (int k = 0; k < seatInEachtype.get(i)[j].length; k++) {
					if(seatInEachtype.get(i)[j][k].canBook())
						seatList.add(seatInEachtype.get(i)[j][k]);
				}
			}
		}
		return seatList;
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
		return list.get(newRow) +"_"+ column;
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
	public ArrayList<Seat[][]> getSeatInEachType(){
		return seatInEachtype;
	}
	
	@Override
	public String toString() {
		return "Round [movie=" + movie + ", currentDay=" + currentDay
				+ ", start=" + start + ", end=" + end + ", seatInEachtype="
				+ seatInEachtype + ", ticketList=" + ticketList
				+ ", theaterID=" + theaterID + ", theater=" + theater + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(movie.compareTo(((Round) o).getMovie())==0){
			return theater.compareTo(((Round)o).getTheater());
		}
		return movie.compareTo(((Round) o).getMovie());
	}



	
}
