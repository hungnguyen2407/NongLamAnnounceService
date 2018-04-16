package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Produces;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.PostDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.Post;

@Path("/announce")
@Encoded
public class AnnounceServices {
	@GET
	@Produces("application/json; charset=UTF-8")
	public Post getRecentPost(){
		return PostDAO.getRecentPost();
	}
}
