package de.tekup.summer.project.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreType;


import de.tekup.summer.project.model.client;

import de.tekup.summer.project.service.ServiceClient;



@RestController
@RequestMapping("/api/client")
@JsonIgnoreType
public class ClientController {
	
	@Autowired
	private final ServiceClient Service;
	
	
	



	public ClientController(ServiceClient clientrSer) {
		super();
		Service = clientrSer;
	}


	@PostMapping("/add")
	public ResponseEntity<client> addclient( @RequestBody client client) throws Exception {
		String emailREquest=client.getEmail();
		if(emailREquest!=null&& !emailREquest.equals("")) {
			client clientInTest=Service.findAllByEmail(emailREquest);
			if(clientInTest!=null)
			throw new Exception("email already exist");
		}
		
		
		client c=Service.save(client);
		
		
		return new ResponseEntity<client>(c,HttpStatus.OK);
	}

	
	
	
	
	
	
	
	
		@PostMapping("/login")
		public ResponseEntity<client> login (@RequestBody client client) throws Exception {
			String EmailCL=client.getEmail();
			String Paswwordcl=client.getPassword();
			client clientCon=null;
			if(EmailCL!=null && Paswwordcl!=null) {
			clientCon=Service.findAllByEmailAndPassword(EmailCL, Paswwordcl);
			}
			if(clientCon==null) {
				throw new Exception("bad connection");
			}
			return new ResponseEntity<client>(clientCon,HttpStatus.OK);
		}
		
		@GetMapping("/find/{id}")
		public ResponseEntity<client> login (@RequestBody client client,@PathVariable("id")int id)  {
        client c=Service.getclient(id);
        return new ResponseEntity<client>(c,HttpStatus.OK);
		}
}
