package Microservice.AuthorDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Microservice.AuthorDetails.Common.LibraryEntity;
import Microservice.AuthorDetails.Common.RequiredResponse;
import Microservice.AuthorDetails.Entity.AuthorEntity;
import Microservice.AuthorDetails.Repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<AuthorEntity> addAuthor(AuthorEntity authorEntity) {
		AuthorEntity author = authorRepository.save(authorEntity);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	public ResponseEntity<RequiredResponse> getAllAuthor(String authorName) {
		RequiredResponse requiredResponse =  new RequiredResponse();
		AuthorEntity author  = authorRepository.findByAuthor(authorName);
		requiredResponse.setAuthor(author);
		
		List<LibraryEntity> books = restTemplate.getForObject("http://LIBRARY-SERVICE/Library/name/"+authorName, List.class);
		requiredResponse.setLibrary(books);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}
}
