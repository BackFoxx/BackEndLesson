package com.example.advanced2.trace.template;

import com.example.advanced2.trace.TraceStatus;
import com.example.advanced2.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {
    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = this.trace.begin(message);

            // 로직 호출
            T result = this.call();

            this.trace.end(status);
            return result;
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
