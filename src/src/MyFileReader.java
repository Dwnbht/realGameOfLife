import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MyFileReader {

    static String gateWay = "";

    public static void readFile(){
        String x = "";
        try {
            Scanner scan = new Scanner(new File("./input.txt"));
            while(scan.hasNext()){
                x += scan.nextLine()+'\n';
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        gateWay = x;
    }
    public static boolean[][] interpreter(String str){
        int i = 0;
        while(str.charAt(i) != '\n'){
            i++;
        }
        int stringWidth = i + 1;
        int stringHeight = str.length()/(i+1);
        boolean[][] gate = new boolean[stringHeight][stringWidth];
        //to find height divide index in string by String width. The remainder of the division is the x index.
        for(int z = 0; z < str.length(); z++){
            int indexX = z % stringWidth;
            int indexY = z / stringWidth;
            if(str.charAt(z) == '.'){
                gate[indexY][indexX] = false;
            } else if (str.charAt(z) == 'O'){
                gate[indexY][indexX] = true;
            }
        }
        return gate;
    }
}
