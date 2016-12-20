package au.com.riosoftware.firstapp.domain;

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

public class AssuranceDao {
	 @Autowired
	 private SessionFactory sessionFactory;
	  
	 public List<Assurance> getAllAssurances() {
		  // Retrieve session from Hibernate
		  Session session = sessionFactory.getCurrentSession();
		  // Create a Hibernate query (HQL)
		  Query query = session.createQuery("FROM Assurance");
		  // Retrieve all
		  return  query.list();
		 }
	 public void addAssurance(Assurance assurance) {
		  // Retrieve session from Hibernate
		  Session session = sessionFactory.getCurrentSession();
		  // Persists to db
		  session.save(assurance);
		 }
	/* public void deleteAssurance(String name) {
		  // Retrieve session from Hibernate
		  Session session = sessionFactory.getCurrentSession();
		  // Create a Hibernate query (HQL)
		  Query query =session.createQuery("FROM Assurance as p LEFT JOIN FETCH  p.fiches WHERE p.Name="+name);
		  // Retrieve record
		  Assurance assurance = (Assurance) (query).uniqueResult();
		  Set<fiche> fiches =assurance.getfiche();
		  // Delete person
		  session.delete(assurance);
		  // Delete associated credit cards
		  for (fiche fiche: fiches) {
		   session.delete(fiche);
		  }
		 }*/

}
