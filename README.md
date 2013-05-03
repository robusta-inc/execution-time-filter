A simple servlet filter that computes application request servicing performance and logs the performance metrics

1. StopWatch from apache commons-lang3 is used for computation of application performance in servicing the request.
2. SLF4J with apache commons logging is used
3. LOG name of com.robusta.sandbox.EXECUTION_TIME does INFO logging of the following:
<ul>
<li>Request Path</li>
<li>Request Method</li>
<li>Time Taken (in millis)</li>
</ul>
3. Logging is done with INFO log level and if logging level is above INFO, performance calculation is bypassed.
4. The filter code snippet is <a href="https://gist.github.com/robusta-inc/5506725">here</a>
5. A sample app that uses the Execution Time Filer and displays the logged content is <a href="http://execution-time-filter.robusta.cloudbees.net/">here</a>
