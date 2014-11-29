import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Seat {
	private double price;
	private String type;
	private int numberOfPersonThatCanSit;
	Ticket ticket;
	boolean isBooked;
	ImageIcon Image_notBook ;
	ImageIcon Image_Booked ;
	Seat(String type,double price){
		this.type=type;
		this.price =price;
		this.isBooked = false;
		if(type.equals("honeymoon")){
			numberOfPersonThatCanSit=2;
		}
		else{
			numberOfPersonThatCanSit=1;
		}
		try {
			Image_notBook  = new ImageIcon( ImageIO.read(new File("")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			Image_Booked  = new ImageIcon( ImageIO.read(new File("")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		}
	}
	public void booking(){
		
	}
	public boolean canBook(){
		return !isBooked;
	}
	public String getPriceAndType(){
		return price+type;
	}
	
}
