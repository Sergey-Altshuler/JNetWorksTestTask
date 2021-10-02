package com.altshuler.JnetWorksTestTask.restApp;

import com.altshuler.JnetWorksTestTask.entity.AnswerEntity;
import com.altshuler.JnetWorksTestTask.parser.PageParser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reducedPageNumbers")
public class ApiRequest {
    private final PageParser pageParser = new PageParser();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimplifiedList(@DefaultValue ("default") @QueryParam("rawPageNumbers") String rawPageNumbers) {
        if (rawPageNumbers.equals("default")) return Response.status(Response.Status.BAD_REQUEST).build();
        String answer = pageParser.parseToReducedForm(rawPageNumbers);
        if (answer == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            AnswerEntity answerEntity = new AnswerEntity(rawPageNumbers, answer);
            return Response.status(Response.Status.OK).entity(answerEntity).build();
        }
    }
}
