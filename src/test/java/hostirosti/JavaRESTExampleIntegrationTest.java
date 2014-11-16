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

    @Rule
    public Destination endpoint = new Destination( this, "http://localhost:8080" );

    @Context
    private Response response;

    @HttpTest( method = Method.GET, path = "/api/v1/hello_world" )
    public void checkHelloWorldResponse() {
        assertOk(response);

        Gson gson = new Gson();
        HelloWorld helloWord = gson.fromJson(response.getBody(), HelloWorld.class);

        Assert.assertEquals(helloWord, new HelloWorld());
    }
}
