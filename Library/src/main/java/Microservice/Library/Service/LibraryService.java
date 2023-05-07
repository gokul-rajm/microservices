package Microservice.Library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Microservice.Library.Entity.LibraryEntity;
import Microservice.Library.Repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;

	public ResponseEntity<List<LibraryEntity>> getById(String authorName) {
		List<LibraryEntity> listCitizen = libraryRepository.findByAuthor(authorName);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}

	public ResponseEntity<LibraryEntity> addCitizen(LibraryEntity libraryEntity) {
		LibraryEntity library = libraryRepository.save(libraryEntity);
		return new ResponseEntity<>(library, HttpStatus.OK);
	}

}
