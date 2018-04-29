package com.ahmad.performance.resources;

import com.ahmad.performance.models.Performance;
import com.ahmad.performance.services.PerformanceService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/performances")
public class PerformanceResource {

    PerformanceService perfService = new PerformanceService();

    /**
     * Getting all messages
     *
     * @return message as a String
     * @see Produces An Annotate the specifying response format
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Performance> getAllPerformance() {
        return perfService.getAllPerformance();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{employeeUserName}")
    public Performance getPerformance(@PathParam("employeeUserName")  String username) {
        return perfService.getPerformance(username);
    }

    /**
     * Adding Message
     *
     * @return message as a String
     * @see Produces An Annotate the specifying response format
     * @see Consumes An Annotate to specify the expected request body format
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Performance addPerformance(Performance per) {
        return perfService.addPerformance(per);
    }

    @PUT
    @Path("/{employeeUserName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Performance updatePerformance(@PathParam("employeeUserName") String username, Performance per) {
        per.setUsername(username);
        return perfService.updatePerformance(per);
    }

    @DELETE
    @Path("/{employeeUserName}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removePerformance(@PathParam("employeeUserName") String username) {
        perfService.removePerformance(username);
    }


}
