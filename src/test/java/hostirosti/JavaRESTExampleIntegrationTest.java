package hostirosti;

import static com.eclipsesource.restfuse.Assert.*;

import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;

import com.eclipsesource.restfuse.annotation.HttpTest;
import com.google.gson.Gson;
import hostirosti.HelloWorld;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith( HttpJUnitRunner.class )
public class JavaRESTExampleIntegrationTest {

    /**
     * Construct destination url from environment variables.
     * @return destination url
     */
    public String getDestinationFromEnvironment() {

        // get protocol, default http
        String protocol = System.getenv("TESTSERVER_ENDPOINT_PROTOCOL");
        protocol = protocol == null ? "http" : protocol;

        // get host, default localhost
        String host = System.getenv("TESTSERVER_ENDPOINT_HOST");
        host = host == null ? "localhost" : host;

        // get port, default 8080
        String port = System.getenv("TESTSERVER_ENDPOINT_PORT");
        port = port == null ? "8080" : port;

        return protocol + "://" + host + ":" + port;
    }

    @Rule
    public Destination endpoint = new Destination(this, getDestinationFromEnvironment());

    @Context
    private Response response;

    @HttpTest(method = Method.GET, path = "/api/v1/hello_world")
    public void checkHelloWorldResponse() {
        assertOk(response);

        Gson gson = new Gson();
        HelloWorld helloWord = gson.fromJson(response.getBody(), HelloWorld.class);

        Assert.assertEquals(helloWord, new HelloWorld());
    }
}
