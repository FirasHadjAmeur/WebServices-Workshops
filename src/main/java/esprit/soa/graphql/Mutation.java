package esprit.soa.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.soa.entities.Logement;
import esprit.soa.entities.RendezVous;
import esprit.soa.repos.LogementRepository;
import esprit.soa.repos.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
	
	private final RendezVousRepository rdp;
	private final LogementRepository lgm;
	public Mutation(RendezVousRepository rdp,LogementRepository lgm)
	{this.rdp=rdp;
	this.lgm=lgm;
	}
// RendezVous Mutation	
	public RendezVous addRdv(int id,String date,String heure,String numTel) {
		RendezVous R = new RendezVous(id,date,heure,numTel);
		rdp.addRendezVous(R);
		return R;
	}
	public RendezVous updateRdv(int id,String date,String heure,String numTel) {
		RendezVous R = new RendezVous(id,date,heure,numTel);
		rdp.updateRendezVous(R);
		return R;
	}
	public List<RendezVous> deleteRdv(int id) {
		rdp.deleteRendezVous(id);
		return rdp.getListeRendezVous();
	}

// Logement Mutation
		
	public Logement addLgm(int reference,String adresse,String gouvernorat,String description, float prix) {
		Logement L = new Logement(reference,adresse,gouvernorat,description,prix);
		lgm.saveLogement(L);
		return L;
	}
	

	
	
		
}
