import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int sum = 0;
        int ops = 0;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            sum += num;
            ops++; 
        }

        System.out.println(sum);
        System.out.println(ops);

        scanner.close();
    }
}

