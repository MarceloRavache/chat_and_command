import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Comando {
    String result;
    public Comando(String data) {
        try {
            result = "";
            Process p = Runtime.getRuntime().exec(data);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String lineOut;
            while ((lineOut = input.readLine()) != null){
                result = result + "\n" + lineOut;
            }
            input.close();
        }catch(IOException e){System.out.println(e);}
    }
    public String getResult(){
        return result;
    }
}
