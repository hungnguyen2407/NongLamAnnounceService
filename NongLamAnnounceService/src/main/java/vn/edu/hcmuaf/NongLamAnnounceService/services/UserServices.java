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

	String id = UserServices.class.getAnnotation(Path.class).value();
	String pass = UserServices.class.getAnnotation(Path.class).value();
	
	@GET
	@Path("/login")
	@Produces("application/json; charset=UTF-8")
	public boolean login() {
		return UserDAO.login(id, pass);
	}
	
	@GET
	@Path("/dsgroup/{id}")
	@Produces("application/json; charset=UTF-8")
	public List<InfoGroupOfUser> getdsGroup(@PathParam("id")String id) {
		return UserDAO.getdsGroupOfUser(id);
	}
}
