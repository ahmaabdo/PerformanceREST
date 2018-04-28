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
    @Path("/{employeeId}")
    public Employee getEmployee(@PathParam("employeeId") long emp_no) {
         return empService.getEmployee(emp_no);
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
    @Path("/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(@PathParam("employeeId") long emp_no, Employee employee) {
        employee.setEmp_no(emp_no);
        return empService.updateEmployee(employee);
    }

    @DELETE
    @Path("/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeEmployee(@PathParam("employeeId") long emp_no) {
        empService.removeEmployee(emp_no);
    }

}
