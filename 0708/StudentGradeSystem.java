public class StudentGradeSystem {

    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    public static void main(String[] args) {

        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];

        int countA = 0, countB = 0, countC = 0, countD = 0;
        int total = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            char grade = getGrade(score);
            grades[i] = grade;

            total += score;

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }

            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }
        }

        double average = (double) total / scores.length;

        int aboveAvgCount = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAvgCount++;
            }
        }
        double aboveAvgRate = (double) aboveAvgCount / scores.length * 100;

        System.out.println("======= 學生成績分析報告 =======");
        System.out.println("總人數: " + scores.length);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + max + "（學生編號: " + maxIndex + "）");
        System.out.println("最低分: " + min + "（學生編號: " + minIndex + "）");
        System.out.println("等級統計：");
        System.out.println("A 等: " + countA + " 人");
        System.out.println("B 等: " + countB + " 人");
        System.out.println("C 等: " + countC + " 人");
        System.out.println("D 等: " + countD + " 人");
        System.out.printf("高於平均分數的學生比例: %.2f%%\n", aboveAvgRate);

        System.out.println("\n------ 學生詳細列表 ------");
        System.out.println("編號\t分數\t等級");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "\t" + scores[i] + "\t" + grades[i]);
        }
    }
}

