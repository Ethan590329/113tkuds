
import java.util.Scanner;

public class ds_03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = input.nextLine();

        System.out.print("請輸入年齡：");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("請輸入城市：");
        String city = input.nextLine();

        System.out.println("\n=== 個人資訊 ===");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("城市：" + city);

        input.close();
    }
}
