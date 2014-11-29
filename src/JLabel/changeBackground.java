package JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.GapContent;

public class changeBackground extends JLabel {

	/**
	 * Create the panel.
	 */
	Graphics g;
	  private Image img;
	public changeBackground(Image image) {
		this.img = image;
		setBackground(Color.BLUE);
		setOpaque(true);
	}
	
	  public void paintComponent(Graphics g) {
		  this.g = g;
		    g.drawImage(img, 0, 0, null);
		  }
	  public void updateBackground(Image img){
		  g.drawImage(img, 0, 0, null);
		  g.drawOval(10, 100, 100, 100);
	  }
}
