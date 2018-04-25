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
import vn.edu.hcmuaf.NongLamAnnounceService.model.RandomString;

@Path("/user")
public class UserServices {

	/**
	 * Phương thức kiểm tra đăng nhập
	 * 
	 * @param id
	 *            mã user
	 * @param pass
	 *            mật khẩu của user
	 * @return "true" hoặc "false"
	 */
	@GET
	@Path("/login/{id}/{password}")
	@Produces("application/json; charset=UTF-8")
	public String login(@PathParam("id") String id, @PathParam("password") String pass) {
		return UserDAO.login(id, pass) ? "true" : "false";
	}

	/**
	 * Phương thức lấy ra danh sách các group hoặc lớp mà 1 user tham gia
	 * 
	 * @param id
	 *            mã user
	 * @return List<InfoGroupOfUser>
	 */
	@GET
	@Path("/dsgroup/{id}")
	@Produces("application/json; charset=UTF-8")
	public List<InfoGroupOfUser> getdsGroup(@PathParam("id") String id) {
		return UserDAO.getdsGroupOfUser(id);
	}

	/**
	 * Thay đổi quyền hạn cho user
	 * 
	 * @param id
	 *            id của người thay đổi quyền
	 * @param target
	 *            id của người được thay đổi quyền
	 * @param lv
	 *            quyền hạn
	 * @return "true" hoặc "false"
	 */
	@PUT
	@Path("/levelupdate/{id}/{id_target}/{lv}")
	@Produces("application/json; charset=UTF-8")
	public String setLevel(@PathParam("id") String id, @PathParam("id_target") String target,
			@PathParam("lv") String lv) {
		return UserDAO.setLevel(id, target, lv) ? "true" : "false";
	}

	/**
	 * Lấy ra thông tin của user
	 * 
	 * @param id
	 * @param pass
	 * @return
	 */
	@GET
	@Path("/info/{id}")
	@Produces("application/json; charset=UTF-8")
	public InformationUser getInfoUser(@PathParam("id") String id) {
		return UserDAO.getInfoUser(id);
	}

	/**
	 * Phương thức thay đổi mật khẩu cho user
	 * 
	 * @param id
	 *            id của user
	 * @param old_pass
	 *            mật khẩu cũ
	 * @param new_pass
	 *            mật khẩu mới cần đổi
	 * @return "true" hoặc "false"
	 */
	@PUT
	@Path("/changepass/{id}/{old_pass}/{new_pass}")
	@Produces("application/json; charset=UTF-8")
	public String setPass(@PathParam("id") String id, @PathParam("old_pass") String old_pass,
			@PathParam("new_pass") String new_pass) {
		if (UserDAO.login(id, old_pass)) {
			return UserDAO.updatePassword(id, new_pass) ? "true" : "false";
		} else {
			return "false";
		}
	}

	/**
	 * Phương thức đổi mật khẩu mới khi user quên mật khẩu, giá trị mật khẩu mới
	 * là ngẫu nhiên và được gửi về mail cho user
	 * 
	 * @param id mã user
	 * @return "true" hoặc "false"
	 */
	@PUT
	@Path("/resetpass/{id}")
	@Produces("application/json; charset=UTF-8")
	public String resetPass(@PathParam("id") String id) {
		String new_pass = RandomString.randomString(8);//gọi ra phương thức lấy pass ngẫu nhiên
		//phương thức gửi mail về cho user
		return UserDAO.updatePassword(id, new_pass) ? "true" : "false";
	}
}
