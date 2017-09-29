import java.io.*;
    public class conversion {
     BufferedInputStream brIn;
     PrintStream psOut;//this is making the appropriate objects 
    
     public static int BYTES_PER_LINE = 4;//global variable 
    
         public conversion() {
         this(System.in,System.out);
     }
    
         public BinCat(InputStream in, OutputStream out) {
         brIn = new BufferedInputStream(in);//make theese objects to access their functionality of using more syscall low level versions of scanner
         if (out instanceof PrintStream)
         psOut = (PrintStream)out;//this is printing the stream that is specified in bytes
         else
         psOut = new PrintStream(out);
     }
    
     
    
         public void doit() {
         int ch, cv, bit, cnt;
             try {
                 for(cnt = 0, ch = brIn.read(); ch >= 0; ch = brIn.read()) {//going through the stream that we had specified
                 cv = ((int)ch & 0x00ff);
                     for(bit = 7; bit >= 0; bit--) {
                     if ((cv & (2 << bit)) > 0)//checking many condition cases and going through each 8 bit part as a bit and checking if it is satisfying the id statement above
                     psOut.print("1");
                     else
                     psOut.print("0");
                 }
                 cnt++;
                 if ((cnt % BYTES_PER_LINE) == 0) 
                 psOut.println("");
             }
         } catch (IOException e) { }
         return;
     }
