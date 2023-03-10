package esprit.soa.graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import esprit.soa.repos.LogementRepository;
import esprit.soa.repos.RendezVousRepository;
import esprit.ws.graphql.Mutation;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
@WebServlet(urlPatterns = "/graph")
public class GraphEndPoint extends SimpleGraphQLServlet{

	public GraphEndPoint()
	{super(builSchema());}
	
	private static GraphQLSchema builSchema()
	{RendezVousRepository rdp=new RendezVousRepository();
	LogementRepository lgm=new LogementRepository();
		return SchemaParser.newParser()
				.file("schema.graphql")
				.resolvers(new Query(rdp,lgm),
				 new Mutation(rdp,lgm))
				.build()
				.makeExecutableSchema();
		
		
		
	}
}
