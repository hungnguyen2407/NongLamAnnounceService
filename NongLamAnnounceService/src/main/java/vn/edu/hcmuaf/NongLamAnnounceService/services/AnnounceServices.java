package vn.edu.hcmuaf.NongLamAnnounceService.services;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.AnnounceDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.Announce;

@Path("/announce")
public class AnnounceServices {
	@GET
	@Path("/recent")
	@Produces("application/json; charset=UTF-8")
	public Announce getRecentAnnounce(){
		return AnnounceDAO.getRecentAnnounce();
	}
	
	@GET
	@Path("/all")
	@Produces("application/json; charset=UTF-8")
	public Announce getAllAnnounce(){
		return AnnounceDAO.getRecentAnnounce();
	}
}