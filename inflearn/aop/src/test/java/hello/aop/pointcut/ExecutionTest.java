package hello.aop.pointcut;

import hello.aop.order.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ExecutionTest {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method  helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        //public java.lang.String hello.aop.order.aop.member.MemberServiceImpl.hello(java.lang.String)
        log.info("helloMethod = {}", this.helloMethod);
    }

    @Test
    void exactMatch() {
        this.pointcut.setExpression("execution(public String hello.aop.order.aop.member.MemberServiceImpl.hello(String))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void allMatch() {
        this.pointcut.setExpression("execution(* *(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatch() {
        this.pointcut.setExpression("execution(* hello(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatchStar1() {
        this.pointcut.setExpression("execution(* hel*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatchStar2() {
        this.pointcut.setExpression("execution(* *el*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatchFalse() {
        this.pointcut.setExpression("execution(* nono(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isFalse();
    }

    @Test
    void packageExactMatch1() {
        this.pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberServiceImpl.hello(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageExactMatch2() {
        this.pointcut.setExpression("execution(* hello.aop.order.aop.member.*.*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageExactMatchFalse() {
        this.pointcut.setExpression("execution(* hello.aop.*.*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isFalse();
    }

    @Test
    void packageMatchSubPackage1() {
        this.pointcut.setExpression("execution(* hello.aop.order..*.*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageMatchSubPackage2() {
        this.pointcut.setExpression("execution(* hello.aop..*.*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void typeExactMatch() {
        this.pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberServiceImpl.*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void typeMatchSuperType() {
        this.pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberService.*(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void typeMatchNoSuperTypeMethodFalse() throws NoSuchMethodException {
        this.pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberService.*(..))");
        Method internalMethod = MemberServiceImpl.class.getMethod("internal", String.class);
        Assertions.assertThat(this.pointcut.matches(internalMethod, MemberServiceImpl.class)).isFalse();
    }

    //String ????????? ???????????? ??????
    @Test
    void argsMatch() {
        this.pointcut.setExpression("execution(* *(String))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    //???????????? ??????
    @Test
    void argsMatchNoArgs() {
        this.pointcut.setExpression("execution(* *())");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isFalse();
    }

    //????????? ????????? ???????????? ??????, ?????? ?????? ??????
    @Test
    void argsMatchStar() {
        this.pointcut.setExpression("execution(* *(*))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    //????????? ???????????? ?????? ???????????? ??????, ?????? ?????? ??????
    @Test
    void argsMatchAll() {
        this.pointcut.setExpression("execution(* *(..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // String ???????????? ??????, ????????? ???????????? ?????? ???????????? ??????, ?????? ?????? ??????
    @Test
    void argsMatchComplex() {
        this.pointcut.setExpression("execution(* *(String, ..))");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }
}
