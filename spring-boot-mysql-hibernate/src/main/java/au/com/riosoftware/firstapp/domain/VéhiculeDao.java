package au.com.riosoftware.firstapp.domain;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class VéhiculeDao {

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  
	  public void saveVéhicule(Véhicule véhicule) {
		  Session session = sessionFactory.openSession();
		  session.save(véhicule);
	    return;
	  }
	  
	  public void deleteVéhicule(Véhicule véhicule) {
		  Session session = sessionFactory.openSession();
		  session.delete(véhicule);
		    return;
		  }
	  public void addVéhicule(String marque , String Modéle,String immatriculation,int NumChassais,String kilométrage,String nivcarburant) {
		  
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		    
		    Véhicule véhicule = new Véhicule(marque ,Modéle,immatriculation,NumChassais,kilométrage,nivcarburant);

		    session.save(véhicule);
	        session.getTransaction().commit();
	        session.close();

		 }
	 
	/*  public List<fiche> getAllFiche(String assuranceName) {
		  Session session = sessionFactory.openSession();
		  Assurance assurance =(Assurance)
				 session
				  .createQuery("select p FROM Assurance p LEFT JOIN FETCH  p.fiches WHERE p.Name= :pid")
				  .setParameter("pid", assuranceName)
		           .uniqueResult(); // Eager fetch the collection so we can use it detached 
		  return  new ArrayList<fiche>(assurance.getfiche());
		  
		 }
	  
	  public void deleted(String  assuranceName) {
		  Session session = sessionFactory.openSession();
		     Query query =session.createSQLQuery("DELETE FROM assurance_fiche WHERE fiche_name="+assuranceName);
		     query.executeUpdate();
		  fiche fiche = (fiche) session.get(fiche.class, assuranceName);
		  session.delete(fiche);
		 }
*/
}//class vehiculedao
