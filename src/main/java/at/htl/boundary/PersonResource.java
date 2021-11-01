package at.htl.boundary;

import at.htl.controller.PersonRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/person")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @Inject
    Logger logger;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addPerson(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("email") String email,
            @FormParam("phoneNumber") String phoneNumber
    ) {
        personRepository.add(firstName, lastName, email, phoneNumber);
        logger.info("added new person");

        return Response.ok().build();
    }
}
