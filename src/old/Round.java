package old;
import java.util.ArrayList;

public class Round {
	private Movie movie;
	private Time start, end;
	private ArrayList<Seat[][]> seatInEachtype = new ArrayList<Seat[][]>();
	// []=row
	// [][]=column


	Round(Theater theater, Time start, Time end, Movie movie) {
		initSeat(theater);
		this.start = start;
		this.end = end;
		this.movie = movie;
	}
//	public boolean booking(int row, int column){
//		int[] input = convert(row,column);
//		if(seatInEachtype.get(input[0)[input[1][2])
//	}
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
							theater.getTypeOfSeat()[i], theater.getPrice()[i]);
					System.out.print(getSeatInString(i,j,k)+" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}

	}
	
	public  int[] convert(int row ,int column){
		int aToZ = 65;
		ArrayList<String> list = new ArrayList<String>();
		int type =0;
		for(int i =0;i<seatInEachtype.size();i++){
			if(row-seatInEachtype.get(i).length<=0){
				type =i;
				break;
			}
			row-=seatInEachtype.get(i).length+1;
			System.out.println(row);
		}
		System.out.println(type+" "+row+" "+column);
return new int[]{type,row,column};
	}
	
	public String getSeatInString(int type,int row,int column){
		int aToZ = 65;
		ArrayList<String> list = new ArrayList<String>();
		int totalRow =0;
		for(int i =0;i<seatInEachtype.size();i++){
			totalRow+=seatInEachtype.get(i).length;
		}
		for(int i=0;i<totalRow;i++){
			list.add(String.valueOf((char)aToZ));
			aToZ++;
		}
		int newRow =0;
		for(int i=0;i<type;i++){
			newRow+= seatInEachtype.get(i).length;
		}
		newRow+=row;
		return list.get(newRow)+column;
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
}
