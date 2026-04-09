import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ejercicio1 {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\PC\\Desktop\\ejercicio.txt";
        String escritura = "C:\\Users\\PC\\Desktop\\transformacion.txt";

        File archivoLectura = new File(ruta);
        File archivoEscritura = new File(escritura);

        FileReader fr;
        BufferedReader br;
        FileWriter fw;
        String linea;
        String textoCifrado;

        try{

            // LEER ORIGINAL Y CREAR NUEVO
            fr = new FileReader(archivoLectura);
            br = new BufferedReader(fr);
            fw = new FileWriter(archivoEscritura);

            while((linea = br.readLine()) != null){
                textoCifrado = cifrarLinea(linea);
                fw.write(textoCifrado + "\n");
            }

            fr.close();
            fw.close();

            // REUTILIZAMOS br PARA LEER EL NUEVO ARCHIVO
            fr = new FileReader(archivoEscritura);
            br = new BufferedReader(fr);

            System.out.println("TEXTO TRANSFORMADO:");
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }

            fr.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static String cifrarLinea(String texto){

        String resultado = "";
        char letra;

        for(int i = 0; i < texto.length(); i++){

            letra = texto.charAt(i);

            if(letra == 'z') letra = 'a';
            else if(letra == 'Z') letra = 'A';
            else if((letra >= 'a' && letra <= 'y') || (letra >= 'A' && letra <= 'Y')){
                letra = (char)(letra + 1);
            }

            resultado = resultado + letra;
        }

        return resultado;
    }
}