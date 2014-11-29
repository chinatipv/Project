package JLabel;

import java.awt.*;

import javax.swing.JLabel;

public class ColorLabel extends JLabel {

	ColorLabel() {
		setBackground(Color.RED);
		setOpaque(true);
	}

	int num = 0;

	public void updateColor() {

		setBackground(new Color(num));
		num += 1;
		try {
			wait(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
