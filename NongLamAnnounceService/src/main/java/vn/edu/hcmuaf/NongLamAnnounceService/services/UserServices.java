package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;

@Path("/user")
public class UserServices {

	String id = UserServices.class.getAnnotation(Path.class).value();
	String pass = UserServices.class.getAnnotation(Path.class).value();
	
	@GET
	@Path("/check")
	@Produces("application/json; charset=UTF-8")
	public boolean checkUser() {
		return UserDAO.checkUser(id, pass);
	}
}
