package old;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;

import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.awt.Scrollbar;

import javax.swing.JTable;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.DebugGraphics;
import javax.swing.ScrollPaneConstants;

import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Component;




public class Payment extends JFrame {
	private Day day;
	private Time time;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txc10;
	private JTextField txb1000;
	private JTextField txb500;
	private JTextField txb100;
	private JTextField txb50;
	private JTextField txb20;
	private JTextField txc5;
	private JTextField txc2;
	private JTextField txc1;
	private JComboBox pop_s,pop_m,pop_l,nachos,popcoke_s,popcoke_m,popcoke_l;
	private JTextField receive;
	private JButton finish, okButton;
	private int total,pay,receiveBill; 
	JTabbedPane tabbedPane;
	private Movie movie;
	/**
	 * Launch the application.
	 */
	public void cancelButton(){
		clearReceive();
		clearPromotion();
		receive.setText("0");
		promotion ();

	}
	public void clearPromotion(){
		pop_s.setSelectedIndex(0);
		pop_m.setSelectedIndex(0);
		pop_l.setSelectedIndex(0);
		nachos.setSelectedIndex(0);
		popcoke_s.setSelectedIndex(0);
		popcoke_m.setSelectedIndex(0);
		popcoke_l.setSelectedIndex(0);
	}

	private void clearReceive(){
		finish.setVisible(false);
		txb1000.setText( 0+ "");
		txb500.setText( 0+ "");
		txb100.setText( 0+ "");
		txb50.setText( 0+ "");
		txb20.setText( 0+ "");
		txc10.setText( 0+ "");
		txc5.setText( 0+ "");
		txc2.setText( 0+ "");
		txc1.setText( 0+ "");
	}

	private void showDialog(){
		JLabel a = new JLabel(String.format("Needed %d Baht more",total-pay));
		a.setHorizontalAlignment(0);
		JOptionPane h = new  JOptionPane();
		h.showMessageDialog(this,a,"Warning",JOptionPane.PLAIN_MESSAGE);
	} 

	public void promotion (){
		int popS = Integer.parseInt(pop_s.getSelectedItem().toString()) *100;
		int popM = Integer.parseInt(pop_m.getSelectedItem().toString())*120;
		int popL = Integer.parseInt(pop_l.getSelectedItem().toString())*150;
		int nachosM = Integer.parseInt(nachos.getSelectedItem().toString())*200;
		int popcokeS = Integer.parseInt(popcoke_s.getSelectedItem().toString())*180;
		int popcokeM = Integer.parseInt(popcoke_m.getSelectedItem().toString())*220;
		int popcokeL = Integer.parseInt(popcoke_l.getSelectedItem().toString())*250;

		int sum = total+popS + popM + popL + nachosM + popcokeS + popcokeM + popcokeL;
		textField.setText( sum + "");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment(1000);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}

	/**
	 * Create the frame.
	 */
	public Payment(int total) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				promotion();
			}

		});
		this.total = total;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		


		Ticket ticket = new Ticket("movieTitle","date","seat","theater");

		Time time = new Time (5400);
		Day day = new Day(28,11,2014);
		Image image = new Image() {

			@Override
			public int getWidth(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ImageProducer getSource() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getProperty(String name, ImageObserver observer) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getHeight(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Graphics getGraphics() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		movie = new Movie ("title", 8.8, "summery",13,
				image,"detail", "genres", day,
				"director", "synopis", "language", time);
		initComponents();
	}

	private void initComponents(){
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(1253, 487, 230, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton button = new JButton("< Back");
		button.setBounds(1271, 521, 230, 23);

		JPanel cash = new JPanel();
		cash.setBounds(10, 119, 361, 371);
		cash.setLayout(null);
		JTextPane b1000_popup = new JTextPane();
		b1000_popup.setBounds(55, 40, 40, 20);
		b1000_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		b1000_popup.setText("1000");
		b1000_popup.setBackground(new Color(255, 250, 205));
		b1000_popup.setVisible(false);

		JTextPane b500_popup = new JTextPane();
		b500_popup.setBounds(55, 97, 40, 20);
		b500_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		b500_popup.setText("500");
		b500_popup.setBackground(new Color(255, 250, 205));
		b500_popup.setVisible(false);


		JTextPane b100_popup = new JTextPane();
		b100_popup.setBounds(55, 149, 40, 20);
		b100_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		b100_popup.setText("100");
		b100_popup.setBackground(new Color(255, 250, 205));
		b100_popup.setVisible(false);

		JTextPane b50_popup = new JTextPane();
		b50_popup.setBounds(55, 214, 40, 20);
		b50_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		b50_popup.setText("50");
		b50_popup.setBackground(new Color(255, 250, 205));
		b50_popup.setVisible(false);

		JTextPane b20_popup = new JTextPane();
		b20_popup.setBounds(55, 269, 40, 20);
		b20_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		b20_popup.setText("20");
		b20_popup.setBackground(new Color(255, 250, 205));
		b20_popup.setVisible(false);

		JTextPane c10_popup = new JTextPane();
		c10_popup.setBounds(292, 76, 40, 20);
		c10_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		c10_popup.setText("10");
		c10_popup.setBackground(new Color(255, 250, 205));
		c10_popup.setVisible(false);

		JTextPane c5_popup = new JTextPane();
		c5_popup.setBounds(292, 149, 40, 20);
		c5_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		c5_popup.setText("5");
		c5_popup.setBackground(new Color(255, 250, 205));
		c5_popup.setVisible(false);

		JTextPane c2_popup = new JTextPane();
		c2_popup.setBounds(292, 220, 40, 20);
		c2_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		c2_popup.setText("2");
		c2_popup.setBackground(new Color(255, 250, 205));
		c2_popup.setVisible(false);

		JTextPane c1_popup = new JTextPane();
		c1_popup.setBounds(292, 291, 40, 20);
		c1_popup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		c1_popup.setText("1");
		c1_popup.setBackground(new Color(255, 250, 205));
		c1_popup.setVisible(false);

		cash.add(c1_popup);
		cash.add(c2_popup);
		cash.add(c5_popup);
		cash.add(c10_popup);
		cash.add(b20_popup);
		cash.add(b50_popup);
		cash.add(b100_popup);
		cash.add(b500_popup);
		cash.add(b1000_popup);

		JLabel lblNewLabel = new JLabel("  Return :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(5, 11, 59, 15);
		cash.add(lblNewLabel);
		JLabel b1000 = new JLabel("");
		b1000.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int newb500 = Integer.parseInt(txb1000.getText()) * 2;
				txb500.setText(Integer.parseInt(txb500.getText()) + newb500 +"");
				txb1000.setText("0");

			}
			public void mouseEntered(MouseEvent e) {
				b1000_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				b1000_popup.setVisible(false);
			}
		});
		b1000.setIcon(new ImageIcon(Payment.class.getResource("/images/bank1000.jpg")));
		b1000.setBounds(55, 40, 120, 55);
		cash.add(b1000);



		JLabel b500 = new JLabel("");
		b500.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newb100 = Integer.parseInt(txb500.getText()) * 5;
				txb100.setText(Integer.parseInt(txb100.getText()) + newb100 +"");
				txb500.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				b500_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				b500_popup.setVisible(false);
			}
		});
		b500.setIcon(new ImageIcon(Payment.class.getResource("/images/bank500.jpg")));
		b500.setBounds(55, 97, 120, 55);
		cash.add(b500);
		JLabel b100 = new JLabel("");
		b100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newb50 = Integer.parseInt(txb100.getText()) * 2;
				txb50.setText(Integer.parseInt(txb50.getText()) + newb50 +"");
				txb100.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				b100_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				b100_popup.setVisible(false);
			}
		});
		b100.setIcon(new ImageIcon(Payment.class.getResource("/images/bank100.jpg")));
		b100.setBounds(55, 151, 120, 61);
		cash.add(b100);

		JLabel b20 = new JLabel("");
		b20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newc10 = Integer.parseInt(txb20.getText()) * 2;
				txc10.setText(Integer.parseInt(txc10.getText()) + newc10 +"");
				txb20.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				b20_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				b20_popup.setVisible(false);
			}
		});
		b20.setIcon(new ImageIcon(Payment.class.getResource("/images/bank20.jpg")));
		b20.setBounds(55, 276, 120, 64);
		cash.add(b20);

		JLabel b50 = new JLabel("");
		b50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newb20 = Integer.parseInt(txb50.getText()) * 2;
				txb20.setText(Integer.parseInt(txb20.getText()) + newb20 +"");
				txc10.setText(Integer.parseInt(txc10.getText()) + newb20/2 +"");
				txb50.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				b50_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				b50_popup.setVisible(false);
			}
		});
		b50.setIcon(new ImageIcon(Payment.class.getResource("/images/bank50.jpg")));
		b50.setBounds(55, 214, 120, 61);
		cash.add(b50);

		JLabel c10 = new JLabel("");
		c10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newc5 = Integer.parseInt(txc10.getText()) * 2;
				txc5.setText(Integer.parseInt(txc5.getText()) + newc5 +"");
				txc10.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				c10_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				c10_popup.setVisible(false);
			}
		});
		c10.setIcon(new ImageIcon(Payment.class.getResource("/images/coin10.png")));
		c10.setBounds(266, 40, 60, 60);
		cash.add(c10);

		JLabel c5 = new JLabel("");
		c5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newc2 = Integer.parseInt(txc5.getText()) * 2;
				txc2.setText(Integer.parseInt(txc2.getText()) + newc2 +"");
				txc1.setText(Integer.parseInt(txc1.getText()) + newc2/2 +"");
				txc5.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				c5_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				c5_popup.setVisible(false);
			}
		});
		c5.setIcon(new ImageIcon(Payment.class.getResource("/images/coin5.png")));
		c5.setBounds(266, 109, 60, 60);
		cash.add(c5);

		JLabel c2 = new JLabel("");
		c2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newc1 = Integer.parseInt(txc2.getText()) * 2;
				txc1.setText(Integer.parseInt(txc1.getText()) + newc1 +"");
				txc2.setText("0");
			}
			public void mouseEntered(MouseEvent e) {
				c2_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				c2_popup.setVisible(false);
			}
		});
		c2.setIcon(new ImageIcon(Payment.class.getResource("/images/coin2.png")));
		c2.setBounds(266, 180, 60, 60);
		cash.add(c2);

		JLabel c1 = new JLabel("");
		c1.setIcon(new ImageIcon(Payment.class.getResource("/images/coin1.png")));
		c1.setBounds(266, 251, 60, 60);
		c1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				c1_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				c1_popup.setVisible(false);
			}
		});
		cash.add(c1);

		txc10 = new JTextField();
		txc10.setText("0");
		txc10.setBounds(216, 51, 40, 20);
		cash.add(txc10);
		txc10.setColumns(10);

		txb1000 = new JTextField();
		txb1000.setText("0");
		txb1000.setColumns(10);
		txb1000.setBounds(5, 52, 40, 20);
		cash.add(txb1000);

		txb500 = new JTextField();
		txb500.setText("0");
		txb500.setColumns(10);
		txb500.setBounds(5, 107, 40, 20);
		cash.add(txb500);

		txb100 = new JTextField();
		txb100.setText("0");
		txb100.setColumns(10);
		txb100.setBounds(5, 169, 40, 20);
		cash.add(txb100);

		txb50 = new JTextField();
		txb50.setText("0");
		txb50.setColumns(10);
		txb50.setBounds(5, 234, 40, 20);
		cash.add(txb50);

		txb20 = new JTextField();
		txb20.setText("0");
		txb20.setColumns(10);
		txb20.setBounds(5, 296, 40, 20);
		cash.add(txb20);

		txc5 = new JTextField();
		txc5.setText("0");
		txc5.setColumns(10);
		txc5.setBounds(216, 128, 40, 20);
		cash.add(txc5);

		txc2 = new JTextField();
		txc2.setText("0");
		txc2.setColumns(10);
		txc2.setBounds(216, 200, 40, 20);
		cash.add(txc2);

		txc1 = new JTextField();
		txc1.setText("0");
		txc1.setColumns(10);
		txc1.setBounds(216, 269, 40, 20);
		cash.add(txc1);


		JPanel credit = new JPanel();
		credit.setBounds(10, 119, 361, 371);
		credit.setVisible(false);

		textField = new JTextField();
		textField.setBounds(80, 15, 86, 20);
		textField.setText(total+"");
		textField.setColumns(10);
		contentPane.setLayout(null);

		JLabel receivetx = new JLabel("Receive :");
		receivetx.setBounds(10, 73, 63, 15);
		receivetx.setFont(new Font("Tahoma", Font.BOLD, 12));



		contentPane.add(receivetx);

		receive = new JTextField();
		receive.setBounds(80, 71, 86, 20);
		receive.setColumns(10);
		contentPane.add(receive);

		JLabel lblT = new JLabel("Total :");
		lblT.setBounds(10, 15, 46, 17);
		lblT.setHorizontalAlignment(SwingConstants.TRAILING);
		lblT.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblHowToPay = new JLabel("Pay by...");
		lblHowToPay.setBounds(10, 44, 92, 17);
		lblHowToPay.setFont(new Font("Tahoma", Font.BOLD, 14));

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(80, 43, 86, 20);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearReceive();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit Card"}));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if  (comboBox.getSelectedItem().equals("Cash")){
					credit.setVisible(false);
					cash.setVisible(true);
					receivetx.setVisible(true);
					receive.setVisible(true);
					okButton.setVisible(true);
					finish.setVisible(false);
				}
				else if (comboBox.getSelectedItem().equals("Credit Card")){
					credit.setVisible(true);
					cash.setVisible(false);
					receivetx.setVisible(false);
					receive.setVisible(false);
					okButton.setVisible(false);
					finish.setVisible(true);
					receiveBill = 0;
				}
				else 
					;
			}
		});

		JTextPane popcorn_popup = new JTextPane();
		popcorn_popup.setBounds(242, 11, 86, 76);
		popcorn_popup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		popcorn_popup.setText("POPCORN\r\nHave 3 flovors\r\n    - Cheese\r\n    - Caramel\r\n    - Salt");
		popcorn_popup.setBackground(new Color(255, 250, 205));
		popcorn_popup.setVisible(false);
		JTextPane nachos_popup = new JTextPane();
		nachos_popup.setBounds(377, 15, 102, 87);
		nachos_popup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nachos_popup.setText("Nachos is a Mexican dish of tortilla chips covered with cheese or cheese-based sauce");
		nachos_popup.setBackground(new Color(255, 250, 205));
		nachos_popup.setVisible(false);
		JTextPane popcoke_popup = new JTextPane();
		popcoke_popup.setBounds(609, 30, 86, 40);
		popcoke_popup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		popcoke_popup.setText("Set of Popcorn & Coke");
		popcoke_popup.setBackground(new Color(255, 250, 205));
		popcoke_popup.setVisible(false);

		contentPane.add(popcoke_popup);
		contentPane.add(nachos_popup);
		contentPane.add(popcorn_popup);
		contentPane.add(credit);
		credit.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Payment.class.getResource("/images/EyWwB5WU57MYnKOuFPwrti5wRRZm3HmV7Zjhj2l9miQp8SR8OgW5fe.jpg")));
		lblNewLabel_2.setBounds(10, 11, 200, 112);
		credit.add(lblNewLabel_2);

		JTextPane txtpnSwipeA = new JTextPane();
		txtpnSwipeA.setEditable(false);
		txtpnSwipeA.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnSwipeA.setBounds(0, 134, 336, 208);
		credit.add(txtpnSwipeA);
		txtpnSwipeA.setText("  1. Swipe a card through a card reader.\r\n  2. Press up or down to find \"SKE Cinema\" \r\n  3. Press the GREEN button\r\n  4. Press number from total\r\n  5. Press the GREEN button\r\n  6. Check the information in the monitor\r\n  7. (correct) Press the GREEN button,\r\n      (incorrect) Press the RED button\r\n       A Card reader will print a slip.\r\n  8. Bring slip to customer to sign on it\r\n  9. Keep the slip and press the GREEN button\r\n10. Card reader will print another slip as a receipt.\r\n      Give it to customer (with receipt and ticket) ");
		txtpnSwipeA.setOpaque(false);
		contentPane.add(textField);
		contentPane.add(lblT);
		contentPane.add(lblHowToPay);
		contentPane.add(comboBox);
		contentPane.add(btnCancel);
		contentPane.add(button);
		contentPane.add(cash);

		JLabel lblNewLabel_1 = new JLabel("**If don't have any banknote or coin, click on the picture.**");
		lblNewLabel_1.setBounds(8, 340, 341, 20);
		cash.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblPromotion = new JLabel(":: Promotion ::");
		lblPromotion.setBounds(193, 11, 102, 20);
		lblPromotion.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPromotion);

		finish = new JButton("FINISH");
		finish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setVisible(true);
			}
		});
		finish.setBounds(242, 505, 89, 23);
		finish.setVisible(false);
		contentPane.add(finish);

		JButton back = new JButton("< BACK");
		back.setBounds(20, 505, 89, 23);
		contentPane.add(back);

		JButton cancel = new JButton("CANCEL");
		cancel.setBounds(135, 532, 89, 23);
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelButton();
				tabbedPane.setVisible(false);
			}
		});
		contentPane.add(cancel);

		JLabel popPic = new JLabel("");
		popPic.setBounds(193, 30, 92, 50);
		popPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				popcorn_popup.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				popcorn_popup.setVisible(false);
			}
		});
		popPic.setIcon(new ImageIcon(Payment.class.getResource("/images/Two-buckets-of-popcorn-007.jpg")));
		contentPane.add(popPic);

		JTextPane txtpnS = new JTextPane();
		txtpnS.setBounds(348, 30, 55, 50);
		txtpnS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnS.setText("S   - 100\r\nM  - 120\r\nL   - 150");
		contentPane.add(txtpnS);
		txtpnS.setOpaque(false);



		pop_s = new JComboBox();
		pop_s.setBounds(294, 27, 46, 17);
		pop_s.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		pop_s.setActionCommand("67");
		pop_s.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		pop_s.setSelectedIndex(0);
		pop_s.setMaximumRowCount(26);
		contentPane.add(pop_s);

		pop_l = new JComboBox();
		pop_l.setBounds(294, 67, 46, 17);
		pop_l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		pop_l.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		pop_l.setSelectedIndex(0);
		pop_l.setMaximumRowCount(26);
		contentPane.add(pop_l);

		pop_m = new JComboBox();
		pop_m.setBounds(294, 47, 46, 17);
		pop_m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		pop_m.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		pop_m.setSelectedIndex(0);
		pop_m.setMaximumRowCount(26);
		contentPane.add(pop_m);

		JTextPane txtpnS_1 = new JTextPane();
		txtpnS_1.setBounds(203, 82, 199, 20);
		txtpnS_1.setText("Normal Price( S - 120 )( M - 150 )( L - 180 )");
		txtpnS_1.setOpaque(false);
		txtpnS_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(txtpnS_1);

		JLabel lblNachos = new JLabel(" Nachos");
		lblNachos.setBounds(433, 65, 46, 20);
		lblNachos.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNachos);

		nachos = new JComboBox();
		nachos.setBounds(485, 67, 46, 17);
		nachos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		nachos.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		nachos.setSelectedIndex(0);
		nachos.setMaximumRowCount(26);
		contentPane.add(nachos);

		JLabel nachosPic = new JLabel("");
		nachosPic.setBounds(433, 0, 85, 62);
		nachosPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nachos_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				nachos_popup.setVisible(false);
			}
		});
		nachosPic.setIcon(new ImageIcon(Payment.class.getResource("/images/Nachos0309.jpg")));
		contentPane.add(nachosPic);

		JLabel lblFrom = new JLabel("200 from 280 Baht");
		lblFrom.setBounds(433, 88, 102, 14);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblFrom);

		JLabel popCokePic = new JLabel("");
		popCokePic.setBounds(555, 13, 80, 71);
		popCokePic.setIcon(new ImageIcon(Payment.class.getResource("/images/popcorncola.jpg")));
		popCokePic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				popcoke_popup.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				popcoke_popup.setVisible(false);
			}
		});
		contentPane.add(popCokePic);

		JTextPane txtpnS_2 = new JTextPane();
		txtpnS_2.setBounds(706, 30, 55, 50);
		txtpnS_2.setText("S   - 180\r\nM  - 220\r\nL   - 250");
		txtpnS_2.setOpaque(false);
		txtpnS_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtpnS_2);

		popcoke_s = new JComboBox();
		popcoke_s.setBounds(645, 30, 46, 17);
		popcoke_s.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		popcoke_s.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		popcoke_s.setSelectedIndex(0);
		popcoke_s.setMaximumRowCount(26);
		contentPane.add(popcoke_s);

		popcoke_m = new JComboBox();
		popcoke_m.setBounds(645, 49, 46, 17);
		popcoke_m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		popcoke_m.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		popcoke_m.setSelectedIndex(0);
		popcoke_m.setMaximumRowCount(26);
		contentPane.add(popcoke_m);

		popcoke_l = new JComboBox();
		popcoke_l.setBounds(645, 67, 46, 17);
		popcoke_l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearReceive();
			}
		});
		popcoke_l.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		popcoke_l.setSelectedIndex(0);
		popcoke_l.setMaximumRowCount(26);
		contentPane.add(popcoke_l);

		JTextPane txtpnNormalPriceS = new JTextPane();
		txtpnNormalPriceS.setBounds(555, 82, 199, 20);
		txtpnNormalPriceS.setText("Normal Price( S - 200 )( M - 250 )( L - 280 )");
		txtpnNormalPriceS.setOpaque(false);
		txtpnNormalPriceS.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(txtpnNormalPriceS);

		okButton = new JButton("OK");
		okButton.setBounds(111, 93, 55, 23);
		okButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receiveBill = Integer.parseInt(receive.getText());
				pay = Integer.parseInt(receive.getText());
				int sum = pay - Integer.parseInt(textField.getText());
				if(sum>=0){
					if (sum/1000>=1){
						txb1000.setText(  Integer.toString(sum/1000));
						sum = sum - (sum/1000)*1000;
					}
					else 
						txb1000.setText(  Integer.toString(0));

					if (sum/500>=1){
						txb500.setText(  Integer.toString(sum/500));
						sum = sum - (sum/500)*500;
					}
					else
						txb500.setText(  Integer.toString(0));

					if (sum/100>=1){
						txb100.setText(  Integer.toString(sum/100));
						sum = sum - (sum/100)*100;
					}	
					else txb100.setText(  Integer.toString(0));

					if (sum/50>=1){
						txb50.setText(  Integer.toString(sum/50));
						sum = sum - (sum/50)*50;
					}
					else txb50.setText(  Integer.toString(0));

					if (sum/20>=1){
						txb20.setText(  Integer.toString(sum/20));
						sum = sum - (sum/20)*20;
					}
					else txb20.setText(Integer.toString(0));

					if (sum/10>=1){
						txc10.setText(  Integer.toString(sum/10));
						sum = sum - (sum/10)*10;
					}
					else txc10.setText(  Integer.toString(0));

					if (sum/5>=1){
						txc5.setText(  Integer.toString(sum/5));
						sum = sum - (sum/5)*5;
					}
					else txc5.setText(  Integer.toString(0));

					if (sum/2>=1){
						txc2.setText(  Integer.toString(sum/5));
						sum = sum - (sum/2)*2;
					}
					else txc2.setText(  Integer.toString(0));

					if (sum/1>=1){
						txc1.setText(  Integer.toString(sum/1));
						sum = sum - (sum/1)*1;
					}
					else txc1.setText(  Integer.toString(0));
					finish.setVisible(true);
				}
				else{
					showDialog();
				}

			}
		});
		contentPane.add(okButton);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(377, 118, 397, 426);
		tabbedPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				promotion();
			}
		});
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setSize(1000,1000);
		panel.setLayout(null);
		panel.setMaximumSize(new Dimension(270,1000));
		panel.setMinimumSize(new Dimension(270,1000));
		panel.setPreferredSize(new Dimension(270,1000));
		panel.setLayout(null);

		JTextPane txtpnSkeCinemaLove = new JTextPane();
		txtpnSkeCinemaLove.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtpnSkeCinemaLove.setOpaque(false);
		txtpnSkeCinemaLove.setEditable(false);
		txtpnSkeCinemaLove.setText("SKE Cinema\n"+movie.getTitle()+"\nRate"+movie.getRate()+"Theatre"+"\r\nDate\r\nTime");
		txtpnSkeCinemaLove.setBounds(90, 94, 207, 203);
		panel.add(txtpnSkeCinemaLove);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setIcon(new ImageIcon(Payment.class.getResource("/images/Untitled-2.jpg")));
		lblNewLabel_3.setBounds(52, 23, 270, 319);
		panel.add(lblNewLabel_3);
		
//		
//		JLabel lblNewLabel_4 = lblNewLabel_3;
//		for(int i = 0;i<10;i++){
//			panel.add(lblNewLabel_4);
//			lblNewLabel_4.setBounds(52, (319)*(i)+23, 270, 319);
//			
//		}
//		
		

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setSize(300,300);
		scrollPane.setMaximumSize(new Dimension(300,300));
		scrollPane.setPreferredSize(new Dimension(300,300));
		scrollPane.setMinimumSize(new Dimension(300,300));
		scrollPane.remove(1);
		tabbedPane.addTab("     Ticket     ", null, scrollPane, null);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setSize(1000,1000);
		panel2.setMaximumSize(new Dimension(270,1000));
		panel2.setMinimumSize(new Dimension(270,1000));
		panel2.setPreferredSize(new Dimension(270,1000));
		panel2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane(panel2);
		panel2.setLayout(null);
		
		JLabel lblAaaa = new JLabel("aaaa");
		lblAaaa.setBounds(68, 327, 68, 14);
		panel2.add(lblAaaa);
		
		JLabel lblTotaljhhh = new JLabel("totaljhhh");
		lblTotaljhhh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotaljhhh.setBounds(90, 371, 175, 14);
		panel2.add(lblTotaljhhh);
		
		JLabel label_5 = new JLabel("jhhhhhh");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setBounds(90, 415, 175, 14);
		panel2.add(label_5);
		
		JLabel lblReceivejhhh = new JLabel("receivejhhh");
		lblReceivejhhh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblReceivejhhh.setBounds(90, 385, 175, 14);
		panel2.add(lblReceivejhhh);
		
		JLabel lblJh = new JLabel("vat7jhh");
		lblJh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblJh.setBounds(90, 461, 175, 14);
		panel2.add(lblJh);
		
		JLabel label_3 = new JLabel("Baht");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(292, 415, 36, 14);
		panel2.add(label_3);
		
		JLabel label_2 = new JLabel("Baht");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(292, 461, 36, 14);
		panel2.add(label_2);
		
		JLabel label_1 = new JLabel("Baht");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(292, 385, 36, 14);
		panel2.add(label_1);
		
		JLabel lblBaht = new JLabel("Baht");
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBaht.setBounds(292, 371, 36, 14);
		panel2.add(lblBaht);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Payment.class.getResource("/images/billqrcode55.png")));
		label.setBounds(10, 67, 353, 70);
		panel2.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("SKE Cinema\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 33, 353, 50);
		panel2.add(lblNewLabel_4);
		
		int sum;
		if(comboBox.getSelectedItem().equals("Cash"))
				sum = 0;
		else sum = total - receiveBill;
		JTextPane txtpnYYY = new JTextPane();
		txtpnYYY.setText("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n    -------------------------------------------------------------------------------   \r\n\r\n        :: Movie Ticket ::\r\n                   \r\n\t Name :\r\n\t Theatre :      (\u0E1A\u0E2D\u0E01 Type)\r\n\t Amount :\r\n\t Seat Class    x1\r\n\t\r\n\r\n\r\n    -------------------------------------------------------------------------------  \r\n\r\n\r\n        Total                                                                       \r\n        Receive                                                                \r\n\r\n        Return                                                                \r\n\r\n\r\n        VAT 7%                                                              \r\n\r\n");
		txtpnYYY.setMaximumSize(new Dimension(270,1000));
		txtpnYYY.setMinimumSize(new Dimension(270,1000));
		txtpnYYY.setPreferredSize(new Dimension(270,1000));
		txtpnYYY.setBounds(10, 33, 353,480);
		panel2.add(txtpnYYY);
		
		scrollPane_1.setPreferredSize(new Dimension(300, 300));
		scrollPane_1.setMinimumSize(new Dimension(300, 300));
		scrollPane_1.setMaximumSize(new Dimension(300, 300));

		tabbedPane.setVisible(false);
		tabbedPane.addTab("      Bill      ", null, scrollPane_1, null);

	}
}
