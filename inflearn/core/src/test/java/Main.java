import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

//        //test
//        int count = 0;
//        int 로직결과 = 0;
//        for (int i = 0; i < 30000; ++i) {
//            int result = Logic(i);
//            if (로직결과 == result) {
//                ++count;
//            } else {
//                bw.write(로직결과 + " -> " + count + "\n");
//                count = 0;
//            }
//            로직결과 = result;
//        }

        for (int i = 0; i < T; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            B -= A;
            bw.write(Logic(B)+"\n");
        }

        bw.close();
    }

    public static int Logic(int B) {
        if (B == 0) {
            return 0;
        }
        if (B == 1) {
            return 1;
        }
        if (B == 2) {
            return 2;
        }

        B = B-2;

        int inputValue = 0;
        int roop = 2;
        int Result = 1;
        while (true) {
            for (int i = 0; i < 2; ++i) {
                    inputValue += roop;
                    if (inputValue >= B) {
                        return Result+2;
                    }
                ++Result;
            }
            ++roop;
        }
    }
}
