package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Produces;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.AnnounceDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.Announce;

@Path("/announce")
public class AnnounceServices {
	@GET
	@Path("/recent")
	@Produces("application/json; charset=UTF-8")
	public Announce getRecentAnnounce() {
		return AnnounceDAO.getRecentAnnounce();
	}

	@GET
	@Path("/all")
	@Produces("application/json; charset=UTF-8")
	public List<Announce> getAllAnnounce() {
		return AnnounceDAO.getAnnounceList();
	}

	@GET
	@Path("/{group_id}")
	@Produces("application/json; charset=UTF-8")
	public List<Announce> getAnnounce(@PathParam("group_id") String group_id) {
		return AnnounceDAO.getAnnounceList(group_id);
	}

	@GET
	@Path("/user/{id}")
	@Produces("application/json; charset=UTF-8")
	public List<Announce> getAnnounceForUser(@PathParam("id") String id) {
		return AnnounceDAO.getAnnounceListForUser(id);
	}

	@POST
	@Path("/add/{id}/{title}/{content}/{class_id}")
	@Produces("application/json; charset=UTF-8")
	public String insertAnnounce(@PathParam("id") String id, @PathParam("title") String title,
			@PathParam("content") String content, @PathParam("class_id") String class_id) {
		return AnnounceDAO.insertAnnounce(id, title, content, class_id) ? "Thành công" : "Thất bại";
	}
}
