package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.GroupDAO;

@Path("/group")
public class GroupServices {

	/**
	 * Phương thức thêm thành viên vào group hoặc lớp
	 * 
	 * @param class_id
	 *            mã group hoặc lớp
	 * @param id
	 *            mã user
	 * @return "true" hoặc "false"
	 */
	@POST
	@Path("/join/{class_id}/{id}")
	@Produces("application/json; charset=UTF-8")
	public String joinGroup(@PathParam("class_id") String class_id, @PathParam("id") String id) {
		return GroupDAO.joinGroup(class_id, id) ? "true" : "false";
	}

	/**
	 * Phương thức rời khỏi group hoặc lớp
	 * 
	 * @param class_id
	 *            mã group hoặc lớp
	 * @param id
	 *            mã user
	 * @return "true" hoặc "false"
	 */
	@DELETE
	@Path("/out/{class_id}/{id}")
	@Produces("application/json; charset=UTF-8")
	public String outGroup(@PathParam("class_id") String class_id, @PathParam("id") String id) {
		return GroupDAO.outGroup(class_id, id) ? "true" : "false";
	}

	/**
	 * Phương thức xin gia nhập group hoặc lớp
	 * 
	 * @param class_id
	 *            mã group hoặc lớp
	 * @param id
	 *            mã user
	 * @return "true" hoặc "false"
	 */
	@POST
	@Path("/join/{class_id}/{id}")
	@Produces("application/json; charset=UTF-8")
	public String accedeGroup(@PathParam("class_id") String class_id, @PathParam("id") String id) {
		return GroupDAO.accedeGroup(class_id, id) ? "true" : "false";
	}

	/**
	 * Phương thức cho phép gia nhập group hoặc lớp
	 * 
	 * @param class_id
	 *            mã group hoặc lớp
	 * @param id
	 *            mã user
	 * @return "true" hoặc "false"
	 */
	@POST
	@Path("/approved/{class_id}/{id}")
	@Produces("application/json; charset=UTF-8")
	public String approvedGroup(@PathParam("class_id") String class_id, @PathParam("id") String id) {
		if (GroupDAO.outAccedeGroup(class_id, id)) {
			return GroupDAO.joinGroup(class_id, id) ? "true" : "false";
		} else {
			return "false";
		}
	}
}
