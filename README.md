A simple servlet filter that computes application request servicing performance and logs the performance metrics

1. StopWatch from apache commons-lang3 is used for computation of application performance in servicing the request.
2. SLF4J with apache commons logging is used with a LOG name of com.robusta.sandbox.EXECUTION_TIME is used to log:
<ol>
<li>Request Path</li>
<li>Request Method</li>
<li>Time Taken (in millis)</li>
</ol>
3. Logging is done with INFO log level and if logging level is above INFO, performance calculation is bypassed.

Sample Log File
===================================================================================================================
02 May 2013 18:52:06,690 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/' with method: 'GET' took '29' ms
02 May 2013 18:52:10,572 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/wait' with method: 'POST' took '18' ms
02 May 2013 18:52:33,156 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/wait' with method: 'POST' took '1003' ms
02 May 2013 18:52:33,246 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/index.html' with method: 'GET' took '1' ms
02 May 2013 18:53:09,654 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/wait' with method: 'POST' took '10010' ms
02 May 2013 18:53:09,679 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/index.html' with method: 'GET' took '3' ms
02 May 2013 18:55:50,785 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/index.html' with method: 'GET' took '23' ms
02 May 2013 18:56:08,619 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/wait' with method: 'POST' took '12017' ms
02 May 2013 18:56:08,665 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/execution-time-filter/index.html' with method: 'GET' took '1' ms
02 May 2013 22:24:07,411 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/' with method: 'GET' took '79' ms
02 May 2013 22:24:11,389 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/wait' with method: 'POST' took '67' ms
02 May 2013 22:24:30,310 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/wait' with method: 'POST' took '13007' ms
02 May 2013 22:24:30,319 - btpool0-0 -  INFO EXECUTION_TIME:27 - Request: '/index.html' with method: 'GET' took '1' ms
===================================================================================================================
