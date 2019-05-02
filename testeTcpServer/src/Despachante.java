public class Despachante {
    String cmd;
    public Despachante(String data){
        Esqueleto esq = new Esqueleto(data);
        cmd = esq.getComando();
    }
    public String getCmd(){
        return cmd;
    }
}
