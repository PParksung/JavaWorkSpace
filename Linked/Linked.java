package Linked;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class Linked{  
    public static void main(String[] args){
        ArrayList<String> Lines = readFile("input.txt");

        for(String Line : Lines){
            String[] str = Line.split(" ");
            SinglyLinkedList SList = new SinglyLinkedList();

            for(int i = 0; i < str.length; i++){
                SList.insertLast(Integer.valueOf(str[i]));
            }

            SList.printAll();
            SList.reverse();
            SList.printAll();
            
        }
    }

    public static ArrayList<String> readFile(String filename){
        ArrayList<String> Lines = null;
        try{
            String path = "";
            FileReader FileReader = new FileReader(path+filename);
            BufferedReader buffReader = new BufferedReader(FileReader);
            
            String line = "";
            Lines = new ArrayList<String>();
            while( (line = buffReader.readLine())!=null ){
                Lines.add(line);
            }
            buffReader.close();
            FileReader.close();
        }catch(Exception e){}
        return Lines;
    }

    public static class Node {
        private int item;
        private Node next;
        public Node(int newItem, Node node){
            item = newItem;
            next = node;
        }
        public int getItem(){return item;}
        public Node getNext(){return next;}
        public void setItem(int newItem) {item = newItem;}
        public void setNext(Node newNext){next = newNext;}    
    }

    public static class SinglyLinkedList{
        protected Node head;
        private int size;
        public SinglyLinkedList(){
            head = null;
            size = 0;
        }
        public void insertLast(int newItem){
            if (head == null) {
                head = new Node(newItem, null);
            }
            else{
                Node p = head;
                while(p.getNext() != null){
                    p = p.getNext();
                }
                p.setNext(new Node(newItem, null));
                size++;
            }
        }
        public void printAll(){
            Node p = head;
            while(p != null){
                System.out.print(p.getItem()+" ");
                p = p.getNext();
            }
            System.out.println();
        }
        public void reverse(){
            Node p = reLink(head);
            p.setNext(null);
        }
        private Node reLink(Node current) {
            if (current.getNext() != null) { // not last node
                Node next = reLink(current.getNext()); // all next are done
                next.setNext(current);
            }
            else {
                head = current;
            }
            return current;
        }
    }
}