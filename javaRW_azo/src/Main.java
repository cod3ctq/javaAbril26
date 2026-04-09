import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Lectura y escritura con Java
        String ruta="C:\\Users\\PC\\Desktop\\datos.txt";
        String[] estados = {
                "AGUASCALIENTES",
                "BAJA CALIFORNIA",
                "BAJA CALIFORNIA SUR",
                "CAMPECHE",
                "CHIAPAS",
                "CHIHUAHUA",
                "CIUDAD DE MEXICO",
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

        File file = new File(ruta); //Representacion del archivo en memoria
        File escritura = new File("C:\\Users\\PC\\Desktop\\escritura.txt");
        String linea; //Guardar el contenido de cada linea del archivo, una linea a la vez
        String curp;
        String[] elementos;
        int claveIndex=0;

        try{
            FileReader fr = new FileReader(file); //Cache, tiene el contenido del archivo cargado en la memoria RAM
            BufferedReader br = new BufferedReader(fr); //Lector del cache
            FileWriter fw = new FileWriter(escritura);
            while( (linea = br.readLine()) != null){
                System.out.println(linea);
                elementos = linea.split(" ");
                //Determinar la clave del estado que contiene el registro actual
                for(int i=0; i< estados.length; i++){
                        // .toUppperCase() --> transforma a mayusculas el contenido de un string
                        //.toLowerCase() --> transforma a minusculas el contenido de un string
                    if(elementos[5].equals(estados[i])){
                        claveIndex = i;
                        break;  //detiene o rompe intencionalmente el ciclo (para que no continue si ya es verdadero)
                    }
                }
                curp = elementos[1].substring(0,2) + elementos[2].charAt(0)+ elementos[0].charAt(0)+
                        elementos[3].substring(8)+elementos[3].substring(3,5)+
                        elementos[3].substring(0,2)+elementos[4]+claves[claveIndex]+elementos[6];
                        System.out.println(curp);

                        //Escribir en un nuevo archivo los datos ya procesados
                        fw.write(curp + "\n");
            }
            fw.close(); //concretar los cambios en el archivo y guardarlos
        }catch(Exception ex){
            ex.printStackTrace(); //Imprimir INTENCIONALMENTE la traza completa de la excepcion
        }

    }
}