import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int totalTime = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i];
            totalTime += sum;
        }

        System.out.println(totalTime);

        sc.close();
    }
}
