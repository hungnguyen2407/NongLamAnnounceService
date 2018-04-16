package vn.edu.hcmuaf.NongLamAnnounceService.service;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.PostDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.Post;

@Path("/post")
public class Announce {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Post getRecentPost(){
		return PostDAO.getRecentPost();
	}
}
