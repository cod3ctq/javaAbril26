import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ejercicioTexto {
    public static void main(String[] args) {
        String[] iniciales = {"a","b","c","d","e","f","g","h",
                              "i","j","k","l","m","n","o","p",
                              "q","r","s","t","u","v","w","x",
                              "y","z"};
        String[] finales = {"b","c","d","e","f","g","h",
                            "i","j","k","l","m","n","o",
                            "p","q","r","s","t","u","v",
                            "w","x","y","z","a"};


        String rutaT = "C:\\Users\\ARELI REYES CHIÑAS\\OneDrive\\Escritorio\\teEj1.txt";

        File file = new File(rutaT);
        File escritura = new File("C:\\Users\\ARELI REYES CHIÑAS\\OneDrive\\Escritorio\\teRe1.txt");
        String texto;
        char caracter;
        String letra;


        try {
            FileReader fr =new FileReader(file);
            FileWriter fw = new FileWriter(escritura);
            BufferedReader br = new BufferedReader(fr);

            while ((texto = br.readLine()) != null){
                System.out.println(texto);
                String resultado = "";

                for (int i = 0; i < texto.length(); i++){
                    caracter  = texto.charAt(i);
                    letra = String.valueOf(caracter).toLowerCase();
                    boolean existe = false;

                    for (int j = 0; j < iniciales.length; j++){
                        if (letra.equals(iniciales[j])){
                            resultado = resultado + finales[j];
                            existe = true;
                            break;
                        }
                    }
                    if (!existe){
                        resultado = resultado + caracter;
                    }
                }

                System.out.println(resultado);
                fw.write(resultado + "\n");
            }
            fw.close();
        }

        catch (Exception ex){
            ex.printStackTrace();
        }




    }
}
