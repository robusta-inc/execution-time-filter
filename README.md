A simple servlet filter that computes application performance and logs the performance

1. StopWatch from apachce commons-lang3 is used for computation of application performance in servicing the request.
2. SLF4J with apache commons logging is used with a LOG name of com.robusta.sandbox.EXECUTION_TIME is used to log:
a. Request Path
b. Request Method
c. Time Taken (in millis)
3. Logging is done with INFO log level and if logging level is above INFO, performance calculation is bypassed.
