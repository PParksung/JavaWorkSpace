import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ABStack {
    public static void main(String[] args) {
        ArrayList<String> Lines = readFile("input.txt");

        for(String Line : Lines){
            int size = 50;
            String[] str = Line.split(" ");
            ArrayStack<Integer> A = new ArrayStack<Integer>(size);
            ArrayStack<Integer> B = new ArrayStack<Integer>(size);
            
            for(int i=0; i<str.length;i++){
                int current = Integer.parseInt(str[i]);
                while(!B.isEmpty() && B.peek() > current){
                    A.push(B.pop());
                }
                B.push(current);
                while(!A.isEmpty()){
                    B.push(A.pop());
                }
            }
            while(!B.isEmpty()){
                System.out.print(B.pop()+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<String> readFile(String filename){
        ArrayList<String> Lines = new ArrayList<String>();
        try{
            String path = "";
            FileReader FileReader = new FileReader(path+filename);
            BufferedReader buffReader = new BufferedReader(FileReader);

            String line = "";
            while((line = buffReader.readLine())!=null){
                Lines.add(line);
            }

            buffReader.close();
            FileReader.close();
        } catch(Exception e){}
        return Lines;
    }
}
