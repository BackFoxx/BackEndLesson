package 객체지향4대특성.캡슐화.packageOne;

public class ClassB {
    void runSomething() {
        /* 객체 멤버 */
//        pri = 0;
        /* 객체 생성 전에는 당연히 생성 불가 */
        ClassA classA = new ClassA();
        System.out.println(classA.pro);
        System.out.println(classA.def);
        System.out.println(classA.pub);
//        System.out.println(classA.pri);
        /* private 객체 멤버 접근 불가 */

        /* 정적 멤버 */
        System.out.println(ClassA.defStatic);
        System.out.println(ClassA.proStatic);
        System.out.println(ClassA.pubStatic);
//        System.out.println(ClassA.priStatic);
        /* private 정적 멤버 접근 불가 */
    }

    static void runStaticThing() {
        /* 객체 멤버 */
//        pri = 0;
        /* 객체 생성 전에는 당연히 생성 불가 */
        ClassA classA = new ClassA();
        System.out.println(classA.pro);
        System.out.println(classA.def);
        System.out.println(classA.pub);
//        System.out.println(classA.pri);
        /* private 객체 멤버 접근 불가 */

        /* 정적 멤버 */
        System.out.println(ClassA.defStatic);
        System.out.println(ClassA.proStatic);
        System.out.println(ClassA.pubStatic);
//        System.out.println(ClassA.priStatic);
        /* private 정적 멤버 접근 불가 */
    }
}
