package au.com.riosoftware.firstapp.domain;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Fiche")
public class ficheController {

  @Autowired
  private ficheDao _ficheDao;
  private AssuranceDao _assurancedao;

  @RequestMapping(value="/listfiche/{assurancename}", method=RequestMethod.GET)
  public List<fiche> listAllfiche(@PathVariable("assurancename")String assurancename) {
	  
	  List<fiche> users = _ficheDao.getAllFiche(assurancename);
      for(int i=0;i<users.size();i++){
         System.out.println(users.get(i).getName());
      }
      return users;
  }
  public String createFiche(String ficheName , String assuranceName,Véhicule véhicule,Client client,String etat){
	  try {
	      _ficheDao.addFiche(ficheName,assuranceName,véhicule,client,etat);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "fiche succesfully saved!";
  }

} // class ficheController
