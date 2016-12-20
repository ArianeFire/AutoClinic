package au.com.riosoftware.firstapp.domain;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClientDao {
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  public void addClient( String noms,String Adresse,int telBureau,int fax,String Email,int tel) {
		  
		  Session session = sessionFactory.openSession();
	      session.beginTransaction();
		    
		    Client client = new Client(noms,Adresse,telBureau,fax,Email,tel);

		    session.save(client);
	        session.getTransaction().commit();
	        session.close();

		 }
}
