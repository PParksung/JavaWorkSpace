import java.util.EmptyStackException;

public class stackReverse {
    
    public static void main(String[] args) {
        int size = 50;
        String s = "I go to school";
        ArrayStack <Character> A = new ArrayStack <Character>(size);
        
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c != ' '){//공백이 아니라면
                A.push(c);
            }else{//공백이라면 pop
                while(!A.isEmpty()){
                    System.out.print(A.pop());
                }
                System.out.print(" ");
            }
        }

        while(!A.isEmpty()){
            System.out.print(A.pop());
        }
    }
}
