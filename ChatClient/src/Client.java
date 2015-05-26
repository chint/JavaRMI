 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.*;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
 
/**
 * @author Chinthaka
 *
 */
public class Client {
	
	public static Gui frame = new Gui();
	
	public static String name,host;
//	public static Chat client;
	public static ChatInterface client;
	public static  ChatInterface server;
	public static void main (String[] argv) {
		buttonclk();
		onClose();
		frame.setVisible(true);
		frame.getRootPane().setDefaultButton(frame.b1);
		frame.textField_1.grabFocus();
	    try {
	    	pop1();
			pop2();
													
//		    	System.setSecurityManager(new RMISecurityManager());
			/**
			 * enable this line to stop untrusted clients(not required in this example)
			 * If so the following VM commands must be entered.
			* -Djava.security.policy=file:${workspace_loc}/ChatServer/security.policy 
			* -Djava.rmi.server.codebase=file:${workspace_loc}/ChatServer/bin/
			 */
			
 		      	 client = new Chat(name);
 		    	  server = (ChatInterface)Naming.lookup("rmi://"+host+"/chat");
		    	String msg="|"+client.getName()+"| Joined the chat";
		    	server.send(msg);
		    	show("|Server System| Chat is ready: "+name);
		    	server.regClient(client);
		    	frame.textField_1.grabFocus();
 
	    	}catch (Exception e) {
	    		System.out.println("[Client System] Server failed: " + e);
	    		Object[] options = {  "OK"};
int n = JOptionPane.showOptionDialog(frame,
"Server Error:Check server status & network connection",
" Error",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null,options, options[0]);
if(n==0)
{	System.exit(0);	}
	    	}	}
	/*
	 * send message to other clients on "Send" button click
	 * */	
	static void buttonclk()
	{
		
		frame.b1.addActionListener( new ActionListener()

		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	String msg=frame.textField_1.getText();
		    		    	
				try {
									
					msg="["+client.getName()+"] "+msg;		    		
	    			server.send(msg);
//		    			frame.textArea.append(msg+"\n");
	    			frame.textField_1.setText(null);
	    			frame.textField_1.grabFocus();	
				} catch (RemoteException e1) {
					 
					Object[] options = {  "OK"};
					int n = JOptionPane.showOptionDialog(frame,
					"Server Error:Check server status & network connection",
	"Critical Error",JOptionPane.YES_NO_OPTION,	JOptionPane.ERROR_MESSAGE,null,	options,options[0]); 
					if(n==0)
					{	System.exit(0);	}
				}    }
		});
	}
	/*
	 * set user id
	 * */
	public static void pop1()
	{
			name = (String)JOptionPane.showInputDialog(
	        frame,"Enter a Chat ID","Enter a Chat ID",
	        JOptionPane.PLAIN_MESSAGE,null,  null,   "default user");
		
			frame.setTitle("~ CHAT ~  User-"+name);
		
		if((name==null)||(name==""))
		{

			System.exit(0);
		}
	}
	/*
	 * set host address
	 * */
	public static void pop2()
	{
			host = (String)JOptionPane.showInputDialog(
	        frame,"Enter a Chat Host","Enter a Chat Host",
	        JOptionPane.PLAIN_MESSAGE,null,  null,   "localhost");
			  
		if(name==null)
		{
			System.exit(0);
		}
		}
	/*
	 * display messages on local user interface
	 * */
	public static void show(String tx)
	{
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.BLUE);
	//		StyleConstants.setBold(keyWord, true);
		try {
			frame.doc.insertString(frame.doc.getLength(), tx+"\n", keyWord);
		} catch (BadLocationException e) {
			 
			e.printStackTrace();
		}
	}
	
	/*
	 * send exit a messages on user exit
	 * */
	public static void onClose()
	{Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		
	    public void run() {
	    	try {
				server.send("|"+client.getName()+"| LEFT THE CHAT!");
			} catch ( Exception e) {
				 
				System.out.println("Server Error");
			}
	    }
	}));
		}
}