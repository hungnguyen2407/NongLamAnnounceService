package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Produces;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.AnnounceDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.Announce;

@Path("/announce")
public class AnnounceServices {

	/**
	 * Phương thức lấy ra bài đăng mới nhất
	 * 
	 * @return Announce
	 */
	@GET
	@Path("/recent")
	@Produces("application/json; charset=UTF-8")
	public Announce getRecentAnnounce() {
		return AnnounceDAO.getRecentAnnounce();
	}

	/**
	 * Phương thức lấy toàn bộ bài đăng
	 * 
	 * @return List<Announce>
	 */
	@GET
	@Path("/all")
	@Produces("application/json; charset=UTF-8")
	public List<Announce> getAllAnnounce() {
		return AnnounceDAO.getAnnounceList();
	}

	/**
	 * Phương thức lấy toàn bộ bài đăng trong 1 group
	 * 
	 * @param group_id
	 *            mã group hoặc mã lớp
	 * @return List<Announce>
	 */
	@GET
	@Path("/{group_id}")
	@Produces("application/json; charset=UTF-8")
	public List<Announce> getAnnounce(@PathParam("group_id") String group_id) {
		return AnnounceDAO.getAnnounceList(group_id);
	}

	/**
	 * Phương thức lấy toàn bộ bài đăng của 1 user
	 * 
	 * @param id
	 * @return List<Announce>
	 */
	@GET
	@Path("/user/{id}")
	@Produces("application/json; charset=UTF-8")
	public List<Announce> getAnnounceForUser(@PathParam("id") String id) {
		return AnnounceDAO.getAnnounceListForUser(id);
	}

	/**
	 * Phương thức thêm bài đăng
	 * 
	 * @param id
	 *            mã user đăng bài
	 * @param title
	 *            tiêu đề bài đăng
	 * @param content
	 *            nội dung bài đăng
	 * @param class_id
	 *            mã lớp hoặc mã group mà sẽ hiển thị bài đăng
	 * @return "Thành công" hoặc "Thất bại"
	 */
	@POST
	@Path("/add/{id}/{title}/{content}/{class_id}/{url_img}")
	@Produces("application/json; charset=UTF-8")
	public String insertAnnounce(@PathParam("id") String id, @PathParam("title") String title,
			@PathParam("content") String content, @PathParam("class_id") String class_id, @PathParam("url_img") String url_img) {
		return AnnounceDAO.insertAnnounce(id, title, content, class_id, url_img) ? "true" : "false";
	}

	@DELETE
	@Path("/del/{post_id}")
	@Produces("application/json; charset=UTF-8")
	public String deleteAnnounce(@PathParam("post_id") String post_id) {
		return AnnounceDAO.deleteAnnounce(post_id) ? "true" : "false";
	}

	@PUT
	@Path("/update/{post_id}/{title}/{content}/{url_img}")
	@Produces("application/json; charset=UTF-8")
	public String updateAnnounce(@PathParam("post_id") String post_id, @PathParam("title") String title,
			@PathParam("content") String content, @PathParam("url_img") String url_img) {
		return AnnounceDAO.updateAnnounce(post_id, title, content, url_img) ? "true" : "false";
	}
}
