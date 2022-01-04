package yonghan.core.singleton;

public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

    private SingleTonService() {

    }

    private void logic() {
        System.out.println("싱글톤");
    }
}
