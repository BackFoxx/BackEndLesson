package com.example.advanced2.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("์ ์ฅ name={} -> nameStore={}", name, this.nameStore.get()); this.nameStore.set(name);
        sleep(1000);
        log.info("์กฐํ nameStore={}",this.nameStore.get());
        return this.nameStore.get();
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
