import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class print_path {

    static ArrayList<Integer> arr;

    public static void main(String[] args) {

        try{
            File file = new File("./input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while(line!=null){
                StringTokenizer parser = new StringTokenizer(line, " ");
                int n = parser.countTokens();
                arr = new ArrayList<>(n);
                while(parser.hasMoreTokens()){
                    arr.add(Integer.parseInt(parser.nextToken()));
                }
                line = br.readLine();
                System.out.println(print_pathA(0));
                System.out.println(print_pathB(0));
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("IOException");
        }
    }

    public static int print_pathA(int num){
       
        System.out.print(num); //0
        System.out.print(" ");
        if(arr.get(num)==0){
            return 0;
        }
        
        return print_pathA(arr.get(num)); //2
        
    }
    public static int print_pathB(int num){//2 0 4 1 3 -> 0 1 3 4 2 0
        if(arr.get(num)!=0){
            System.out.print(print_pathB(arr.get(num)));
            System.out.print(" ");
            return num;
        }
        System.out.print(0+" ");
        return num;        
    }
}
