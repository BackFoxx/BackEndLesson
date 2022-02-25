package kr.or.connect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
    public static void main(String[] args) {
        ApplicationContext ec = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("초기화 완료!!");

        UserBean userBean = (UserBean) ec.getBean("userBean");
        userBean.setName("무야호");

        System.out.println("userBean.getName() = " + userBean.getName());

        UserBean userBean2 = (UserBean) ec.getBean("userBean");

        if (userBean == userBean2) {
            System.out.println("같다");
        }
    }
}
