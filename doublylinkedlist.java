import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class doublylinkedlist {
    public static void main(String[] args) {
        try{
        	File file = new File("input.txt");
        	FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        
        	String line = br.readLine();

        	while (line != null){
        		CDList lst = new CDList();
        		String [] str = line.split(" ");
        		for(int i=0; i<str.length; i++){
        			switch(str[i]){
        				case "i":
        					i++;
        					while(i<str.length && !str[i].equals("d")) {
        						lst.insert(Integer.parseInt(str[i]));
        						i++;
        					}
        					i--;
        					break;
        				case "d":
        					lst.delete();
        					break;
        			}
        		}	
            	lst.printall();
        		line = br.readLine();
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }


    }
    public static class CDList{
        protected DNode head;
        protected int size;

        public CDList(){
            head = new DNode(null, null, null);
            head.setPrevious(head);
            head.setNext(head);
            size = 0;
        }
        void insert(int newItem) {
        	DNode newNode = new DNode(newItem, null, null);
            newNode.setNext(head.getNext());
            newNode.setPrevious(head);
            head.getNext().setPrevious(newNode);
            head.setNext(newNode);
            size++;
        }
       
        public void delete(){
    		DNode deleteNode = head.getPrevious();
        	if(deleteNode != head) { // Not Empty
        		DNode connectNode = deleteNode.getPrevious();
        		connectNode.setNext(head); 
                head.setPrevious(connectNode);
                size--; 
        	}
        }
        void printall(){
            DNode p = head.getNext();
            while(p != head){
                System.out.print(p.getData()+" ");
                p = p.getNext();
            }
            System.out.println();
        }
    }
   
    public static class DNode{
        private Integer data;
        private DNode previous;
        private DNode next;

        public DNode(Integer data, DNode p, DNode q){
            this.data = data;
            this.previous = p;
            this.next = q;
        }
        public int getData(){
            return this.data;
        }
        public DNode getNext(){
            return this.next;
        }
        public DNode getPrevious(){
            return this.previous;
        }
        public void setPrevious(DNode p){
            this.previous = p;
        }
        public void setNext(DNode q){
            this.next = q;
        }
        public void setData(int newData){
            this.data = newData;
        }

    }

    
}
