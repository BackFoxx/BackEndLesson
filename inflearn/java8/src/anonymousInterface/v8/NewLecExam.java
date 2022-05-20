package anonymousInterface.v8;

public class NewLecExam {
    private int kor;
    private int eng;
    private int math;
    private int com;

    public NewLecExam() {
    }

    public NewLecExam(int kor, int eng, int math, int com) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.com = com;
    }

    public int total() {
        int result = kor + eng + math + com;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public float avg() {
        float result = total() / 4.0f;
        return result;
    }

    public String test(String bob, String momo) {
        return bob + " and " + momo;
    }
}
