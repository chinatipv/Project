import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.multi.MultiButtonUI;
import javax.tools.Tool;
import javax.xml.ws.handler.MessageContext.Scope;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;




public class BookSeat extends JFrame implements Runnable{

	private JPanel selectSeat,showInfo;

private JTextArea infoTextArea;
private Round round;
private JPanel top ;
private ArrayList<Seat> bookedList = new ArrayList<Seat>();
	public BookSeat(Round round) {
		this.round=round;
		setBackground(Color.YELLOW);
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
		 Image image = toolkit.getImage("pencil.gif");  
		 Point hotSpot = new Point(0,0);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000,600);
		/*
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Pencil"); 
		setCursor(cursor);
		*/
		getContentPane().setLayout(null);

		initShowSeat(round);
		initInfo(round);
		top = new JPanel();
		top.add(selectSeat);
		top.add(showInfo);
		showInfo.setLayout(null);
		
		infoTextArea = new JTextArea();
		infoTextArea.setBounds(0, 0, 385, 300);
		showInfo.add(infoTextArea);
		top.setLayout(null);
		setContentPane(top);
		
		JLabel confrm = new JLabel("Confirm");
		confrm.setHorizontalAlignment(SwingConstants.CENTER);
		confrm.setBackground(new Color(102, 255, 0));
		confrm.setOpaque(true);
		confrm.setBounds(827, 454, 115, 70);
		confrm.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(bookedList);
				Payment p = new Payment(bookedList, round);
				p.run();
			}
		});
		top.add(confrm);
		
		JLabel clearLabel = new JLabel("Cancel");
		clearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clearLabel.setOpaque(true);
		clearLabel.setBackground(Color.CYAN);
		clearLabel.setBounds(636, 454, 115, 70);
		clearLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				clearSeat();
				

			}
		});
		top.add(clearLabel);
		
		JLabel back = new JLabel("Back");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setOpaque(true);
		back.setBackground(Color.RED);
		back.setBounds(737, 373, 110, 51);
		back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//chooseRound.run();
				//dispose();
			}
		});
		top.add(back);
	}
	public Round getRound(){
		return round;
	}
	public void clearSeat(){
		round.clearSeat();
		for(int i =0;i<seatLabelList.size();i++){
			seatLabelList.get(i).cancel();
		}
		
		//seatLabelList = new ArrayList<seatLabel>();
		for(int i=0;i<seatLabelList.size();i++){
			seatLabelList.get(0).updateIcon();
}


		updateInfo();
	}
	public ArrayList<Seat> getBookedList(){
		return bookedList;
	}
	public void updateInfo(){
		String infoString="";
		int[] numberOfbookedSeatInEachType = new int[round.getSeatInEachType().size()];
		for (int i = 0; i < round.getSeatInEachType().size(); i++) {
			for (int j = 0; j < round.getSeatInEachType().get(i).length; j++) {
				for (int k = 0; k < round.getSeatInEachType().get(i)[j].length; k++) {
					if(round.getSeatInEachType().get(i)[j][k].isBooked){
						infoString+=round.getSeatInEachType().get(i)[j][k].getID()+"\n";
						numberOfbookedSeatInEachType[i]++;
					}
				}
			}
		}
		infoString+="\n\n\n\n";
		for (int i = 0; i < round.getSeatInEachType().size(); i++) {
			if(numberOfbookedSeatInEachType[i]!=0){
				infoString+=round.getSeatInEachType().get(i)[0][0].getType()+" :         ";
				infoString+=numberOfbookedSeatInEachType[i]+"\n";
			}
		}
		infoTextArea.setText(infoString);
	}
	private void initInfo(Round round){
		showInfo = new JPanel();
		showInfo.setBounds(600, 0, 385, 300);
		showInfo.setBackground(Color.CYAN);
	}
	ArrayList<seatLabel> seatLabelList = new ArrayList<seatLabel>();
	private void initShowSeat(Round round){
		selectSeat = new JPanel();
		selectSeat.setBounds(0, 0, 600, 560);
		selectSeat.setBorder(new EmptyBorder(5, 5, 5, 5));
		selectSeat.setLayout(new BoxLayout(selectSeat, BoxLayout.Y_AXIS));
		selectSeat.setBackground(Color.RED);
		selectSeat.setOpaque(true);


		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBackground(Color.BLUE);
		panel.setOpaque(true);
		JLabel screen = new JLabel();
		screen.setBackground(Color.RED);
		screen.setOpaque(true);
		screen.setPreferredSize(new Dimension(280,20));
		panel.add(screen);
		
		for (int i = 0; i < round.getSeatInEachType().size(); i++) {
			for (int j = 0; j < round.getSeatInEachType().get(i).length; j++) {
				for (int k = 0; k < round.getSeatInEachType().get(i)[j].length; k++) {
					seatLabel label =new seatLabel( round.getSeatInEachType().get(i)[j][k],this);
					seatLabelList.add(label);
				}
			}
		}

		int a=0;
		for (int i = 0; i < round.getSeatInEachType().size(); i++) {
			JPanel midlePanel = new JPanel();
			midlePanel.setBackground(Color.lightGray);
			midlePanel.setBorder(new EmptyBorder(10,0,0,0));
			midlePanel.setLayout(new BoxLayout(midlePanel,BoxLayout.Y_AXIS));
			for (int j = 0; j < round.getSeatInEachType().get(i).length; j++) {
				JPanel insidePanel = new JPanel();
				insidePanel.setLayout(new FlowLayout());
				//insidePanel.setBackground(new Color(k*i*10000));
				insidePanel.setOpaque(true);
				for (int k = 0; k < round.getSeatInEachType().get(i)[j].length; k++) {
				//	System.out.println(j*(round.getSeatInEachType().get(i)[j].length));
				//	if(i!=0)
				//	System.out.println(i+" "+j+" "+k+"  "+a+" "+" "+(i*(round.getSeatInEachType().get(i-1).length)*(round.getSeatInEachType().get(i-1)[j].length)));
				//	System.out.println(i+" "+j+" "+k+"  "+a+" "+i*(round.getSeatInEachType().get(i-1).length)*(round.getSeatInEachType().get(i-1)[j].length)+" "+(i*(round.getSeatInEachType().get(i-1).length)*(round.getSeatInEachType().get(i-1)[j].length)+j*(round.getSeatInEachType().get(i)[j].length)+k));
					
					//label.setBackground(new Color(j*i*1000000));

					insidePanel.add(seatLabelList.get(a));
					a++;
				}
				midlePanel.add(insidePanel);
			}
			panel.add(midlePanel);

		}			
		JScrollPane scrollPane =new JScrollPane(panel);
		scrollPane.setBackground(Color.YELLOW);
		scrollPane.setBounds(0, 0, 500, 100);
		scrollPane.remove(1);
		scrollPane.getVerticalScrollBar().setUnitIncrement(5);
		selectSeat.add(scrollPane);
	}
	/*
	public Booking(Round round) {
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
		 Image image = toolkit.getImage("pencil.gif");  
		 Point hotSpot = new Point(0,0);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000,600);
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Pencil"); 
		setCursor(cursor);  	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(round.getSeatInEachType().size(),1,5,0));
		setContentPane(contentPane);
		for(int k = 0; k<round.getSeatInEachType().size();k++){
			JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(round.getSeatInEachType().get(k).length,round.getSeatInEachType().get(k)[0].length,2,2));

		for(int i=0;i<round.getSeatInEachType().get(k).length;i++){
			for(int j=0;j<round.getSeatInEachType().get(k)[0].length;j++){
				JLabel label = new JLabel();	
				label.setBackground(new Color(j*i*1000000));
				label.setOpaque(true);
				label.setText(i+" "+j);
				panel.add(label);
			}
		}
		contentPane.add(panel);
		}
	}*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 setVisible(true);
	}
}
