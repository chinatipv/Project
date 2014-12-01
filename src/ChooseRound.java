import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;


public class ChooseRound extends JFrame implements Runnable{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	ArrayList<ArrayList<Round>> listOfRoundInEachTheater = new ArrayList<ArrayList<Round>>();
	public ChooseRound(ArrayList<Round> round,choose c) {
		sortRoundToTheater(round);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel theaterListInner = new JPanel();
		theaterListInner.setBounds(0, 0, 300, 600);;
		theaterListInner.setSize(300, 600);
		theaterListInner.setBackground(Color.GRAY);
		theaterListInner.setMaximumSize(new Dimension(300,600));
		theaterListInner.setLayout(new BoxLayout(theaterListInner, BoxLayout.Y_AXIS));
		
		for(int i = 0;i<listOfRoundInEachTheater.size();i++){
			theaterListInner.add(new RoundLabel(listOfRoundInEachTheater.get(i),this));
		}
		
		
		JPanel theaterListOuter = new JPanel();
		theaterListOuter.setBounds(10, 10, 503, 580);;
		theaterListOuter.setBackground(Color.RED);
		theaterListOuter.setBackground(Color.BLACK);
		theaterListOuter.setLayout(new BoxLayout(theaterListOuter,BoxLayout.Y_AXIS));
		
		JScrollPane scroll = new JScrollPane(theaterListInner);
		scroll.setSize(300,600);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		scroll.remove(1);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		theaterListOuter.add(scroll);
		contentPane.add(theaterListOuter);
		
		JLabel back = new JLabel("Back");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setOpaque(true);
		back.setBackground(Color.YELLOW);
		back.setBounds(649, 162, 119, 137);
		back.addMouseListener(new MouseListener() {
			
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
				c.run();
			}
		});
		contentPane.add(back);

	}
	private void sortRoundToTheater(ArrayList<Round> round){
		for(int i =0;i<round.size();i++){
			boolean exist = false;
			for(int j=0;j<listOfRoundInEachTheater.size();j++){
				//for(int k=0;k<listOfRoundInEachTheater.get(j).size();k++){
					if(listOfRoundInEachTheater.get(j).get(0).getTheater().getID().equals(round.get(i).getTheater().getID())){
						listOfRoundInEachTheater.get(j).add(round.get(i));
						exist=true;
					}
				
			}
			if(!exist){
				listOfRoundInEachTheater.add(new ArrayList<Round>());
				listOfRoundInEachTheater.get(listOfRoundInEachTheater.size()-1).add(round.get(i));
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		setVisible(true);
	}
}
