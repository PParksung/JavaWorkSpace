package circularQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MainJava {
    public static void main(String[] args){
        ArrayList<String> Lines = readFile("input.txt");
        for(String Line : Lines){
            CQueue lst = new CQueue();
            String str[] = Line.split(" ");

            for(int i=0; i<str.length; i++){
                switch(str[i]){
                    case "i" : 
                        i++;
                        while(i<str.length && !str[i].equals("d")) {
                            lst.insert(Integer.parseInt(str[i]));
                            i++;
                        }
                        i--;
                        break;
                    
                    case "d" :
                        lst.delete();
                        break;
                }
            }
        }
    }

    public static ArrayList<String> readFile(String filename){
        ArrayList<String> Lines = null;
        try{
            String path = "";
            FileReader FileReader = new FileReader(path + filename);
            BufferedReader buffReader = new BufferedReader(FileReader);

            String line = "";
            Lines = new ArrayList<String>();
            while((line=buffReader.readLine())!=null){
                Lines.add(line);
            }

            buffReader.close();
            FileReader.close();
        }catch(Exception e){
        }
        return Lines;
    }
}
