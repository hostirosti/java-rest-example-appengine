Java REST Example for Google App Engine
=========

This is an example Java App used to showcase the CI Boilerplate setup found at
[ci-boilerplate](https://github.com/hostirosti/ci-boilerplate).

The Maven pom for build and test is setup to support
* static code analyses (DRY, PMD, FindBugs, Warnings)
* unit testing with JUnit
* integration testing on local test server
* integration testing against app deployed on Google App Engine
* JMeter performance testing
* code coverage using Emma

## Setup for local build and test
Before you run the Maven script you have to setup the GAE project id and version. Copy the
```gae.properties.example``` file and rename it to ```gae.properties```.
Afterwards edit ```gae.properties``` and replace the placeholders with your project id and version.
```
gae_project_id=example-app
gae_project_version=1
```

## JMeter setup
The JMeter test plans are located at ```src/non-packaged-resources/jmeter```.
The test plans contain placeholder variables e.g. ```${testserver.endpoint.host}``` for
```protocol```, ```host``` and ```port``` that are replaced during the execution of the maven
 script with values where the app is running.

These values are taken from the following environment variables:
```TESTSERVER_ENDPOINT_PROTOCOL```, ```TESTSERVER_ENDPOINT_HOST``` and  ```TESTSERVER_ENDPOINT_PORT```.

To set these variables for local testing do on the cmd where you run the Maven script:
```
 $ export TESTSERVER_ENDPOINT_PROTOCOL='http'
 $ export TESTSERVER_ENDPOINT_HOST=example-app.appspot.com
 $ export TESTSERVER_ENDPOINT_PORT=80

```

If you want to run JMeter against your local instance you have to first set the environment variables
```
 $ export TESTSERVER_ENDPOINT_PROTOCOL='http'
 $ export TESTSERVER_ENDPOINT_HOST=localhost
 $ export TESTSERVER_ENDPOINT_PORT=8181
```
then start the local test server ```mvn appengine:devserver_start```, run the jmeter
tests with ```mvn generate-test-resources jmeter:jmeter```
and afterwards stop the test server with ```mvn appengine:devserver_stop```

The port ```8181``` is taken from the ```testserver.endpoint.port``` property value in your pom.