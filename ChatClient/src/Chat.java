import java.rmi.*;
import java.rmi.server.*;
 
/**
 * @author Chinthaka
 *
 */
public class Chat extends UnicastRemoteObject implements ChatInterface  {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public ChatInterface client=null;
 
	public Chat(String n)  throws RemoteException { 
		this.name=n;   
	}
	public String getName() throws RemoteException {
		return this.name;
	}
 
	public void regClient(ChatInterface c){
		client=c;
	}
 
//	public ChatInterface getClient(){
//		return client;
//	}
 
	public void send(String s) throws RemoteException{
//		System.out.println(s);
		Client.show(s);
	}	
}