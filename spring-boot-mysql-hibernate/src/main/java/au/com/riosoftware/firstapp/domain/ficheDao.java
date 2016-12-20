package au.com.riosoftware.firstapp.domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ficheDao {
  @Autowired
  private SessionFactory sessionFactory;
  
  
  public void saveFiche(fiche fiche) {
	  Session session = sessionFactory.openSession();
	  session.save(fiche);
    return;
  }
  
  public void deleteFiche(fiche fiche) {
	  Session session = sessionFactory.openSession();
	  session.delete(fiche);
	    return;
	  }
  
  public void addFiche(String ficheName , String assuranceName,Véhicule véhicule,Client client,String etat) {
	  
	  Session session = sessionFactory.openSession();
      session.beginTransaction();

	    Assurance assurance =(Assurance)
	    		session
	            .createQuery("select p from Assurance p left join fetch p.fiches where p.Name = :pid")
	            .setParameter("pid", assuranceName)
	           .uniqueResult(); 
	    
	    fiche fiche= new fiche(ficheName,assurance,véhicule,client,etat); 
	    
	    assurance.getFiches().add(fiche);
	    session.save(assurance);
	    session.save(fiche);
        session.getTransaction().commit();
        session.close();

	 }
 
  public List<fiche> getAllFiche(String assuranceName) {
	  Session session = sessionFactory.openSession();
	  Assurance assurance =(Assurance)
			 session
			  .createQuery("select p FROM Assurance p LEFT JOIN FETCH  p.fiches WHERE p.Name= :pid")
			  .setParameter("pid", assuranceName)
	           .uniqueResult(); // Eager fetch the collection so we can use it detached 
	  return  new ArrayList<fiche>(assurance.getFiches());
	  
	 }
  ////////////////////////////////
  public List<fiche> getAllArchive(String assuranceName){
	  Session session = sessionFactory.openSession();
	  Assurance assurance =(Assurance)
				 session
				  .createQuery("select p FROM Assurance p LEFT JOIN FETCH  p.fiches WHERE p.Name= :pid")
				  .setParameter("pid", assuranceName)
		           .uniqueResult();
	  return  new ArrayList<fiche>(assurance.getFiches());
  }
 public List<fiche> getAllIncomplete(String assuranceName){
	 Session session = sessionFactory.openSession();
	  Assurance assurance =(Assurance)
				 session
				  .createQuery("select p FROM Assurance p LEFT JOIN FETCH  p.fiches WHERE p.Name= :pid")
				  .setParameter("pid", assuranceName)
		           .uniqueResult();
	  return  new ArrayList<fiche>(assurance.getFiches());
  }
 public List<fiche> getAllEncours(String assuranceName){
	 Session session = sessionFactory.openSession();
	  Assurance assurance =(Assurance)
				 session
				  .createQuery("select p FROM Assurance p LEFT JOIN FETCH  p.fiches WHERE p.Name= :pid")
				  .setParameter("pid", assuranceName)
		           .uniqueResult();
	  return  new ArrayList<fiche>(assurance.getFiches());
 }
  ///////////////////////////////////
 /* public void deleted(String  assuranceName) {
	  Session session = sessionFactory.openSession();
	     Query query =session.createSQLQuery("DELETE FROM assurance_fiche WHERE fiche_name="+assuranceName);
	     query.executeUpdate();
	  fiche fiche = (fiche) session.get(fiche.class, assuranceName);
	  session.delete(fiche);
	 }
 */
} // class FicheDao
