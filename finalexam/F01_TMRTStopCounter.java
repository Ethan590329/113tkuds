import java.util.*;
/*
 * Time Complexity: O(n)
 * 說明：讀取 n 個站點並依序存入 map 與 list 花費 O(n)；
 *      後續搜尋 start 與 end 的索引值為 HashMap 的 O(1) 操作，
 *      所以總體仍為 O(n)。
 */
public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        List<String> stops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String stop = sc.next();
            map.put(stop, i);
            stops.add(stop);
        }

        String start = sc.next();
        String end = sc.next();

        if (!map.containsKey(start) || !map.containsKey(end)) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(map.get(start) - map.get(end)) + 1;
            System.out.println(count);
        }
    }
}
