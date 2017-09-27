import java.util.*;
import java.io.*;
public class ab extends TimerTask
    {
     static File file;
     public static void main(String[] args ) throws IOException
         {
         file = new File ("fsociety.dat");//mr robot referrence and this is the real heart
         if (! file.exists() )
             {
             file.createNewFile();//checking if the file isnt there already
         }
         System.out.println("File Created");
         ab test = new ab();
         Timer t = new Timer ();//gives alotted time for the user
         t.schedule(test, 30*1000L);
         try// mandatory error handling
             {
             while (file.exists())
                 {
                 System.out.print('.');
                 Thread.sleep(1000);//nothing happens if its already there
             }
         }
         catch (InterruptedException ie)
             {
             System.out.println("Error");
         }
         System.exit(0);
     } //end of main
     public void run()
         {
         file.delete();
     }
} //end of public class ab
