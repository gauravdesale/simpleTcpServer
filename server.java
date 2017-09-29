import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {

  private static class ClientHandler extends Thread {

    private Socket socket;
    
    ClientHandler(Socket socket) {//make a functionto check the connection and give the client some feedback
      System.out.println("Client connected");
      this.socket = socket;
    }
    
    @Override
    public void run() {
	    int portNumber = Integer.parseInt(args[0]);//get certain input from user in the form of java server 4000 and take the post number then
      
      try ( //making all the objecvts we will end up using
   		 ServerSocket serverSocket = new ServerSocket(portNumber);//new socket server object with port number as arguement
    		Socket clientSocket = serverSocket.accept();//new socket object with the accept function as its value from the socketserver class
    		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);//had to make a socket object since this object did not accept socketserver as an arguement and we needed to give it the value of accept()
    		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//new buffer read file to read raw from the files or the user 
	){
   		 String inputLine, outputLine;
            
    		// Initiate conversation with client
   		 KnockKnockProtocol kkp = new KnockKnockProtocol();//use this to communicate using the knock knock joke
    		outputLine = kkp.processInput(null);
    		out.println(outputLine);//printing the output from the server and the kpp object that is abstrated
		
       		  file = new File ("test.dat");
         	  if (! file.exists() )
             	{
             		file.createNewFile();//adding the ability to make a file for the server and not have it deleted when the thread finished
        	 }
        	 System.out.println("File Created");
	}
      import java.io.*;
     public static int BYTES_PER_LINE = 4;
         public void doit() {
         int ch, cv, bit, cnt;
             try {
                 for(cnt = 0, ch = brIn.read(); ch >= 0; ch = brIn.read()) {
                 cv = ((int)ch & 0x00ff);
                     for(bit = 7; bit >= 0; bit--) {
                     if ((cv & (2 << bit)) > 0)
                     psOut.print("1");
                     else
                     psOut.print("0");
                 }
                 cnt++;
                 if ((cnt % BYTES_PER_LINE) == 0)//added the byte conversion if needed by the user
                 psOut.println("");
             }
         } catch (IOException e) { }
         return;
     }
                   
 
  public static void main ( String[] args ) {    
    try ( ServerSocket ss = new ServerSocket(port) ) {
      System.out.println("Listening ...");//basic all the waiting text
      while ( true ) {
        Socket socket = ss.accept();
        new ClientHandler(socket).start();//using the object of client handler
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
