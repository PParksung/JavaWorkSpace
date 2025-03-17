package unionFind;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArrayList {
    
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
    }catch(Exception e){
    }
    return Lines;
}
