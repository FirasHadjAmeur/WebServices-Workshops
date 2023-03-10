package esprit.soa.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.soa.entities.Logement;
import esprit.soa.entities.RendezVous;
import esprit.soa.repos.LogementRepository;
import esprit.soa.repos.RendezVousRepository;

public class Query implements GraphQLRootResolver {
	
	private final RendezVousRepository rdp;
	private final LogementRepository lgm;
	public Query(RendezVousRepository rdp,LogementRepository lgm)
	{this.rdp=rdp;
	this.lgm=lgm;
	}
	
	public List<RendezVous> getRdv () {
		return rdp.getListeRendezVous();
	}
	public RendezVous getRdvById(int id) {
		return rdp.getRendezVousById(id);
	}
	
	
	public List<Logement> getlogement() {
		return lgm.getAllLogements();
	}
	
	public Logement getLgmById(int ref) {
		return lgm.getLogementsByReference(ref);
	}

}
