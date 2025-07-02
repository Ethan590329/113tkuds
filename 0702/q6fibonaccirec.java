import java.util.Scanner;

public class q6fibonaccirec {

    static int ops = 0;

    public static int fibonacci(int n) {
        ops++; 
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int result = fibonacci(n);

        System.out.println(result);
        System.out.println(ops);

        scanner.close();
    }
}

