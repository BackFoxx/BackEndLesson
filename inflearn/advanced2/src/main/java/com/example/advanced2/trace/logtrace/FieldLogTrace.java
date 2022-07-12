package com.example.advanced2.trace.logtrace;

import com.example.advanced2.trace.TraceId;
import com.example.advanced2.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldLogTrace implements LogTrace {
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private TraceId traceIdHolder;
    /* traceId 동기화 */

    @Override
    public TraceStatus begin(String message) {
        this.syncTraceId();
        TraceId traceId = this.traceIdHolder;
        long startTimeMs = System.currentTimeMillis();

        log.info("[{}] {}{}", traceId.getId(),
                this.addSpace(START_PREFIX, traceId.getLevel()),
                message);

        return new TraceStatus(traceId, startTimeMs, message);
    }

    private void syncTraceId() {
        if (this.traceIdHolder == null) {
            this.traceIdHolder = new TraceId();
        } else {
            this.traceIdHolder = this.traceIdHolder.createNextId();
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
        if (this.traceIdHolder.isFirstLevel()) {
            this.traceIdHolder = null;
        } else {
            this.traceIdHolder = this.traceIdHolder.createPreviousId();
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
