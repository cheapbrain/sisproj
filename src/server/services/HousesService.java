package server.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import beans.House;
import server.Houses;

@Path("houses")
public class HousesService {
	
	@GET
	@Produces({ "application/json" })
	public Response getList() {
		return Response.ok(Houses.instance.getList()).build();
	}
	
	@Path("add")
	@PUT
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response addHouse(House house) {
		House[] list = Houses.instance.addAndGetList(house);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}
	
	@Path("remove/{id}")
	@DELETE
	public Response removeHouse(@PathParam("id") String id) {
		 if (Houses.instance.remove(id)) {
			 return Response.ok().build();
		 } else {
			 return Response.status(Response.Status.NOT_FOUND).build();
		 }

	}

}
