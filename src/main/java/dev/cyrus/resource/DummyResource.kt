package dev.cyrus.resource

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/dummy")
@Produces(MediaType.TEXT_PLAIN)
class DummyResource {
    @GET
    fun getDummy() = "Dummy"

    @Path("/{id}")
    fun getSubDummy() = SubDummyResource()
}