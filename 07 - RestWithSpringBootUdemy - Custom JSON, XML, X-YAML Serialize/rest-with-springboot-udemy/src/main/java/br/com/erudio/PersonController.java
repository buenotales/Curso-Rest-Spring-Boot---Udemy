package br.com.erudio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;

	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml" } )
	public List<PersonVO> findByAll () {
		
		return services.findAll();
	}

	//@GetMapping("/{id}")
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces = {"application/json", "application/xml", "application/x-yaml" } )
	public PersonVO findById (@PathVariable("id") Long id) {
		
		return services.findById(id);
	}
	
	//PostMapping
	@RequestMapping(method=RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml", "application/x-yaml" })
	public PersonVO create (@RequestBody PersonVO person) {
		
		return services.create(person);
	}
	
	//PutMapping
	@RequestMapping(method=RequestMethod.PUT, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml", "application/x-yaml" })
	public PersonVO update (@RequestBody PersonVO person) {
		
		return services.update(person);
	}

	//DeleteMapping("/{id}")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete (@PathVariable("id") Long id) {
		
		services.delete(id);
		
		return ResponseEntity.ok().build();
	}
	
	
}
