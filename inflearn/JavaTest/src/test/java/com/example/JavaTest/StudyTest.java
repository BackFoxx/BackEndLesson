package com.example.JavaTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 이 클래스 내에 메서드가 하나의 인스턴드를 공유
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 테스트 메서드의 실행 순서를 정할 수 있다.
//@ExtendWith(FindSlowTestExtension.class) // Extend 클래스 적용 방법 1
class StudyTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @Test
    @Disabled
    @DisplayName("assert의 에러메시지")
        /*
         * "assert의 에러메시지는 Supplier로 작성하면 에러가 발생하지 않을 시 불필요한 문자열 연산을 하지 않는다"
         * */
    void create() {
        Study study = new Study();
        assertNotNull(study);
        // Expected, Actual 순서
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면 상태값이 DRAFT 여야 한다.");
    }

    @Test
    @Disabled
    @DisplayName("assertAll")
    void create2() {
        Study study = new Study(-10);

        assertAll(
            () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."),
            () -> assertTrue(study.getLimit() > 0,
                "스터디 최대 참석 가능 인원은 0보다 크다.")
        );
    }

    @Test
    @Disabled
    @DisplayName("assertThrows")
    void create3() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야 합니다", message);
    }

    @Test
    @Disabled
    @DisplayName("assertTimeOut")
    void create4() {
//        assertTimeout(Duration.ofMillis(100),
//                () -> {
//                    new Study(10);
//                    Thread.sleep(1000);
//        }); // 설정한 시간만큼 실제로 기다려야 한다.

        assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> {
                    new Study(10);
                    Thread.sleep(1000);
        });
        /*
        * 테스트 코드의 실패 기준 시간만큼 기다려야 한다.
        * */
    }


    @Test
    @Disabled
    @DisplayName("assume")
    void create5() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("test_env = " + test_env);
        assumeTrue("LOCALii".equalsIgnoreCase(test_env));
        // 특정 조건을 만족 해야 그 아래의 테스트 코드가 작동, 불충족시 Disabled 처리
    }

    @Test
    @Disabled
    @DisplayName("assume2")
    @EnabledOnOs(OS.MAC) // 특정 조건(OS, JRE) 을 만족해야 작동
    void create6() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("test_env = " + test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));
    }

    @Test
    @Disabled
    @DisplayName("fastTag")
    @Tag("fast")
    void fastTest() {
        System.out.println("fast Test");
    }

    @Test
    @Disabled
    @DisplayName("slowTag")
    @Tag("slow")
    void slowTest() {
        System.out.println("slow Test");
    }

    @Disabled
    @FastTest
    void customFastTag() {
        System.out.println("fast custom test");
    }

    @Disabled
    @SlowTest
    void customSlowTest() {
        System.out.println("slow custom test");
    }

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("파라미터 테스트")
    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void parameterizedTest(String message) {
        System.out.println("message = " + message);
    }

    @DisplayName("파라미터 테스트 -> Empty & Null")
    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    @NullAndEmptySource // @EmptySource + @NullSource
    @EmptySource // 빈 문자열
    @NullSource // null
    void parameterizedTest2(String message) {
        System.out.println("message = " + message);
    }

    @Order(3)
    @DisplayName("SimpleArgumentConverter 파라미터 테스트")
    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}")
    @ValueSource(ints = {10, 20, 30})
    void parameterizedTest3(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println("message = " + study.getLimit());
    } // valueSource 인티저 값을 객체로 변환

    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @Order(2)
//    @SlowTest
    @DisplayName("CsvSource 파라미터 테스트")
    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest4(ArgumentsAccessor accessor) throws InterruptedException {
        Study study = new Study(accessor.getInteger(0), accessor.getString(1));
        System.out.println(study);
        Thread.sleep(2000L);
    } // CsvSource와 ArgumentsAccessor로 여러 타입을 파라미터로 주입

    @Order(1)
    @DisplayName("ArgumentsAggregator 파라미터 테스트")
    @ParameterizedTest(name = "{index}번 째 {displayName} : {0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest5(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    } // ArgumentsAggregator로 여러 타입을 받는 생성자로 객체를 생성

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Study(accessor.getInteger(0), accessor.getString(1));
        }
    } //static inner 클래스 또는 public 클래스로 생성해야 함



    @Disabled
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @Disabled
    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }
}
