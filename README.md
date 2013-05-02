A simple servlet filter that computes application request servicing performance and logs the performance metrics

1. StopWatch from apache commons-lang3 is used for computation of application performance in servicing the request.
2. SLF4J with apache commons logging is used with a LOG name of com.robusta.sandbox.EXECUTION_TIME is used to log:
<ol>
<li>Request Path</li>
<li>Request Method</li>
<li>Time Taken (in millis)</li>
</ol>
3. Logging is done with INFO log level and if logging level is above INFO, performance calculation is bypassed.
