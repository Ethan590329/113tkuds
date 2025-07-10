public class GradeProcessor {
    public static void main(String[] args) {
        // 1. 建立一個包含 8 位學生成績的陣列
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        // 2. 計算總分與平均分數（保留兩位小數）
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        double average = (double) total / grades.length;
        System.out.printf("總分: %d\n", total);
        System.out.printf("平均: %.2f\n", average);

        // 3. 找出最高分與最低分，並顯示其索引位置
        int max = grades[0], min = grades[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }
            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }
        System.out.printf("最高分: %d（索引: %d）\n", max, maxIndex);
        System.out.printf("最低分: %d（索引: %d）\n", min, minIndex);

        // 4. 計算成績超過平均的人數
        int countAboveAvg = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAvg++;
            }
        }
        System.out.println("超過平均分數的學生人數: " + countAboveAvg);

        // 5. 輸出所有成績（格式：學生編號: 成績）
        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生編號" + i + ": " + grades[i]);
        }
    }
}

