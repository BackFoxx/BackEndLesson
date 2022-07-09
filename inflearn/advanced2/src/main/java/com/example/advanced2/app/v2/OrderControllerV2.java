package com.example.advanced2.app.v2;

import com.example.advanced2.trace.TraceStatus;
import com.example.advanced2.trace.hellotrace.HelloTraceV1;
import com.example.advanced2.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = this.trace.begin("OrderController.request()");
            this.orderService.orderItem(status.getTraceId(), itemId);
            this.trace.end(status);
            return "ok";
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }

    }
}
