import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ejercicioCambio {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\PC-1\\Desktop\\ejerciciojava.txt";
        File file = new File(ruta);
        File escritura = new File("C:\\Users\\PC-1\\Desktop\\escritura.txt");
        String linea;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(escritura);

            while( (linea = br.readLine()) != null ) {
                //System.out.println(linea);

                String lineaTrans="";
                String lineaOriginal="";
                for(int i=0; i<linea.length(); i++){
                    char letraOriginal = linea.charAt(i);

                    if (Character.isLetter(letraOriginal)) {
                        if(letraOriginal=='z'){
                            lineaTrans += 'a';
                        }else if(letraOriginal=='Z'){
                            lineaTrans += 'A';

                        }else{
                            lineaTrans += (char) (letraOriginal + 1);
                        }

                    }else{
                        lineaTrans += lineaOriginal;
                    }

                }

                fw.write(lineaTrans + "\n");
                System.out.println("Original: " + linea + " -> Nueva: " + lineaTrans);

            }

            br.close();
            fw.close();
            System.out.println("Proceso terminado. Revisa escritura.txt");


        } catch (Exception ex) {
            ex.printStackTrace();


        }
    }
}