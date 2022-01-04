import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int kg = s.nextInt();
        Logic(kg);
    }

    public static void Logic(int kg) {
        if (kg % 5 != 0 && kg % 3 != 0) {
            Three(kg, 0);
        } else {
            int Three = ThreeFirst(kg);
            int Five = FiveFirst(kg);
            System.out.println(Three > Five ? Five : Three);
        }
    }

    public static int ThreeFirst(int kg) {
        int count = 0;
        count += kg / 3;
        kg = kg % 3;
        count += kg / 5;
        kg = kg % 5;
        if (kg != 0) {
            count = 10000;
        }
        return count;
    }

    public static int FiveFirst(int kg) {
        int count = 0;
        count += kg / 5;
        kg = kg % 5;
        count += kg / 3;
        kg = kg % 3;
        if (kg != 0) {
            count = 10000;
        }
        return count;
    }


    public static void Three(int kg, int count) {
        int Count = count;
        kg -= 3;
        if (kg < 0) {
            System.out.println(-1);
            return;
        } else if (kg == 0) {
            ++Count;
            System.out.println(Count);
            return;
        } else if (kg < 5) {
            ++Count;
            Three(kg, Count);
        } else {
            ++Count;
            Five(kg, Count);
        }
    }

    public static void Five(int kg, int count) {
        int Count = count;
        kg -= 5;
        if (kg < 0) {
            System.out.println(-1);
            return;
        } else if (kg == 0) {
            ++Count;
            System.out.println(Count);
            return;
        } else {
            ++Count;
            Three(kg, Count);
        }
    }


}
