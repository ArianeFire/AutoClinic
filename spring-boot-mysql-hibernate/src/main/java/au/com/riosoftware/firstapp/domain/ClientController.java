package au.com.riosoftware.firstapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/Client")
public class ClientController {

	  @Autowired
	  private ClientDao ClientDao;
	  
	  @RequestMapping(value="/saveClient/{nom}/{Adresse}/{telBureau}/{fax}/{Email}/{tel}")
	  public String createVéhicule(@PathVariable("nom") String nom,@PathVariable("Adresse")String Adresse,@PathVariable("telBureau")int telBureau,@PathVariable("fax")int fax,@PathVariable("Email")String Email,@PathVariable("tel")int tel) {
	    try {
	      ClientDao.addClient(nom,Adresse,telBureau,fax,Email,tel);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Client succesfully saved!";
	  }
}
