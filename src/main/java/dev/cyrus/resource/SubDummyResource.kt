@file:Suppress("UnresolvedRestParam")

package dev.cyrus.resource

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("/")
class SubDummyResource {
    @GET
    fun subDummy(@PathParam("id") id: Int)= id.toShort()
}