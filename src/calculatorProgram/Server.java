package calculatorProgram;

import java.io.EOFException;

// RECEIVE OPERATION FROM CLIENT
// CALCULATE OPERATION IN SERVER
// SEND RESULTS BACK TO CLIENT

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try{
            boolean closeConn = false;
    
            Calculations calculator = new Calculations();
            
            // CREATE A SERVER SOCKET AND LISTEN TO A SPECIFIC PORT
            ServerSocket server = new ServerSocket(3000);
            System.out.println("Starting server on port 3000");
    
    
            while(!closeConn){
                // WAIT FOR A CONNECTION
                System.out.println("Waiting for incoming connection.....");
                Socket conn = server.accept();
        
                System.out.println("Got a connection!");
        
                // DO SOMETHING
                InputStream is = conn.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                String input = ois.readUTF();
                String results = calculator.calculate(input);
                
                OutputStream os = conn.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeUTF(results);
                oos.flush();
    
                System.out.printf(">>> Calculate this: %s\n", input);
        
                
                // // WHEN FINISHED, CLOSE CONNECTION
                conn.close();
            }
        } catch(IOException i){
        }  catch(NumberFormatException ex){ 
            System.err.println(ex);
        } 
    }
}