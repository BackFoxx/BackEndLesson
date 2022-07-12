package 객체지향4대특성.캡슐화.packageOne;

public class ClassAA extends ClassA {
    void runSomething() {
        /* 객체 멤버 */
//        System.out.println(pri);
        System.out.println(def);
        System.out.println(pro);
        System.out.println(pub);
        /* 상속받았기 때문에 객체 멤버 사용 가능. private 객체 멤버 접근 불가 */

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

//        System.out.println(pri);
//        System.out.println(def);
//        System.out.println(pro);
//        System.out.println(pub);
        /* 객체를 생성하지 않고는 객체 멤버 접근 불가 */

        ClassA classA = new ClassA();
//        classA.pri = 1;
        classA.def = 1;
        classA.pro = 1;
        classA.pub = 1;
        /* 객체 멤버를 객체 생성 후에 객체 참조 변수를 통해 접근 가능 */

        /* 정적 멤버 */

//        System.out.println(priStatic);
        System.out.println(defStatic);
        System.out.println(proStatic);
        System.out.println(pubStatic);
        /* 상속받았기 때문에 정적 멤버 접근 가능.
         * 정적 멤버는 클래스명.정적멤버 형태의 접근을 권장 */

//        classA.priStatic = 1;
        classA.defStatic = 1;
        classA.proStatic = 1;
        classA.pubStatic = 1;
        /* 객체 참조 변수를 통해 정적 멤버도 접근 가능. 권장하지 않음 */
    }
}
