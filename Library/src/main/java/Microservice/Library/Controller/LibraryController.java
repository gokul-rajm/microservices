package Microservice.Library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Microservice.Library.Entity.LibraryEntity;
import Microservice.Library.Service.LibraryService;

@RestController
@RequestMapping("/Library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@GetMapping("/name/{authorName}")
	public ResponseEntity<List<LibraryEntity>> getById(@PathVariable String authorName) {
		return libraryService.getById(authorName);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<LibraryEntity> addCitizen(@RequestBody LibraryEntity libraryEntity) {
		return libraryService.addCitizen(libraryEntity);
	}

}
