import java.util.Scanner;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        int[] count = new int[26];
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') count[c - 'a']++;
        }
        int odd = 0;
        for (int x : count) {
            if (x % 2 != 0) odd++;
        }
        System.out.println(odd <= 1 ? "Possible" : "Impossible");
    }
}

