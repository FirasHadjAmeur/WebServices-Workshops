package tn.esprit.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.LogementBusiness;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;

@Path("rdv")
public class RendezVousResources {

	private static RendezVousBusiness RB =new RendezVousBusiness();

	public static LogementBusiness logementMetier=new LogementBusiness();
	RendezVous r= new RendezVous(1, 
			"31-10-2015","15:30", 
			logementMetier.getLogementsByReference(4), 
			"55214078");
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListRDV() {
		if (RB.getListeRendezVous().size()!=0) {
			return Response.status(Status.OK).entity(RB.getListeRendezVous()).build();
		}
		else
			return Response.status(Status.NOT_FOUND).entity("La liste est vide").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRDV(RendezVous R) {
		if (RB.addRendezVous(R)) 
			return Response.status(Status.CREATED).entity("add successful").build();
		return Response.status(Status.NOT_FOUND).entity("Echec").build();
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("query")
	public Response getRDVbyLogREF(@QueryParam(value="refLogement") int refLogement) {
		for(RendezVous r:RB.listeRendezVous){
			if(r.getLogement().getReference()==refLogement)
				return Response.status(Status.CREATED).entity(r).build();
			}
		return Response.status(Status.NOT_FOUND).entity("Echec").build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response GetRDVbyID(@PathParam(value="id") int id ) {
		for(RendezVous r:RB.listeRendezVous){
			if(r.getId()==id)
				return Response.status(Status.OK).entity(r).build();
			}
		return Response.status(Status.NOT_FOUND).entity("Echec").build();	
	}
	@DELETE
	@Path("{id}")
	public Response deleteRDV(@PathParam(value="id") int id ) {
		for(RendezVous r:RB.listeRendezVous){
			if(r.getId()==id)
				return Response.status(Status.OK).entity(true).build();
			}
		return Response.status(Status.NOT_FOUND).entity("Echec").build();	
	}
	
	@PUT
	
	
	
}
