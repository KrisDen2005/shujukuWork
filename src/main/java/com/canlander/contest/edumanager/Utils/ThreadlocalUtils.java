package com.canlander.contest.edumanager.Utils;

public class ThreadlocalUtils {
    private ThreadLocal threadLocal = new ThreadLocal();

    public <T> T getThreadLocal() {
        return (T) threadLocal.get();
    }

    public void setThreadLocal(Object data) {
        threadLocal.set(data);
    }

}
