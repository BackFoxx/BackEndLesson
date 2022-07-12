package 객체지향4대특성.캡슐화.packageOne;

public class ClassA {
    private int pri;
    int def;
    protected int pro;
    public int pub;

    private static int priStatic;
    static int defStatic;
    protected static int proStatic;
    public static int pubStatic;

    void runSomething() {
        /* 객체 멤버 */

        System.out.println(pri);
        System.out.println(def);
        System.out.println(pro);
        System.out.println(pub);

        /* 정적 멤버 */

        System.out.println(priStatic);
        System.out.println(defStatic);
        System.out.println(proStatic);
        System.out.println(pubStatic);

        /* 정적 멤버 접근 가능.
        * 클래스명.정적멤버 형태의 접근을 권장 */
    }

    static void runStaticThing() {

        /* 객체 멤버 */

//        System.out.println(pri);
//        System.out.println(def);
//        System.out.println(pro);
//        System.out.println(pub);
        /* 객체를 생성하지 않고는 객체 멤버 접근 불가 */

        ClassA classA = new ClassA();
        classA.pri = 1;
        classA.def = 1;
        classA.pro = 1;
        classA.pub = 1;
        /* 객체 멤버를 객체 생성 후에 객체 참조 변수를 통해 접근 가능 */

        /* 정적 멤버 */

        System.out.println(priStatic);
        System.out.println(defStatic);
        System.out.println(proStatic);
        System.out.println(pubStatic);
        /* 정적 멤버 접근 가능.
         * 정적 멤버는 클래스명.정적멤버 형태의 접근을 권장 */

        classA.priStatic = 1;
        classA.defStatic = 1;
        classA.proStatic = 1;
        classA.pubStatic = 1;
        /* 객체 참조 변수를 통해 정적 멤버도 접근 가능. 권장하지 않음 */
    }
}
















