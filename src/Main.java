import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;
import javax.swing.ImageIcon;

public class main {
	static String cinemaName = "SKE";
	static ArrayList<Round> roundList = new ArrayList<Round>();
	static ArrayList<Movie> movieList = new ArrayList<Movie>();
	static ArrayList<Theater> theaterList = new ArrayList<Theater>();
	public static void main(String[] args) {

		innitAll();
		ArrayList<Round> newRound = sortForMovie(roundList);
		BookSeat b =new  BookSeat(roundList.get(0));
		b.run();
	}
		
public static void innitAll(){
	theaterList.add(new Theater(new int[] { 5, 10, 1 }, new int[]{10,8,5}, 3, new double[] {
			100, 200, 300 }, new String[] { "normal", "normal", "normal" },cinemaName,"Normal"));

	ArrayList<ImageIcon[]> imageIconList =new ArrayList<ImageIcon[]>();


		for(int i=0;i<10;i++){
			imageIconList.add(new ImageIcon[5]);
			for(int j=0;j<5;j++){
				try {
				String location ="src\\images\\movie"+(i+1)+"_"+j+".png";
				imageIconList.get(i)[j] = new ImageIcon(ImageIO.read(new File(location)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Fail");
				}
			}
		}

	movieList.add(new Movie("a in a", 9.8,
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
			18, imageIconList.get(0),  "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "action", new Day(
					10, 10, 10), "Steave Job",
			"ccccccccccccccccccccccccccccccccccccccc", "english", new Time(
					1000000)));


	roundList.add(new Round(theaterList.get(0), new Time(10, 10, 10),
			new Time(11, 11, 11), movieList.get(0)));

	writeToTextRoundList();
}
public static void writeToTextRoundList(){
	for(int i =0;i<roundList.size();i++)	{
		String[] array =roundList.get(i).toString().split("#");
		for(int j=0;j<array.length;j++){
			if(array[j].charAt(0)=='['){

				array[j]=array[j].substring(1, array[j].length()-1);
				String[] arrayInner = array[j].split(", ");
				for(int k=0;k<arrayInner.length;k++){
					System.out.print(arrayInner[k]+"@");
				}
			}
			else{
			System.out.print(array[j]+"#");
			}
		}
		System.out.println();
	}
	System.out.println();
	System.out.println();
	System.out.println();  
	for(int i =0;i<roundList.size();i++)	{
		System.out.println(roundList.get(i));
	}
}
public static void writeToTextMovieList(){
	for(int i =0;i<movieList.size();i++)	{
		String[] array =movieList.get(i).toString().split("#");
		for(int j=0;j<array.length;j++){
			if(array[j].charAt(0)=='['){

				array[j]=array[j].substring(1, array[j].length()-1);
				String[] arrayInner = array[j].split(", ");
				for(int k=0;k<arrayInner.length;k++){
					System.out.print(arrayInner[k]+"@");
				}
			}
			else{
			System.out.print(array[j]+"#");
			}
		}
		System.out.println();
	}
	System.out.println();
	System.out.println();
	System.out.println();  
	for(int i =0;i<movieList.size();i++)	{
		System.out.println(movieList.get(i));
	}
}
public static void wirteToTextTheaterList(){
	File file = new File("src\\save\\roundList");
	for(int i =0;i<theaterList.size();i++)	{
		String[] array =theaterList.get(i).toString().split("#");
		for(int j=0;j<array.length;j++){
			if(array[j].charAt(0)=='['){

				array[j]=array[j].substring(1, array[j].length()-1);
				String[] arrayInner = array[j].split(", ");
				for(int k=0;k<arrayInner.length;k++){
					System.out.print(arrayInner[k]+"@");
				}
			}
			else{
			System.out.print(array[j]+"#");
			}
		}
		System.out.println();
	}
	System.out.println();
	System.out.println();
	System.out.println();  
	for(int i =0;i<theaterList.size();i++)	{
		System.out.println(theaterList.get(i));
	}
}
	public static ArrayList<Round> sortForMovie(ArrayList<Round> round) {
		ArrayList<Round> newRound = new ArrayList<Round>();
		Collections.sort(round);
		for(int i =0;i<round.size();i++){
			//System.out.println(round.get(i).toString());
		}
	
		return newRound;
	}
}
