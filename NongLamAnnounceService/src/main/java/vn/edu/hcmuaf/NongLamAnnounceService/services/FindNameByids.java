package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.IdsDAO;

@Path("/findname")
public class FindNameByids {

	@Path("/{type}/{value}")
	@GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String getName(@PathParam("type")String type, @PathParam("value")String value) {
		return IdsDAO.getName(type, value);
	}
}
