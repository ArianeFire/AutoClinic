package au.com.riosoftware.firstapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Assurance")
public class AssuranceController {
	@Autowired
	private AssuranceDao  assurancedao;
	private ficheDao fichedao;
	
	  @RequestMapping(value="/saveAssurance")
	  @ResponseBody
	  public String createAssurance(String name) {
	    try {
	      Assurance assurance=new Assurance(name);
	      assurancedao.addAssurance(assurance);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Assurance succesfully saved!";
	  }
	  
	    @RequestMapping(value="/listAssurance", method=RequestMethod.GET)
	    public List<Assurance> listAllAssurances() {
	        List<Assurance> Assurances = assurancedao.getAllAssurances();
	        for(int i=0;i<Assurances.size();i++){
	           System.out.println(Assurances.get(i).getName());
	        }
	        return Assurances;
	    }
}
