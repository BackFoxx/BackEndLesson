package com.example.advanced2.app.v5;

import com.example.advanced2.trace.callback.TraceCallback;
import com.example.advanced2.trace.callback.TraceTemplate;
import com.example.advanced2.trace.logtrace.LogTrace;
import com.example.advanced2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/* 템플릿 메서드 패턴 */

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return this.template.execute("OrderController.request()",
                () -> {
                    orderService.orderItem(itemId);
                    return "ok";
                });
    }
}
