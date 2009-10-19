0) If errors, perform Maven > Update Dependencies for service and client.

1) Verify that you are using the sessionEnabledMessageService in
   HelloWorldServiceCXF/src/main/webapp/WEB-INF/applicationContext-cxf.xml

	<jaxws:endpoint id="messageService" implementor="#sessionEnabledMessageService"

   Otherwise the unit tests will fail.

2) Start HelloWorldServiceCXF using Run As... > Maven build... > jetty:run (enter goal manually).

3) Generate client sources for HelloWorldClient using Run As... > Maven generate-sources.

4) Run As... > JUnit Test.