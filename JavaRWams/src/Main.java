import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String ruta="C:\\Users\\am181\\OneDrive\\Documentos\\datos.txt";
        File file=new File(ruta);
        String linea;
        String curp;
      String[]elementos;
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            while ( (linea=br.readLine())!=null ){
                System.out.println(linea);
                elementos=linea.split("");
               
            }
        } catch (Exception ex) {

        }
    }
}