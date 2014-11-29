package JLabel;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame implements Runnable {
	ColorLabel color = new ColorLabel();

	changeBackground c;
	JLabel j1 = new JLabel();
	int count=0;
	test() {
		super.setSize(200, 200);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		ArrayList<image> imageList = new ArrayList<image>();
		try {
			imageList.add(new image(ImageIO.read(new File("D:\\java\\y1s1\\Project\\src\\images\\1.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}		try {
			imageList.add(new image(ImageIO.read(new File("D:\\java\\y1s1\\Project\\src\\images\\2.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}
		j1.setIcon(imageList.get(count).getImage());
		count++;
		j1.addMouseListener(new MouseListener() {
			
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
				j1.setIcon(imageList.get(count).getImage());
			}
		});
		add(j1);
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setVisible(true);
	}

	public static void main(String[] args) {
		test t = new test();
		t.run();
	}
}
