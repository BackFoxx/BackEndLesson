package chapter1;

import java.util.Scanner;

public class Chap_1_1 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();

//        int c = scanner.nextInt();
//        int d = scanner.nextInt();

//        for (int i = 0; i < 20; ++i) {
//            int a = (int) (Math.random() * 500 + 1);
//            int b = (int) (Math.random() * 500 + 1);
//            int c = (int) (Math.random() * 500 + 1);
//            System.out.println("a = " + a + ", b = " + b +", b = " + c);
//            System.out.println("middle = " + middle(a, b, c));
//        }
        Q13();
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }

    static int middle(int a, int b, int c) {
        if (a < b) {
            if (a < c) {
                if (b < c) return b; //a<b<c
                else return c; // a<c<b
            } else return a; //c<a<b
        }
        //a >= b
        else if ( b < c ) {
            if (a < c) return a; // b<a<c
            else return c; //b<c<a
        }
        else return b; // c<b<a
    }

    // Q5. a<b<c 처럼 1~2번의 계산으로 답을 낼 수 있는 입력도
    // 최소 5번 이상의 연산을 거쳐야 하기 때문에 효율이 떨어진다.

    static void Q6(int a) {
        int sum = 0;
        int i = 1;

        while (i <= a) {
            sum += i;
            ++i;
        }

        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
    }

    static String Q7(int n) {
        int sum = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sum += i;
            builder.append(i).append(" + ");
        }
        return builder.substring(0, builder.length() - 3) + " = " + sum;
    }

    static int Q8(int n) {
        return (n * (n + 1)) / 2;
    }

    static int sumof(int a, int b) {
        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }

    static int Q10(Scanner scanner) {
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        while (b <= a) {
            System.out.println("a보다 큰 값을 입력하세요!");
            b = scanner.nextInt();
        }

        return b - a;
    }

    static void Q11() {
        Scanner scanner = new Scanner(System.in);
        int a;
        do {
            a = scanner.nextInt();
        } while (a <= 0);

        int result = 1;
        while (a / 10 != 0) {
            a /= 10;
            ++result;
        }

        System.out.println("그 수는 " + result + "자리입니다.");
    }

    static void Q12() {
        System.out.println("  | 1  2  3  4  5  6  7  8  9");
        System.out.println("--+--------------------------");
        for (int i = 1; i <= 9; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + " |");
            for (int j = 1; j <= 9; j++) {
                stringBuilder.append(" " + i * j);
                if (i * j < 10) {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    static void Q13() {
        System.out.println("  | 1  2  3  4  5  6  7  8  9");
        System.out.println("--+--------------------------");
        for (int i = 1; i <= 9; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + " |");
            for (int j = 1; j <= 9; j++) {
                int sum = i + j;
                stringBuilder.append(" " + sum);
                if (sum < 10) {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    static void Q14() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("사각형을 출력합니다.");
        System.out.println("단 수: ");
        for (int i = 0; i < scanner.nextInt(); i++) {

        }
    }
}
