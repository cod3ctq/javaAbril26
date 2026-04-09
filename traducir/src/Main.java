import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       String letras="A)BCDEFGHIJKLMNÑOPQRSTUVWXYZ .20(abcdefghijklmnñopqrstuvwxyz,";

        File file = new File("C:\\Users\\lenovo\\Desktop\\textoentrada.txt");
        File escritura=new File("C:\\Users\\lenovo\\Desktop\\escritura.txt");
        String linea;
        String[] elementos;
        String salida="";

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(escritura);


            while((linea=br.readLine() )!=null)

            {
                //linea=linea.toUpperCase();

                System.out.println(linea);


                for(int i=0;i<linea.length();i++)
                {
                    char car=(char) linea.charAt(i);

                    int letra=letras.indexOf(car);


                    if(letra<letras.length()-1)
                    {
                       // System.out.println(letra+1);
                        //System.out.print(letras.charAt(letra+1));
                       // if(letra==65)

                            salida=salida+letras.charAt(letra+1);



                    }



                }
                salida=salida.replace("."," ");
                System.out.println(salida);
                fw.write(salida+"\n");
                fw.close();

            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}