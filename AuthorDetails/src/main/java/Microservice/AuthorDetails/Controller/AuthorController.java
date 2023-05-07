package Microservice.AuthorDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Microservice.AuthorDetails.Common.RequiredResponse;
import Microservice.AuthorDetails.Entity.AuthorEntity;
import Microservice.AuthorDetails.Service.AuthorService;

@RestController
@RequestMapping("/Author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/add")
	public ResponseEntity<AuthorEntity> addAuthor(@RequestBody AuthorEntity authorEntity) {
		return authorService.addAuthor(authorEntity);
	}
	
	@GetMapping("/name/{authorName}")
	public ResponseEntity<RequiredResponse> getAllAuthor(@PathVariable String authorName){
		return authorService.getAllAuthor(authorName);
		
		
		
	}

}
