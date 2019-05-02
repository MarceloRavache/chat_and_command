import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServerTCP {
    public static void main (String args[]) {
        try{
            int serverPort = 8000; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}
class Connection extends Thread {
    public Connection (Socket aClientSocket) {
        try {
            String msg;
            DataInputStream in = new DataInputStream(aClientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(aClientSocket.getOutputStream());
            String data;
            while (true) {
                data = in.readUTF();
                if (data.equals("exec")) {
                    data = in.readUTF();
                    Comando cmd = new Comando(data);
                    data = cmd.getResult();

                    
                    out.writeUTF(data);
                } else {
                    System.out.println(data);
                }
                Scanner scn = new Scanner(System.in);
                msg = scn.nextLine();
                out.writeUTF(msg);
            }

        } catch (IOException e) {
            System.out.println("close:" + e.getMessage());
        } finally {
            if (aClientSocket != null) try {
                aClientSocket.close();
            } catch (IOException e) {
                System.out.println("close:" + e.getMessage());
            }
        }
    }
}

