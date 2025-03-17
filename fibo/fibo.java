package JavaWorkSpace;

public class fibo {
    public static void main(String[] args) {
        int arr [] = new int[]{6,7};
        for(int num : arr){
            int result =fibo(num);
            System.out.println(result);
        }
    }
    //1 1 3 5 8 13
    public static int fibo(int num){
        if(num==1){
            return 1;
        }
        else if(num==2){
            return 1;
        }
        else{
            return fibo(num-1)+fibo(num-2);
        }
    }
}
