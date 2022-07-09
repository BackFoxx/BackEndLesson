package com.example.advanced2.app.v1;

import com.example.advanced2.trace.TraceStatus;
import com.example.advanced2.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = this.trace.begin("OrderController.request()");
            this.orderService.orderItem(itemId);
            this.trace.end(status);
            return "ok";
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }

    }
}
