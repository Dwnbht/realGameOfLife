import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MyFileReader {

    static String gateWay = "";

    public static void readFile(){
        String x = "";
        try {
            Scanner scan = new Scanner(new File("./input.txt"));
            do  {
                 x += scan.nextLine();
            } while(scan.nextLine() != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        gateWay = x;
    }
    public static void interpreter(String str){

    }
}
