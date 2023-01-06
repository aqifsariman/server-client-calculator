package calculatorProgram;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        boolean closeConn = false;

        
        System.out.println("Connected to server on localhost:3000");
        while(!closeConn){
            // CONNECT TO SERVER LISTENING ON PORT 3000
            Socket clntConn = new Socket("127.0.0.1", 3000);
    
            Console cons = System.console();
            String line = cons.readLine("What would you like to calculate today?\s");
            if(line.equalsIgnoreCase("end")){
                System.out.printf(">>> Thanks for using my calculator!");
                closeConn = true;
                // CLOSE CONNECTION
                clntConn.close();
        }   else {
                // DO SOMETHING
                // Get the output stream to write in the server
                OutputStream os = clntConn.getOutputStream();
                ObjectOutput oos = new ObjectOutputStream(os);
                
                oos.writeUTF(line);
                oos.flush();
                
                // GET INPUT FROM SERVER
                InputStream is = clntConn.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                
                String input = ois.readUTF();
                System.out.printf(">>> Answer: %s\n", input);
            }
        }

        
    }
}
