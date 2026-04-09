import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class EjercicioTexto {
    public static void main(String[] args) {
        String ruta = "D:\\Cursos\\Curso Java CETEQ\\EjercicioTexto.txt";
        File file = new File(ruta); //Representación de archivo en memoria
        try {
            FileReader fr = new FileReader(file);
            File escritura = new File("D:\\Cursos\\Curso Java CETEQ\\SoluciónTexto.txt");
            BufferedReader br = new BufferedReader(fr); //Lector del caché
            FileWriter fw = new FileWriter(escritura, true);

            int caracter;

            //Lee caracter por caracter hasta encontrar -1 (fin del archivo)
            while ((caracter = br.read()) != -1) {
                char c = (char) caracter;

                //Convirtiendo
                if (c >= 'A' && c <= 'Z') {
                    c = (char) (c + 1);
                    if (c > 'Z') c = 'A'; // Si era 'Z', vuelve a 'A'
                } else if (c >= 'a' && c <= 'z') {
                    c = (char) (c + 1);
                    if (c > 'z') c = 'a'; // Si era 'z', vuelve a 'a'
                }
                //Los espacios, saltos de línea, números y signos se mantienen intactos.

                fw.write(c);
            }
            fw.close();//Concretar los cambios en el archivo y guardarlos

        } catch (Exception ex) {
            //ex.printStackTrace();//Imprimir la traza completa de la excepción, si es que sucede
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }
}
