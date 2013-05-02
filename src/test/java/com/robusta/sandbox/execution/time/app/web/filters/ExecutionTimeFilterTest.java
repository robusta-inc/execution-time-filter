package com.robusta.sandbox.execution.time.app.web.filters;

import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExecutionTimeFilterTest {
    private ExecutionTimeFilter filter;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain chain;
    private File logFile;

    @Before
    public void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        chain = mock(FilterChain.class);

        logFile = new File("execution-time-test.log");
        if(logFile.exists()) {
            assertThat(logFile.delete(), is(true));
        }
        logFile.deleteOnExit();
        filter = new ExecutionTimeFilter();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDoFilter() throws Exception {
        when(request.getServletPath()).thenReturn("/something/path.html");
        when(request.getMethod()).thenReturn("POST");
        filter.doFilter(request, response, chain);
        verifyThatLogMessageIsPostedToLogFile();
    }

    private void verifyThatLogMessageIsPostedToLogFile() throws IOException {
        List<String> content = Resources.readLines(logFile.toURI().toURL(), Charset.defaultCharset());
        assertThat(content, hasItem(containsString("INFO EXECUTION_TIME:27 - Request: '/something/path.html' with method: 'POST' took ")));
    }
}
