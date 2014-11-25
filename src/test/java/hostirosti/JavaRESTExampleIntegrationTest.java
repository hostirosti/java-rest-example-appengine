package hostirosti;

import static com.eclipsesource.restfuse.Assert.*;
import static org.junit.Assert.assertTrue;

import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;

import com.eclipsesource.restfuse.annotation.HttpTest;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith( HttpJUnitRunner.class )
public class JavaRESTExampleIntegrationTest extends JavaRESTExampleTestBase {

    /**
     * Construct destination url from environment variables.
     * @return destination url
     */
    public String getDestinationFromEnvironment() {

        // get protocol, default http
        String protocol = System.getenv("TESTSERVER_ENDPOINT_PROTOCOL");
        protocol = (protocol == null || protocol.length() == 0) ? "http" : protocol;

        // get host, default localhost
        String host = System.getenv("TESTSERVER_ENDPOINT_HOST");
        host = (host == null || host.length() == 0) ? "localhost" : host;

        // get port, default 8080
        String port = System.getenv("TESTSERVER_ENDPOINT_PORT");
        port = (port == null || port.length() == 0) ? "8080" : port;

        TEST_RESULTS_LOGGER.info("Destination URL: " + protocol + "://" + host + ":" + port);
        return protocol + "://" + host + ":" + port;
    }

    @Rule
    public Destination endpoint = new Destination(this, getDestinationFromEnvironment());

    @Context
    private Response response;

    @HttpTest(method = Method.GET, path = "/get-api-info")
    public void checkApiInfoResponse() {
        assertOk(response);

        String jsonResponse = response.getBody();

        assertTrue(jsonResponse.contains(Constants.API_PREFIX));
        assertTrue(jsonResponse.contains(Constants.API_VERSION));

        Gson gson = new Gson();

        ApiInfo apiInfo = gson.fromJson(jsonResponse, ApiInfo.class);

        Assert.assertEquals(apiInfo, new ApiInfo());
    }

    @HttpTest(method = Method.GET, path = Constants.API_PREFIX + Constants.API_VERSION +"/hello-world")
    public void checkHelloWorldResponse() {
        assertOk(response);

        String jsonResponse = response.getBody();

        assertTrue(jsonResponse.contains("Hello Googlers! :)"));
        assertTrue(jsonResponse.contains("helloWorld"));

        Gson gson = new Gson();
        HelloWorld helloWord = gson.fromJson(jsonResponse, HelloWorld.class);

        Assert.assertEquals(helloWord, new HelloWorld());
    }

    @HttpTest(method = Method.GET, path = Constants.API_PREFIX + Constants.API_VERSION +"/marriage-proposal")
    public void checkMarriageProposalResponse() {
        assertOk(response);

        String jsonResponse = response.getBody();

        assertTrue(jsonResponse.contains("question"));
        assertTrue(jsonResponse.contains("JenkinsCI"));
        assertTrue(jsonResponse.contains("GitHub"));
        assertTrue(jsonResponse.contains("Google"));

        Gson gson = new Gson();
        MarriageProposal marriageProposal = gson.fromJson(jsonResponse, MarriageProposal.class);

        Assert.assertEquals(marriageProposal, new MarriageProposal());
    }
}
