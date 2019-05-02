import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class User {
    public static void main (String args[]) {
        Socket s = null;
        try {
            s = new Socket("localhost", 8000);
            Receber w = new Receber(s);
            Escrever r = new Escrever(s);
            Thread t1 = new Thread(w);
            Thread t2 = new Thread(r);
            t1.start();
            t2.start();

            t1.join();

        }catch (InterruptedException e){e.printStackTrace();
        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:" + e.getMessage());
        } finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
    }
}

class Receber implements Runnable{
    Socket s = null;
    public Receber(Socket s){
        this.s = s;
    }
    public void run(){
        ClientTCP p = new ClientTCP(s);
        p.receber();
    }
}

class Escrever implements Runnable{
    Socket s;
    public Escrever(Socket s){
        this.s = s;
    }
    public void run(){
        Proxy p = new ClientTCP(s);
        p.enviar();
    }
}
