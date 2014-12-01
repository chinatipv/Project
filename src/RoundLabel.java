import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class RoundLabel extends JLabel {
	RoundLabel(ArrayList<Round> round,ChooseRound chooseRound ){
		int width = 500;
		int height = 100;
		setPreferredSize(new Dimension(width,height));
		setMaximumSize(new Dimension(width,height));
		setMinimumSize(new Dimension(width,height));
		setSize(new Dimension(width,height));
		setBackground(new Color(((int)(Math.random()*10000000))));
		setOpaque(true);
		setLayout(null);
		JLabel showImage = new JLabel();
		showImage.setBackground(Color.RED);
		showImage.setOpaque(true);
		showImage.setBounds(10, 10, 80, 80);
		add(showImage);
		
		JLabel info = new JLabel();
		info.setBackground(Color.BLUE);
		info.setOpaque(true);
		info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
		info.setBounds(100, 10, 390, 30);
		
		info.setBorder(new EmptyBorder(2,2,2,2));
		add(info);
		
		JLabel title = new JLabel(round.get(0).getTheater().getType());
		title.setBackground(Color.RED);
		title.setHorizontalAlignment(0);
		title.setOpaque(true);
		
		JLabel coverTitle = new JLabel();
		coverTitle.add(title);
		coverTitle.setMaximumSize(new Dimension(50,20));
		coverTitle.setHorizontalAlignment(0);
		coverTitle.setLayout(new BoxLayout(coverTitle, BoxLayout.X_AXIS));
		coverTitle.setBackground(Color.YELLOW);
		coverTitle.setOpaque(true);
		info.add(coverTitle);
		
		JLabel rate = new JLabel(String.valueOf(round.get(0).getTheater().getID()));
		rate.setBackground(Color.WHITE);
		rate.setOpaque(true);
		rate.setSize(10,10);
		rate.setHorizontalAlignment(0);
		rate.setMaximumSize(new Dimension(30,20));

		info.add(rate );
		
		JPanel chooseRoundLabel = new JPanel();
		chooseRoundLabel.setBackground(Color.CYAN);
		chooseRoundLabel.setOpaque(true);
		chooseRoundLabel.setLayout(new BoxLayout(chooseRoundLabel, BoxLayout.X_AXIS));
		chooseRoundLabel.setBounds(100, 50, 390, 40);
		for(int i=0;i<round.size();i++){
			chooseRoundLabel.add(new RoundTimeLabel(round.get(i),chooseRound));
		}

		
		JScrollPane chooseRoundScroll = new JScrollPane(chooseRoundLabel);
		chooseRoundScroll.setBounds(100, 50, 390, 40);
		chooseRoundScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);;
		add(chooseRoundLabel);
	}
}
