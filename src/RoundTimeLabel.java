import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class RoundTimeLabel extends JLabel{
	public RoundTimeLabel(Round round, ChooseRound chooseRound) {
		// TODO Auto-generated constructor stub
		Dimension widthHeight = new Dimension(50,30);
		setPreferredSize(widthHeight);
		setMaximumSize(widthHeight);
		setMinimumSize(widthHeight);
		setSize(widthHeight);
		setBackground(new Color((int)(Math.random()*990000)));
		setOpaque(true);
		setText(round.getStart().toString());
		setVisible(true);
		setHorizontalAlignment(0);
		addMouseListener(new MouseListener() {
			
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
				
				BookSeat book = new BookSeat(round,chooseRound);
				book.run();
				chooseRound.dispose();
			}
		});
	}
}
