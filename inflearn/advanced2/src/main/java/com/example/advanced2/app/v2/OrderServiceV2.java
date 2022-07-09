package com.example.advanced2.app.v2;

import com.example.advanced2.trace.TraceId;
import com.example.advanced2.trace.TraceStatus;
import com.example.advanced2.trace.hellotrace.HelloTraceV1;
import com.example.advanced2.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = this.trace.beginSync(traceId, "OrderService.orderItem()");
            this.orderRepository.save(status.getTraceId(), itemId);
            this.trace.end(status);
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }
    }
}
