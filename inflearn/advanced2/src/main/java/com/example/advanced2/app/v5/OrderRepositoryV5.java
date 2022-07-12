package com.example.advanced2.app.v5;

import com.example.advanced2.trace.callback.TraceCallback;
import com.example.advanced2.trace.callback.TraceTemplate;
import com.example.advanced2.trace.logtrace.LogTrace;
import com.example.advanced2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        this.template.execute("OrderRepository.save()",
                () -> {
                    if (itemId.equals("ex")) {
                        throw new IllegalStateException("예외 발생!");
                    }
                    sleep(1000);
                    return null;
                });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
