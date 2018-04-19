package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import vn.edu.hcmuaf.NongLamAnnounceService.dao.GroupDAO;

@Path("/group")
public class GroupServices {

	@POST
	@Path("/join/{class_id}/{id}")
	@Produces("application/json; charset=UTF-8")
	public String joinGroup(@PathParam("class_id")String class_id, @PathParam("id")String id) {
		return GroupDAO.joinGroup(class_id, id) ? "Đăng ký vào group " + class_id + " thành công"
				: "Đăng ký vào group " + class_id + " thất bại";
	}
}
