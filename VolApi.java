package api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/vols")
public class VolApi {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vol> getVols()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
		EntityManager em = emf.createEntityManager(); 
		return em.createQuery("SELECT v FROM Vol v").getResultList();
	}
	
	@GET
	@Path("{numVol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vol getVolByNumVol(@PathParam("numVol") String numVol)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
		EntityManager em = emf.createEntityManager(); 
		return (Vol) em.find(Vol.class,numVol);
	}
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vol> getSomeVolsWithParameters(@DefaultValue("") @QueryParam("departure") String villeDepart, @DefaultValue("") @QueryParam("arrival") String villeArrivee, @DefaultValue("-1") @QueryParam("departureTime") int heureDepart)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
		EntityManager em = emf.createEntityManager(); 
		Query q = em.createQuery("SELECT v FROM Vol v WHERE (v.villeDepart = ?1 OR v.villeDepart = '') AND (v.villeArrivee = ?2 OR v.villeArrivee = '') AND (v.heureDepart = ?3 OR -1)");
		q.setParameter(1, villeDepart);
		q.setParameter(2, villeArrivee);
		q.setParameter(3, heureDepart);
		return	q.getResultList();
		
	}
	
}
