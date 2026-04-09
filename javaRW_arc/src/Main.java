import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Lectura y escritura con Java

        String[] estados = {
                "AGUASCALIENTES",
                "BAJA CALIFORNIA",
                "BAJA CALIFORNIA SUR",
                "CAMPECHE",
                "CHIAPAS",
                "CHIHUAHUA",
                "CDMX",
                "COAHUILA",
                "COLIMA",
                "DURANGO",
                "GUANAJUATO",
                "GUERRERO",
                "HIDALGO",
                "JALISCO",
                "MEXICO",
                "MICHOACAN",
                "MORELOS",
                "NAYARIT",
                "NUEVO LEON",
                "OAXACA",
                "PUEBLA",
                "QUERETARO",
                "QUINTANA ROO",
                "SAN LUIS POTOSI",
                "SINALOA",
                "SONORA",
                "TABASCO",
                "TAMAULIPAS",
                "TLAXCALA",
                "VERACRUZ",
                "YUCATAN",
                "ZACATECAS"
        };

        String[] claves = {
                "AS",
                "BC",
                "BS",
                "CC",
                "CS",
                "CH",
                "DF",
                "CL",
                "CM",
                "DG",
                "GT",
                "GR",
                "HG",
                "JC",
                "MC",
                "MN",
                "MS",
                "NT",
                "NL",
                "OC",
                "PL",
                "QT",
                "QR",
                "SP",
                "SL",
                "SR",
                "TC",
                "TS",
                "TL",
                "VZ",
                "YN",
                "ZS"
        };

        String ruta = "C:\\Users\\ARELI REYES CHIÑAS\\OneDrive\\Escritorio\\datosRW.txt";

        File file = new File(ruta); //Representaciòn del archivo en memoria
        File escritura = new File("C:\\Users\\ARELI REYES CHIÑAS\\OneDrive\\Escritorio\\escritura.txt");//Representacion en memoria de la escritura
        String linea;//Guardar el contenido de cada linea del archivo, una linea a la vez
// Este procedimiento intenta cargar el archivo en memoria
        String curp;
        String[] elementos;
        int claveIndex = 0;

        try{
            FileReader fr =new FileReader(file); // Cache, tiene el contenido del archivo cargado en RAM
            FileWriter fw = new FileWriter(escritura);
            BufferedReader br = new BufferedReader(fr); // Lector del cache

            while( (linea = br.readLine()) != null) {
                System.out.println(linea);
                // CURP RE C A AA MM DD M MC Y H R 08

                // split
                elementos = linea.split(" ");

                //Determinar la clave del estado en el registro actual
                for (int i = 0; i < estados.length; i++) {
                    if (elementos[5].toUpperCase().equals(estados[i])) {
                        claveIndex = i;
                        break;//Detiene o rompe intencionalmente el ciclo
                    }
                }

                curp = elementos[1].substring(0, 2) + elementos[2].charAt(0) + elementos[0].charAt(0) + elementos[3].substring(8) + elementos[3].substring(3, 5) +
                        elementos[3].substring(0, 2) + elementos[4] + claves[claveIndex] + elementos[6];
                System.out.println(curp);

                //Escribir en un nuevo archivo los datos ya procesados

                fw.write(curp + "\n");
            }

            fw.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}