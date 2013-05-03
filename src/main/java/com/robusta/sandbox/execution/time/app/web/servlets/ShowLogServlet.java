package com.robusta.sandbox.execution.time.app.web.servlets;

import com.google.common.io.ByteStreams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ShowLogServlet extends HttpServlet {
    private static final String EXECUTION_TIME_LOG_FILE_NAME = "execution-time.log";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File logFile = new File(EXECUTION_TIME_LOG_FILE_NAME);
        if(logFile.exists()) {
            ByteStreams.copy(new FileInputStream(logFile), response.getOutputStream());
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Execution Time Log File could not be located.");
        }
    }
}
