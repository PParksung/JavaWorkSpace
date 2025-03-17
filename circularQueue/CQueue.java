package circularQueue;

public class CQueue {
    protected Node rear;
    protected int size;

    public CQueue(){
        rear = null;
        size =0;
    }

    void insert(int newItem){
        Node newNode = new Node(newItem, null);
        if(rear.getNext()==null) rear = newNode;
        else rear.setNext(newNode);
        rear = newNode;
        size++;
    }

    void delete(){
        if(rear.getNext()==null){
            System.out.print("empty");
        }
        else{
            rear.setNext(rear.getNext().getNext());
            rear.getNext().setNext(null);
            if(rear.getNext()==null)
            {
                System.out.print("empty");
            }

        }
    }
}
