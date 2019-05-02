public class Esqueleto {
    String result;
    public Esqueleto(String data){
        Comando cmd = new Comando(data);
        result = cmd.getResult();
    }
    public String getComando(){
        return result;
    }
}
