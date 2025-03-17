import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class postfixNotation {
    
    public static ArrayList<String> readFile(String filename) {
        ArrayList<String> Lines = null;
        try{
            String path = "";
            FileReader FileReader = new FileReader(path+filename);
            BufferedReader buffReader = new BufferedReader(FileReader);
            
            String line = "";
            Lines = new ArrayList<String>();
            while((line = buffReader.readLine())!= null ){
                Lines.add(line);
            }
    
            buffReader.close();
            FileReader.close();
        }
        catch(Exception e){}
        return Lines;
    }

    static int out_priority(String input){
        if(input.equals("+")||input.equals("-")) {
        	return 2;
        }
        else if(input.equals("*")||input.equals("/")) {
        	return 3;
        }
        else if(input.equals("(")) {
        	return 4;
        }
        return 0;
    }
    static int in_priority(String input){
    	if(input.equals("+")||input.equals("-")) {
        	return 2;
        }
        else if(input.equals("*")||input.equals("/")) {
        	return 3;
        }
        else if(input.equals("(")) {
        	return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        ArrayList <String> Lines = readFile("input.txt");

        for(String Line : Lines){
            ListStack<String> stack = new ListStack<String>();
            StringTokenizer parser = new StringTokenizer(Line, " ");

            while(parser.hasMoreTokens()){
                String token = parser.nextToken();

                //토큰이 연산자인 경우 스택에 삽입
                if("+ - * / (".contains(token)){
                	if(stack.isEmpty()) {
                		stack.push(token);
                	}
                	else {
                		if(in_priority(stack.peek())<=out_priority(token)) {
                			stack.push(token);
                		}
                		else{
                			System.out.print(stack.pop()+" ");
                			stack.push(token);
                		}
                	}
                }
                // ) 우측 괄호 연산자 만났을 때
                else if(token.equals(")")){
                    while(!stack.isEmpty()){
                        if(stack.peek().equals("(")) {
                            stack.pop();
                            break;
                        } else {
                            System.out.print(stack.pop() + " ");
                        }
                    }
                }

                //피연산자 만났을 때
                else{
                	System.out.print(token + " ");
                }
            }

                while (!stack.isEmpty()){
                    System.out.print(stack.pop() + " ");    
                }
                System.out.println();
            }
        }
    }
