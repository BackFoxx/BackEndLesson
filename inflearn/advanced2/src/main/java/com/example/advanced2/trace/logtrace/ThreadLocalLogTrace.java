package com.example.advanced2.trace.logtrace;

import com.example.advanced2.trace.TraceId;
import com.example.advanced2.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();
    /* 동시성 문제 해결 */

    @Override
    public TraceStatus begin(String message) {
        this.syncTraceId();
        TraceId traceId = this.traceIdHolder.get();
        long startTimeMs = System.currentTimeMillis();

        log.info("[{}] {}{}", traceId.getId(),
                this.addSpace(START_PREFIX, traceId.getLevel()),
                message);

        return new TraceStatus(traceId, startTimeMs, message);
    }

    private void syncTraceId() {
        TraceId traceId = this.traceIdHolder.get();
        if (traceId == null) {
            this.traceIdHolder.set(new TraceId());
        } else {
            this.traceIdHolder.set(traceId.createNextId());
        }
    }

    @Override
    public void end(TraceStatus status) {
        this.complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        this.complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()),
                    status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()),
                    status.getMessage(),
                    resultTimeMs,
                    e.toString());
        }

        this.releaseTraceId();
    }

    private void releaseTraceId() {
        TraceId traceId = this.traceIdHolder.get();
        if (traceId.isFirstLevel()) {
            this.traceIdHolder.remove(); /* 제거 */
        } else {
            this.traceIdHolder.set(traceId.createPreviousId());
        }
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
