package com.robusta.sandbox.execution.time.app.web.filters;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ExecutionTimeFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.robusta.sandbox.EXECUTION_TIME");
    private static final boolean executionTimeCaptureEnabled = LOGGER.isInfoEnabled();
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        StopWatch stopWatch = null;
        if(executionTimeCaptureEnabled) {
            stopWatch = new StopWatch();
            stopWatch.start();
        }
        chain.doFilter(request, response);
        if(executionTimeCaptureEnabled) {
            stopWatch.stop();
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            LOGGER.info("Request: '{}' with method: '{}' took '{}' ms to complete", servletRequest.getServletPath(), servletRequest.getMethod(), stopWatch.getTime());
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
