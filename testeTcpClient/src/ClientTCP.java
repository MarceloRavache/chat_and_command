
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP
{
    Socket s = null;
    DataInputStream in;
    DataOutputStream out;
    public ClientTCP(Socket s){
        this.s = s;
        try {
            this.in = new DataInputStream(s.getInputStream());
            this.out = new DataOutputStream(s.getOutputStream());
        }catch (IOException e){System.out.println("readline:"+e.getMessage());}
    }
    public void receber(){
        String data;

        try {
            while(true){
                data = in.readUTF();
                System.out.println(data);
            }
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
        }

    }

    public void enviar(){
        Scanner scn = new Scanner(System.in);
        String msg;
        try {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            while(true) {
                msg = scn.nextLine();
                out.writeUTF(msg);
            }
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
        } finally{ try {s.close();}catch (IOException e){/*close failed*/}}
    }
}