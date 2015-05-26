import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
 
/**
 * @author Chinthaka
 *this class implements ChatInterface interface,these functions can be accessed remotely
 */
public class Chat extends UnicastRemoteObject implements ChatInterface  {
  	private static final long serialVersionUID = 1L;
	 
	public String name;
//	This array stores the clients when they are connected
	protected ArrayList<ChatInterface> client = new ArrayList<ChatInterface>();
	//constructor used for creating remote objects
	public Chat(String n)  throws RemoteException { 
		this.name=n;   
	}
	//get client name
	public String getName() throws RemoteException {
		return this.name;
	}
 //register client
	public void regClient(ChatInterface c){
		client.add(c);
	}
 

 //send chat message to all clients
	public void send(String s) throws RemoteException{
//		System.out.println("in chat"+s);
		Server.show(s);
		
		for (int i = 0; i < client.size(); i++) {
			ChatInterface c = client.get(i);
			try {
				c.send(s);
			} catch (RemoteException e) {
				left(c);
				i = i - 1;
			} 
 
	}	
}
	//remove client from the array when disconnected 
	public void left(ChatInterface c) {
				client.remove(c);
		 
	}

}