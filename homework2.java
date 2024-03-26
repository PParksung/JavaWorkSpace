import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class homework2 {
    
    public static ArrayList<String> readFile(String filename){
    ArrayList<String> Lines = null;
    try{
        String path = "";
        FileReader FileReader = new FileReader(path+filename);
        BufferedReader buffReader = new BufferedReader(FileReader);

        String line = "";
        Lines = new ArrayList<String>();
        while((line = buffReader.readLine())!=null){
            Lines.add(line);
        }
        buffReader.close();
        FileReader.close();
    }catch(Exception e){}
    return Lines;
    }

    public static void reArrange(int [] arr){
        int start = 0; 
        int end = arr.length-1;
        while(start<end){
            if(arr[start]%2==0){
                start++;
            }
            else if(arr[end]%2==1){
                end--;
            }
            else{
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++;
                end--;
            }
            
        }
    }

    public static void main(String[] args) {
        ArrayList<String> Lines = readFile("input.txt");
        if(Lines != null){
        for(String Line : Lines){
            String[] str = Line.split(" ");
            int[] arr = new int[str.length];
            for(int i=0;i<str.length;i++){
                arr[i] = Integer.valueOf(str[i]);
            }
            reArrange(arr);

            for(int value : arr){
                System.out.print(value+" ");
            }
            System.out.println();
        }
        }
    }
}
