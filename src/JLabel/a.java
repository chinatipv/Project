package JLabel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class a {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a window = new a();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 39, 166, 230);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(186, 85, 281, 272);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
