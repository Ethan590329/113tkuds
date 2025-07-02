import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int key = scanner.nextInt();

        int ops = 0;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            ops++;
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(ops);

        scanner.close();
    }
}

