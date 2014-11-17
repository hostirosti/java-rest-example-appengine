package hostirosti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import hostirosti.ApiInfo;
import hostirosti.HelloWorld;
import hostirosti.JavaRESTExample;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.core.Response;

@RunWith(JUnit4.class)
public class JavaRESTExampleTest extends JavaRESTExampleTestBase {
    JavaRESTExample jre = new JavaRESTExample();
    Gson gson = new Gson();

    @Test
    public void testGetApiInfo() {
        Response response = jre.getApiInfo();
        ApiInfo apiInfo = gson.fromJson((String)response.getEntity(), ApiInfo.class);

        assertEquals(new ApiInfo(), apiInfo);
    }


    @Test
    public void testHelloWorld() {
        Response response = jre.getHelloWorld();

        HelloWorld helloWorld = gson.fromJson((String)response.getEntity(), HelloWorld.class);

        assertEquals(new HelloWorld(), helloWorld);

    }

}
