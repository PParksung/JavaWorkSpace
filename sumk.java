
public class sumk {
    public static void main(String[] args) {
        

        int [] arr = new int[]{1,2,3,4,5,6};
        int k = 7;

        int start = 0;
        int end = arr.length-1;
        int sum = 0;
        while(start<end){
                sum = arr[start]+arr[end];
                if(sum==k){
                    System.out.printf("%d + %d = %d\n", arr[start], arr[end], k);
                    start++;
                    end--;
                }
                else if(sum>k){
                    end--;
                }
                else{
                    start ++;
                }

        }
    }
}
