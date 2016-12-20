package au.com.riosoftware.firstapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/Véhicule")

public class VéhiculeController {

	  @Autowired
	  private VéhiculeDao _véhiculeDao;
	  
	  @RequestMapping(value="/saveVéhicule/{marque}/{Modéle}/{immatriculation}/{NumChassais}/{kilométrage}/{nivcarburant}")
	  public String createVéhicule(@PathVariable("marque")String marque , @PathVariable("Modéle")String Modéle,@PathVariable("immatriculation")String immatriculation,@PathVariable("NumChassais")int NumChassais,@PathVariable("kilométrage")String kilométrage,@PathVariable("nivcarburant")String nivcarburant) {
	    try {
	      _véhiculeDao.addVéhicule(marque ,Modéle,immatriculation,NumChassais,kilométrage,nivcarburant);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Véhicule succesfully saved!";
	  }
}
