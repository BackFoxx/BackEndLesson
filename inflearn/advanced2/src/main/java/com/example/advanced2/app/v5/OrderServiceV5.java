package com.example.advanced2.app.v5;

import com.example.advanced2.trace.callback.TraceCallback;
import com.example.advanced2.trace.callback.TraceTemplate;
import com.example.advanced2.trace.logtrace.LogTrace;
import com.example.advanced2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        this.template.execute("OrderService.orderItem()",
                () -> {
                    orderRepository.save(itemId);
                    return null;
                });
    }
}
