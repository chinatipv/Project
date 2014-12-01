import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Seat {
	private ArrayList<ImageIcon[]> imageList = new ArrayList<ImageIcon[]>();
	// 1: booked
	// 2:notBooked
	// 3:checked
	// 4:unavailable
	ImageIcon image;

	private double price;
	private String type;
	private int numberOfPersonThatCanSit;
	Ticket ticket;
	boolean isBooked;
	String status;
	String ID;
	private int[] position;

	Seat(String type, double price, String ID,int[] position) {
		this.type = type;
		this.price = price;
		this.isBooked = false;
		this.ID = ID;
		this.status = "notBooked";
		this.position = position;
		if (type.equals("honeymoon")) {
			numberOfPersonThatCanSit = 2;
		} else {
			numberOfPersonThatCanSit = 1;
		}
		int numberOfType = 5;
		for (int i = 0; i < numberOfType; i++) {
			ImageIcon[] array = new ImageIcon[4];
			try {
				array[0] = new ImageIcon(ImageIO.read(new File("src\\images\\normalSeatBooked.png")));
				// String
				// examp;e
				// "seatType1_1"
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				array[1] = new ImageIcon(ImageIO.read(new File("src\\images\\normalSeatUnBooked.png")));
			} catch (Exception e) {

			}
			try {
				array[2] = new ImageIcon(ImageIO.read(new File("src\\images\\normalSeatUnBooked.png")));
				// String
				// examp;e
				// "seatType1_1"
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				array[3] = new ImageIcon(ImageIO.read(new File("src\\images\\normalSeatUnBooked.png")));
			} catch (Exception e) {
				System.out.println("fail");
			}
			imageList.add(array);
		}
		setNotBookedImageIcon();
	}
	public String getType(){
		return type;
	}
	public String getID() {
		return ID;
	}
	public int[] getPosition(){
		return position;
	}
	public void book() {
		isBooked = true;
		setBookedImageIcon();
		status = "booked";
	}

	public boolean canBook() {
		return !isBooked;
	}

	public String getPriceAndType() {
		return price + type;
	}
	public double getPrice(){
		return price;
	}

	public int convertTypeToInt(String type) {
		if (type.equals("normal")) {
			return 0;
		}
		if (type.equals("honeymoon"))
			return 1;
		return -1;
	}

	public void setSeatUnavailable() {
		status = "unavailable";
	}

	public void setSeatNotBook() {
		status = "notBooked";
	}

	public ImageIcon getImageIcon() {
		return image;

	}

	public void setBookedImageIcon() {
		image = imageList.get(convertTypeToInt(type))[0];
	}

	public void setNotBookedImageIcon() {
		image = imageList.get(convertTypeToInt(type))[1];
	}

	public void setSselectedImageIcon() {
		image = imageList.get(convertTypeToInt(type))[2];
	}

	public void setUnvailbleImageIcon() {
		image = imageList.get(convertTypeToInt(type))[3];
	}
	public String getStatus(){
		return status;
	}
	public void cancel(){
		status = "notBooked";
		setNotBookedImageIcon();
		isBooked=false;
	}
	@Override
	public String toString() {
		return "Seat [imageList=" + imageList + ", image=" + image + ", price="
				+ price + ", type=" + type + ", numberOfPersonThatCanSit="
				+ numberOfPersonThatCanSit + ", ticket=" + ticket
				+ ", isBooked=" + isBooked + ", status=" + status + ", ID="
				+ ID + ", position=" + Arrays.toString(position) + "]";
	}
	
	
}
