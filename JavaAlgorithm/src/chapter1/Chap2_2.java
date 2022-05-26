package chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Chap2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] ints = new int[num];

        show(ints);
        for (int i = 0; i < num / 2; i++) {
            switchArr(ints, i, num);
            show(ints);
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    private static void show(int[] ints) {
        Arrays.stream(ints).forEach(integer -> System.out.println(integer + " "));
    }

    public static void switchArr(int[] ints, int i, int num) {
        int t = ints[i];
        ints[i] = ints[num - i - 1];
        ints[num - i - 1] = t;
    }
}
