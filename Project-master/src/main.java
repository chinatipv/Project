import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;

public class main {
	static ArrayList<Round> roundList = new ArrayList<Round>();
	static ArrayList<Movie> movieList = new ArrayList<Movie>();
	static ArrayList<Theater> theaterList = new ArrayList<Theater>();
	public static void main(String[] args) {

		innitAll();
		ArrayList<Round> newRound = sortForMovie(roundList);
		choose c = new choose(movieList,roundList);
		c.run();
	}
	
public static void innitAll(){
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	theaterList.add(new Theater(new int[] { 3, 3, 2 }, 10, 3, new double[] {
			1, 2, 3 }, new String[] { "a", "b", "c" }));
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	Image image4 = null;
	try {
		image1 = ImageIO.read(new File("D:\\java\\y1s1\\Project\\src\\images\\1.png"));
		image2 = ImageIO.read(new File("D:\\java\\y1s1\\Project\\src\\images\\2.png"));
		image3 = ImageIO.read(new File("D:\\java\\y1s1\\Project\\src\\images\\3.png"));
		image4 = ImageIO.read(new File("D:\\java\\y1s1\\Project\\src\\images\\4.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Fail");
	}
	movieList.add(new Movie("a in a", 9.8,
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
			18, image1, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "action", new Day(
					10, 10, 10), "Steave Job",
			"ccccccccccccccccccccccccccccccccccccccc", "english", new Time(
					1000000)));
	movieList.add(new Movie("a in b", 9.8,
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
			18, image2, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "action", new Day(
					10, 10, 10), "Steave Job",
			"ccccccccccccccccccccccccccccccccccccccc", "english", new Time(
					1000000)));
	movieList.add(new Movie("a in c", 9.8,
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
			18, image3, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "action", new Day(
					10, 10, 10), "Steave Job",
			"ccccccccccccccccccccccccccccccccccccccc", "english", new Time(
					1000000)));
	movieList.add(new Movie("a in d", 9.8,
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
			18, image4, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "action", new Day(
					10, 10, 10), "Steave Job",
			"ccccccccccccccccccccccccccccccccccccccc", "english", new Time(
					1000000)));

	roundList.add(new Round(theaterList.get(0), new Time(10, 10, 10),
			new Time(11, 11, 11), movieList.get(0)));
	roundList.add(new Round(theaterList.get(2), new Time(10, 10, 10),
			new Time(11, 11, 11), movieList.get(0)));
}
	public static ArrayList<Round> sortForMovie(ArrayList<Round> round) {
		ArrayList<Round> newRound = new ArrayList<Round>();
		Collections.sort(round);
		for(int i =0;i<round.size();i++){
			System.out.println(round.get(i).toString());
		}
	
		return newRound;
	}
}
