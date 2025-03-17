package unionFind;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainJava {
    ArrayList<String> lines = readFile("input.txt");
    int N = Integer.valueOf(lines.remove(0));
    Node[] a = new Node[N];
    
    for(int i=0; i<N; i++)
        a[i] = new Node(i,1);

    UnionFind uf = new UnionFind(a);
    for(String line : lines)
    {
        String[] str = line.split(" ");
        int p = Integer.valueOf(str[0]);
        int q = Integer.valueOf(str[0]);
        uf.union(p,q);
    }
    uf.printsets();

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
    }catch(Exception e){
    }
    return Lines;
    }
}
