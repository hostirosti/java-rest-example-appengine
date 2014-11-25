package hostirosti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@RunWith(JUnit4.class)
public class JavaRESTExampleTest extends JavaRESTExampleTestBase {
    JavaRESTExample jre = new JavaRESTExample();
    Gson gson = new Gson();

    /**
     * Test ApiInfo API Response content
     */
    @Test
    public void testGetApiInfo() {
        Response response = jre.getApiInfo();
        String jsonResponse = (String)response.getEntity();

        assertTrue(jsonResponse.contains(Constants.API_PREFIX));
        assertTrue(jsonResponse.contains(Constants.API_VERSION));

        ApiInfo apiInfo = gson.fromJson(jsonResponse, ApiInfo.class);

        assertEquals(new ApiInfo(), apiInfo);
    }


    /**
     * Test ApiInfo hashCode function
     */
    @Test
    public void testApiInfoHashCode() {
        ApiInfo apiInfo = new ApiInfo();

        assertEquals(apiInfo.hashCode(),
                new HashCodeBuilder(29, 83).
                        append(Constants.API_PREFIX).
                        append(Constants.API_VERSION).
                        toHashCode());
    }


    /**
     * Test HelloWorld API Response content
     */
    @Test
    public void testGetHelloWorld() {
        Response response = jre.getHelloWorld();
        String jsonResponse = (String)response.getEntity();

        assertTrue(jsonResponse.contains("Hello Googlers! :)"));
        assertTrue(jsonResponse.contains("helloWorld"));

        HelloWorld helloWorld = gson.fromJson(jsonResponse, HelloWorld.class);

        assertEquals(new HelloWorld(), helloWorld);
    }


    /**
     * Test HelloWorld hashCode function
     */
    @Test
    public void testHelloWorldHashCode() {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals(helloWorld.hashCode(),
                new HashCodeBuilder(27, 87).
                        append("Hello Googlers! :)").
                        toHashCode());
    }


    /**
     * Test MarriageProposal API Response content
     */
    @Test
    public void testGetMarriageProposal() {
        Response response = jre.getMarriageProposal();
        String jsonResponse = (String)response.getEntity();

        assertTrue(jsonResponse.contains("question"));
        assertTrue(jsonResponse.contains("JenkinsCI"));
        assertTrue(jsonResponse.contains("GitHub"));
        assertTrue(jsonResponse.contains("Google"));

        MarriageProposal marriageProposal = gson.fromJson(jsonResponse, MarriageProposal.class);

        assertEquals(new MarriageProposal(), marriageProposal);
    }


    /**
     * Test MarriageProposal hashCode function
     */
    @Test
    public void testMarriageProposalHashCode() {
        MarriageProposal marriageProposal = new MarriageProposal();

        Map<String, String> answers = new HashMap<String, String>();
        answers.put("JenkinsCI", "I do!");
        answers.put("GitHub","Hmm,... ok I do!");
        answers.put("Google", "Is MAYBE an option?");

        assertEquals(marriageProposal.hashCode(),
                new HashCodeBuilder(33, 79).
                        append("Will you marry me?").
                        append(answers).
                        toHashCode());
    }
}
