package anonymousInterface.v3;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReference2 {
    public static void main(String[] args) {
        String[] names = {"A", "B", "C"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }
}
