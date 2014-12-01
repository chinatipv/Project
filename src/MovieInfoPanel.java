import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;


public class MovieInfoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MovieInfoPanel() {
		setSize(280,480);
		setLayout(null);
		
		JLabel title = new JLabel("New label");
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		title.setBounds(20, 30, 149, 56);
		
		add(title);
		
		JLabel rating = new JLabel("10.0");
		rating.setFocusCycleRoot(true);
		rating.setFocusTraversalPolicyProvider(true);
		rating.setFont(new Font("Harrington", Font.PLAIN, 23));
		rating.setHorizontalTextPosition(SwingConstants.CENTER);
		rating.setHorizontalAlignment(SwingConstants.CENTER);
		rating.setOpaque(true);
		rating.setBackground(Color.BLUE);
		rating.setBounds(206, 28, 46, 45);
		add(rating);
		
		JLabel duration = new JLabel("New label");
		duration.setHorizontalAlignment(SwingConstants.CENTER);
		duration.setOpaque(true);
		duration.setBackground(Color.BLUE);
		duration.setBounds(178, 97, 92, 45);
		add(duration);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setOpaque(true);
		label_2.setBackground(Color.BLUE);
		label_2.setBounds(20, 163, 250, 96);
		add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setOpaque(true);
		label_3.setBackground(Color.BLUE);
		label_3.setBounds(10, 307, 260, 162);
		add(label_3);
		
		JLabel label = new JLabel("15 +");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(116, 102, 53, 35);
		add(label);
	}
}
