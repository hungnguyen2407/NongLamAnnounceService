package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser;

@Path("/user")
public class UserServices {
	
	/**
	 * Phương thức kiểm tra đăng nhập
	 * @param id mã user
	 * @param pass mật khẩu của user 
	 * @return "true" hoặc "false"
	 */
	@GET
	@Path("/login/{id}/{password}")
	@Produces("application/json; charset=UTF-8")
	public String login(@PathParam("id")String id, @PathParam("password")String pass) {
		return UserDAO.login(id, pass)? "true" : "false";
	}
	
	/**
	 * Phương thức lấy ra danh sách các group hoặc lớp mà 1 user tham gia
	 * @param id mã user
	 * @return List<InfoGroupOfUser>
	 */
	@GET
	@Path("/dsgroup/{id}")
	@Produces("application/json; charset=UTF-8")
	public List<InfoGroupOfUser> getdsGroup(@PathParam("id")String id) {
		return UserDAO.getdsGroupOfUser(id);
	}
	
	@PUT
	@Path("/levelupdate/{id}/{id_target}/{lv}")
	@Produces("application/json; charset=UTF-8")
	public String setLevel(@PathParam("id")String id,@PathParam("id_target")String target, @PathParam("lv")String lv) {
		return UserDAO.setLevel(id, target, lv) ? "true" : "false";
	}
	
	/**
	 * Lấy ra thông tin của user
	 * @param id
	 * @param pass
	 * @return
	 */
	@GET
	@Path("/infor/{id}")
	@Produces("application/json; charset=UTF-8")
	public InformationUser getInfoUser(@PathParam("id")String id) {
		return UserDAO.getInfoUser(id);
	}
}
