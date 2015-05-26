
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;
import javax.swing.JTextField;



import javax.swing.JButton;


import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JScrollBar;


/**
 * @author Chinthaka
 *
 */
public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public  JTextField textField_1;
	public JButton b1;
	public JTextPane textPane;
	
	public StyledDocument doc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setTitle("-CHAT-");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		 
		textField_1 = new JTextField();
		textField_1.setToolTipText("Press Enter Key to send.");
//		textField_1.setText("sds");
		textField_1.setBounds(10, 396, 297, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		 
		
		 b1 = new JButton("Send");
		b1.setBounds(317, 396, 89, 23);
		contentPane.add(b1);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 396, 374);
		contentPane.add(textPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(389, 11, 17, 374);
		contentPane.add(scrollBar);
		 doc = textPane.getStyledDocument(); 
	}
}
