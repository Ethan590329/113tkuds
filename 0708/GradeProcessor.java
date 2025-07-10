public class GradeProcessor {
    public static void main(String[] args) {

        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        double average = (double) total / grades.length;
        System.out.printf("總分: %d\n", total);
        System.out.printf("平均: %.2f\n", average);

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

        int countAboveAvg = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAvg++;
            }
        }
        System.out.println("超過平均分數的學生人數: " + countAboveAvg);

        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生編號" + i + ": " + grades[i]);
        }
    }
}

