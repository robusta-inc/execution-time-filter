package com.robusta.sandbox.execution.time.app.web.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.common.base.Strings.isNullOrEmpty;

public class WaiterServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaiterServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.trace("Starting POSTed request in WaiterServlet");
        String secondsToWaitAsString = request.getParameter("secondsToWait");
        LOGGER.debug("SecondsToWait from Request Parameter (secondsToWait): '{}'", secondsToWaitAsString);
        if (isNullOrEmpty(secondsToWaitAsString)) {
            LOGGER.error("Null or Empty SecondsToWait from Request Parameter (secondsToWait): Sending Error - 400");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Number of seconds to wait needs to be sent in order to start waiting");
        } else {
            int secondsToWait = 0;
            try {
                secondsToWait = Integer.parseInt(secondsToWaitAsString);
                LOGGER.debug("SecondsToWait parsed as Integer: '{}'", secondsToWait);
            } catch (NumberFormatException e) {
                LOGGER.error("Number Format Exception parsing  Request Parameter (secondsToWait) : Sending Error - 400", e);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, String.format("Seconds to wait: '%s' is not acceptable. Has to be a number", secondsToWaitAsString));
            }
            if(secondsToWait > 0) {
                try {
                    LOGGER.trace("Waiter Simulation - Going to sleep for '{}' seconds", secondsToWait);
                    Thread.sleep(1000 * secondsToWait);
                    LOGGER.trace("Waiter Simulation - Done waiting '{}' seconds", secondsToWait);
                } catch (InterruptedException e) {
                    LOGGER.error("Waiting Simulation was interrupted: Sending Error - 500", e);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, String.format("Waiting was interrupted due to '%s'", e.getMessage()));
                }
                LOGGER.trace("Waiter Simulation Completed - PRG - Redirecting to index.html");
                response.sendRedirect("index.html");
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, String.format("Seconds to wait: '%s' is not acceptable. Has to be a number > 0", secondsToWaitAsString));
            }

        }
        LOGGER.trace("Done with POSTed request in WaiterServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.error("WaiterServlet GET invocation which is unsupported: Sending Error - 403");
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "POST Method is unsupported by this service");
    }
}
