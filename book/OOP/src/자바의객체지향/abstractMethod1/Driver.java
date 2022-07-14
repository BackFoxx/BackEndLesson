package 자바의객체지향.abstractMethod1;

public class Driver {
    public static void main(String[] args) {
        System.out.println("메인 메서드 시작..!");
        동물[] 동물들 = new 동물[3];

        동물들[0] = new 쥐();
        동물들[1] = new 고양이();
        동물들[2] = new 병아리();

        for (int i = 0; i < 동물들.length; i++) {
            동물들[i].울어보세요();
        }
    }
}
