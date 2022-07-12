package com.example.advanced2.app.v3;

import com.example.advanced2.trace.TraceStatus;
import com.example.advanced2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
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
