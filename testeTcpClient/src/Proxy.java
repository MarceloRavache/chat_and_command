import java.net.Socket;

public class Proxy {
    ClientTCP proxy;
    Socket s = null;
    public Proxy(Socket s){
        this.s = s;
        proxy = new ClientTCP(s);

    }
    public void myRead(){
        proxy.receber();
    }
    public void myWrite(){
        proxy.enviar();
    }
}
