package com.ahmad.performance.resources;

import com.ahmad.performance.models.Employee;
import com.ahmad.performance.services.EmployeesService;

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


@Path("/employees")
public class EmployeesResource {

    EmployeesService empService = new EmployeesService();

    /**
     * Getting all messages
     *
     * @return message as a String
     * @see Produces An Annotate the specifying response format
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{employeeUserName}")
    public Employee getEmployee(@PathParam("employeeUserName") String username) {
         return empService.getEmployee(username);
    }

    /**
     * Adding Employee
     *
     * @return message as a String
     * @see Produces An Annotate the specifying response format
     * @see Consumes An Annotate to specify the expected request body format
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee addEmployee(Employee employee) {
        return empService.addEmployee(employee);
    }

    @PUT
    @Path("/{employeeUserName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(@PathParam("employeeUserName") String username, Employee employee) {
        employee.setUsername(username);
        return empService.updateEmployee(employee);
    }

    @DELETE
    @Path("/{employeeUserName}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeEmployee(@PathParam("employeeUserName") String username) {
        empService.removeEmployee(username);
    }

}
