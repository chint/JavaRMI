import java.rmi.*;
 
/**
 * @author Chinthaka
 *declare the remote accessible methods
 */
public interface ChatInterface extends Remote{
	
	//All this methods can be called remotly
	
	/*
	 * For getting the user name
	 * */
	public String getName() throws RemoteException;
	/*
	 * For sending chat message
	 * */
	public void send(String msg) throws RemoteException;
	/*
	 * For creating new client
	 * */
	public void regClient(ChatInterface c)throws RemoteException;
 
}