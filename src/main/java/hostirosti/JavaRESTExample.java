package hostirosti;

import com.google.gson.Gson;

import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

/**
 * @author hostirosti
 */
@Path("/")
public class JavaRESTExample {

    /**
     * REST API endpoint to get API information per HTTP GET.
     * @return Response with ApiInfo object and status code HTTP_OK
     */
    @GET
    @Path("/get-api-info")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response getApiInfo() {
        Gson gson = new Gson();
        return Response.status(OK).entity(gson.toJson(new ApiInfo())).build();
    }

    /**
     * REST API endpoint to get Hello World per HTTP GET.
     * @return Response with HelloWorld object and status code HTTP_OK
     */
    @GET
    @Path(Constants.API_PREFIX + Constants.API_VERSION + "/hello-world")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response getHelloWorld() {
        Gson gson = new Gson();
        return Response.status(OK)
                .entity(gson.toJson(new HelloWorld())).build();
    }
}
