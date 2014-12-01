

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class choose extends JFrame implements Runnable {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	private ImageIcon[] currentImage = new ImageIcon[9];
	private int currentPosition=4;
	private ArrayList<Movie> movie;
	private ArrayList<Round> round;
	private JLabel previousLabel4,mainLabel,nextLabel4,previousLabel1,previousLabel2,previousLabel3;
	private JLabel nextLabel1;
	private JLabel nextLabel2;
	private JLabel nextLabel3;
	private choose thisClass=this;
	public choose(ArrayList<Movie> movie,ArrayList<Round> round) {
		this.movie=movie;
		this.round=round;
		JLayeredPane pane = new JLayeredPane();
		pane.setSize(1000, 600);
		currentImage[0]=movie.get(0).getImageIcon()[4];
		currentImage[1]=movie.get(1).getImageIcon()[3];
		currentImage[2]=movie.get(2).getImageIcon()[2];
		currentImage[3]=movie.get(3).getImageIcon()[1];
		currentImage[4]=movie.get(4).getImageIcon()[0];
		currentImage[5]=movie.get(5).getImageIcon()[1];
		currentImage[6]=movie.get(6).getImageIcon()[2];
		currentImage[7]=movie.get(7).getImageIcon()[3];
		currentImage[8]=movie.get(8).getImageIcon()[4];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		mainLabel = new JLabel();
		mainLabel.setBounds(360, 30, 280, 420);
		mainLabel.setIcon(currentImage[4]);
		mainLabel.setBackground(Color.BLUE);
		mainLabel.setOpaque(true);
		pane.add(mainLabel,9,0);

		
		previousLabel1 = new JLabel();
		previousLabel1.setOpaque(true);
		previousLabel1.setIcon(currentImage[3]);
		previousLabel1.setBackground(Color.BLACK);
		previousLabel1.setBounds(274, 45, 260, 390);
		pane.add(previousLabel1,8,0);
		
		previousLabel2 = new JLabel();
		previousLabel2.setOpaque(true);
		previousLabel2.setIcon(currentImage[2]);
		previousLabel2.setBackground(Color.RED);
		previousLabel2.setBounds(194, 60, 240, 360);
		pane.add(previousLabel2);
		
		previousLabel3 = new JLabel();
		previousLabel3.setOpaque(true);
		previousLabel3.setIcon(currentImage[1]);
		previousLabel3.setBackground(Color.RED);
		previousLabel3.setBounds(121, 75, 220, 330);
		pane.add(previousLabel3);
		
		previousLabel4 = new JLabel();
		previousLabel4.setBounds(50, 90, 200, 300);
		previousLabel4.setBackground(Color.RED);
		previousLabel4.setOpaque(true);
		previousLabel4.setIcon(currentImage[0]);
		previousLabel4.addMouseListener(new previous());
		pane.add(previousLabel4);
		
		nextLabel1 = new JLabel();
		nextLabel1.setOpaque(true);
		nextLabel1.setIcon(currentImage[5]);
		nextLabel1.setBackground(Color.BLACK);
		nextLabel1.setBounds(466, 45, 260, 390);
		pane.add(nextLabel1);
		
		nextLabel2 = new JLabel();
		nextLabel2.setOpaque(true);
		nextLabel2.setIcon(currentImage[6]);
		nextLabel2.setBackground(Color.RED);
		nextLabel2.setBounds(566, 60, 240, 360);
		pane.add(nextLabel2);
		
		nextLabel3 = new JLabel();
		nextLabel3.setOpaque(true);
		nextLabel3.setIcon(currentImage[7]);
		nextLabel3.setBackground(Color.RED);
		nextLabel3.setBounds(659, 75, 220, 330);
		pane.add(nextLabel3);
		
		nextLabel4 = new JLabel();
		nextLabel4.setBounds(750, 90, 200, 300);
		nextLabel4.setIcon(currentImage[8]);
		nextLabel4.setBackground(Color.BLUE);
		nextLabel4.setOpaque(true);
		nextLabel4.addMouseListener(new next());
		pane.add(nextLabel4);
		
		JLabel previousButton = new JLabel();
		previousButton.setBounds(115, 450, 150, 50);
		previousButton.setBackground(Color.CYAN);
		previousButton.setOpaque(true);
		previousButton.addMouseListener(new previous());
		pane.add(previousButton);
		
		JLabel chooseButton = new JLabel();
		chooseButton.setBounds(390, 490, 215, 55);
		chooseButton.setBackground(Color.BLACK);
		chooseButton.setOpaque(true);
		chooseButton.addMouseListener(new chooseThisMovie());
		pane.add(chooseButton);
		
		JLabel nextButton = new JLabel();
		nextButton.setBounds(725, 450, 150, 50);
		nextButton.setBackground(Color.YELLOW);
		nextButton.setOpaque(true);
		nextButton.addMouseListener(new next());
		pane.add(nextButton);
		getContentPane().add(pane);

		

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


	}
	private ArrayList<Round> getListOfRound(){
		System.out.println(currentPosition);
		ArrayList<Round> RoundThatHaveSameMove = new ArrayList<Round>();
		for(int i=0;i<round.size();i++){
			if(round.get(i).getMovie().getTitle().equals(round.get(currentPosition).getMovie().getTitle())){
				RoundThatHaveSameMove.add(round.get(i));
			}
		}
		for(int i=0;i<RoundThatHaveSameMove.size();i++){
		System.out.println(RoundThatHaveSameMove.get(i).getMovie().getTitle());
		}
		return RoundThatHaveSameMove;
	}
	private class chooseThisMovie implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			ChooseRound c = new ChooseRound(getListOfRound(),thisClass);
			c.run();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class previous implements MouseListener{

			
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
				updatePreviousMovie();
			}
		
	}
	private class  next implements MouseListener{
		
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
			updateNextMovie();
		}
	}
	private void updatePreviousMovie(){
		currentPosition--;
		if(currentPosition==-1)
			currentPosition=movie.size()-1;
		
		System.out.println(currentPosition);
		updateImageIcon();
	}
	private void updateNextMovie(){
		currentPosition++;
		if(currentPosition==movie.size())
			currentPosition=0;
		System.out.println(currentPosition);
		/*
		if(currentPosition<movie.size()-1&&currentPosition>0){
			currentImage[0]=movie.get(currentPosition-1).getImageIcon()[0];
			currentImage[1]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[2]=movie.get(currentPosition+1).getImageIcon()[0];
		}
		else if(currentPosition==0){
			currentImage[0]=movie.get(movie.size()-1).getImageIcon()[0];
			currentImage[1]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[2]=movie.get(currentPosition+1).getImageIcon()[0];
		}
		else if(currentPosition==movie.size()-1){
			currentImage[0]=movie.get(currentPosition-1).getImageIcon()[0];
			currentImage[1]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[2]=movie.get(0).getImageIcon()[0];
		}
		previousLabel.setIcon(currentImage[0]);
		mainLabel.setIcon(currentImage[1]);
		nextLabel.setIcon(currentImage[2]);
*/
		updateImageIcon();
	}
	private void updateImageIcon(){

		 if(currentPosition==0){
				currentImage[0]=movie.get(movie.size()-4).getImageIcon()[4];
				currentImage[1]=movie.get(movie.size()-3).getImageIcon()[3];
				currentImage[2]=movie.get(movie.size()-2).getImageIcon()[2];
				currentImage[3]=movie.get(movie.size()-1).getImageIcon()[1];
				currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
				currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
				currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
				currentImage[7]=movie.get(currentPosition+3).getImageIcon()[3];
				currentImage[8]=movie.get(currentPosition+4).getImageIcon()[4];
		}
		 else if(currentPosition==1){
				currentImage[0]=movie.get(movie.size()-3).getImageIcon()[4];
				currentImage[1]=movie.get(movie.size()-2).getImageIcon()[3];
				currentImage[2]=movie.get(movie.size()-1).getImageIcon()[2];
				currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
				currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
				currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
				currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
				currentImage[7]=movie.get(currentPosition+3).getImageIcon()[3];
				currentImage[8]=movie.get(currentPosition+4).getImageIcon()[4];
		}
		 else if(currentPosition==2){
				currentImage[0]=movie.get(movie.size()-2).getImageIcon()[4];
				currentImage[1]=movie.get(movie.size()-1).getImageIcon()[3];
				currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
				currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
				currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
				currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
				currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
				currentImage[7]=movie.get(currentPosition+3).getImageIcon()[3];
				currentImage[8]=movie.get(currentPosition+4).getImageIcon()[4];
		}
		 else if(currentPosition==3){
				currentImage[0]=movie.get(movie.size()-1).getImageIcon()[4];
				currentImage[1]=movie.get(currentPosition-3).getImageIcon()[3];
				currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
				currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
				currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
				currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
				currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
				currentImage[7]=movie.get(currentPosition+3).getImageIcon()[3];
				currentImage[8]=movie.get(currentPosition+4).getImageIcon()[4];
		}
		else if(currentPosition==movie.size()-1){
			currentImage[0]=movie.get(currentPosition-4).getImageIcon()[4];
			currentImage[1]=movie.get(currentPosition-3).getImageIcon()[3];
			currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
			currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
			currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[5]=movie.get(0).getImageIcon()[1];
			currentImage[6]=movie.get(1).getImageIcon()[2];
			currentImage[7]=movie.get(2).getImageIcon()[3];
			currentImage[8]=movie.get(3).getImageIcon()[4];
		}
		else if(currentPosition==movie.size()-2){
			currentImage[0]=movie.get(currentPosition-4).getImageIcon()[4];
			currentImage[1]=movie.get(currentPosition-3).getImageIcon()[3];
			currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
			currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
			currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
			currentImage[6]=movie.get(0).getImageIcon()[2];
			currentImage[7]=movie.get(1).getImageIcon()[3];
			currentImage[8]=movie.get(2).getImageIcon()[4];
		}
		else if(currentPosition==movie.size()-3){
			currentImage[0]=movie.get(currentPosition-4).getImageIcon()[4];
			currentImage[1]=movie.get(currentPosition-3).getImageIcon()[3];
			currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
			currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
			currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
			currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
			currentImage[7]=movie.get(0).getImageIcon()[3];
			currentImage[8]=movie.get(1).getImageIcon()[4];
		}
		else if(currentPosition==movie.size()-4){
			currentImage[0]=movie.get(currentPosition-4).getImageIcon()[4];
			currentImage[1]=movie.get(currentPosition-3).getImageIcon()[3];
			currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
			currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
			currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
			currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
			currentImage[7]=movie.get(currentPosition+3).getImageIcon()[3];
			currentImage[8]=movie.get(0).getImageIcon()[4];
		}
		else{
			currentImage[0]=movie.get(currentPosition-4).getImageIcon()[4];
			currentImage[1]=movie.get(currentPosition-3).getImageIcon()[3];
			currentImage[2]=movie.get(currentPosition-2).getImageIcon()[2];
			currentImage[3]=movie.get(currentPosition-1).getImageIcon()[1];
			currentImage[4]=movie.get(currentPosition).getImageIcon()[0];
			currentImage[5]=movie.get(currentPosition+1).getImageIcon()[1];
			currentImage[6]=movie.get(currentPosition+2).getImageIcon()[2];
			currentImage[7]=movie.get(currentPosition+3).getImageIcon()[3];
			currentImage[8]=movie.get(currentPosition+4).getImageIcon()[4];
		}
		 mainLabel.setIcon(currentImage[4]);
		 previousLabel1.setIcon(currentImage[3]);
		 previousLabel2.setIcon(currentImage[2]);
		 previousLabel3.setIcon(currentImage[1]);
		 previousLabel4.setIcon(currentImage[0]);
		nextLabel1.setIcon(currentImage[5]);
		nextLabel2.setIcon(currentImage[6]);
		nextLabel3.setIcon(currentImage[7]);
		nextLabel4.setIcon(currentImage[8]);
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setVisible(true);
	}
	
}
