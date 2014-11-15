package hostirosti;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

@Path("/")
public class JavaRESTExample {

    @GET
    @Path("/get_api_info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApiInfo() {
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(new ApiInfo())).build();
    }

    @GET
    @Path(Constants.API_PREFIX + Constants.API_VERSION +"/hello_world")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelloWorld() {
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(new HelloWorld())).build();
    }

}
