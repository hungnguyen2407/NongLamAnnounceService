package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser;

@Path("/user")
public class UserServices {
	
	@GET
	@Path("/login/{id}/{password}")
	@Produces("application/json; charset=UTF-8")
	public String login(@PathParam("id")String id, @PathParam("password")String pass) {
		return UserDAO.login(id, pass)? "true" : "false";
	}
	
	@GET
	@Path("/dsgroup/{id}")
	@Produces("application/json; charset=UTF-8")
	public List<InfoGroupOfUser> getdsGroup(@PathParam("id")String id) {
		return UserDAO.getdsGroupOfUser(id);
	}
}
