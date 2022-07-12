package com.example.advanced2.trace.strategy;

import com.example.advanced2.trace.strategy.code.ContextV1;
import com.example.advanced2.trace.strategy.code.strategy.Strategy;
import com.example.advanced2.trace.strategy.code.strategy.StrategyLogic1;
import com.example.advanced2.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StrategyTest {
    @Test
    void templateMethodV0() {
        this.logic1();
        this.logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        /* 비즈니스 로직 실행 */
        log.info("비즈니스 로직1 실행");
        /* 비즈니스 로직 종료 */
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        /* 비즈니스 로직 실행 */
        log.info("비즈니스 로직2 실행");
        /* 비즈니스 로직 종료 */
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void strategyV1() {
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        Strategy strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = () -> log.info("비즈니스 로직1 실행");
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        Strategy strategyLogic2 = () -> log.info("비즈니스 로직2 실행");
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }
}
