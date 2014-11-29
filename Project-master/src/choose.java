

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class choose extends JFrame implements Runnable {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	private ImageIcon[] currentImage = new ImageIcon[3];
	private int currentPosition=1;
	private ArrayList<Movie> movie;
	private ArrayList<Round> round;
	JLabel previousLabel,mainLabel,nextLabel;
	public choose(ArrayList<Movie> movie,ArrayList<Round> round) {
		this.movie=movie;
		this.round=round;
		currentImage[0]=movie.get(0).getImageIcon();
		currentImage[1]=movie.get(1).getImageIcon();
		currentImage[2]=movie.get(2).getImageIcon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		setUndecorated(true);
		previousLabel = new JLabel();
		previousLabel.setBounds(10, 60, 140, 180);
		previousLabel.setIcon(currentImage[0]);
		previousLabel.setBackground(Color.RED);
		previousLabel.setOpaque(true);
		getContentPane().add(previousLabel);
		
		mainLabel = new JLabel();
		mainLabel.setBounds(190, 20, 215, 265);
		mainLabel.setIcon(currentImage[1]);
		mainLabel.setBackground(Color.BLUE);
		mainLabel.setOpaque(true);
		getContentPane().add(mainLabel);
		
		nextLabel = new JLabel();
		nextLabel.setBounds(450, 60, 140, 180);
		nextLabel.setIcon(currentImage[2]);
		nextLabel.setBackground(Color.BLUE);
		nextLabel.setOpaque(true);
		getContentPane().add(nextLabel);
		
		JLabel previousButton = new JLabel();
		previousButton.setBounds(10, 300, 150, 50);
		previousButton.setBackground(Color.CYAN);
		previousButton.setOpaque(true);
		previousButton.addMouseListener(new MouseListener() {
			
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
		});
		getContentPane().add(previousButton);
		
		JLabel chooseButton = new JLabel();
		chooseButton.setBounds(190, 315, 215, 55);
		chooseButton.setBackground(Color.BLACK);
		chooseButton.setOpaque(true);
		getContentPane().add(chooseButton);
		
		JLabel nextButton = new JLabel();
		nextButton.setBounds(440, 300, 150, 50);
		nextButton.setBackground(Color.YELLOW);
		nextButton.setOpaque(true);
		nextButton.addMouseListener(new MouseListener() {
			
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
		});
			
		
		getContentPane().add(nextButton);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


	}
	private void updatePreviousMovie(){
		currentPosition--;
		if(currentPosition==-1)
			currentPosition=movie.size()-1;
		System.out.println(currentPosition);
		if(currentPosition>0&&currentPosition<movie.size()-1){
			currentImage[0]=movie.get(currentPosition-1).getImageIcon();
			currentImage[1]=movie.get(currentPosition).getImageIcon();
			currentImage[2]=movie.get(currentPosition+1).getImageIcon();
		}
		else if(currentPosition==0){
			currentImage[0]=movie.get(movie.size()-1).getImageIcon();
			currentImage[1]=movie.get(currentPosition).getImageIcon();
			currentImage[2]=movie.get(currentPosition+1).getImageIcon();
		}
		else if(currentPosition==movie.size()-1){
			currentImage[0]=movie.get(currentPosition-1).getImageIcon();
			currentImage[1]=movie.get(currentPosition).getImageIcon();
			currentImage[2]=movie.get(0).getImageIcon();
		}
		previousLabel.setIcon(currentImage[0]);
		mainLabel.setIcon(currentImage[1]);
		nextLabel.setIcon(currentImage[2]);
	}
	private void updateNextMovie(){
		currentPosition++;
		if(currentPosition==movie.size())
			currentPosition=0;
		System.out.println(currentPosition);
		if(currentPosition<movie.size()-1&&currentPosition>0){
			currentImage[0]=movie.get(currentPosition-1).getImageIcon();
			currentImage[1]=movie.get(currentPosition).getImageIcon();
			currentImage[2]=movie.get(currentPosition+1).getImageIcon();
		}
		else if(currentPosition==0){
			currentImage[0]=movie.get(movie.size()-1).getImageIcon();
			currentImage[1]=movie.get(currentPosition).getImageIcon();
			currentImage[2]=movie.get(currentPosition+1).getImageIcon();
		}
		else if(currentPosition==movie.size()-1){
			currentImage[0]=movie.get(currentPosition-1).getImageIcon();
			currentImage[1]=movie.get(currentPosition).getImageIcon();
			currentImage[2]=movie.get(0).getImageIcon();
		}
		previousLabel.setIcon(currentImage[0]);
		mainLabel.setIcon(currentImage[1]);
		nextLabel.setIcon(currentImage[2]);

		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setVisible(true);
	}

}
