package com.example.advanced2.trace.callback;

import com.example.advanced2.trace.TraceStatus;
import com.example.advanced2.trace.logtrace.LogTrace;

/* 템플릿 콜백 패턴 */
public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = this.trace.begin(message);

            /* 로직 호출 */
            T result = callback.call();

            this.trace.end(status);
            return result;
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }
    }
}
