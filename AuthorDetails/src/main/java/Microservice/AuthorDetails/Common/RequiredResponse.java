package Microservice.AuthorDetails.Common;

import java.util.List;
import Microservice.AuthorDetails.Entity.AuthorEntity;

public class RequiredResponse {
	
	private AuthorEntity author;
	private List<LibraryEntity> library;
	
	public AuthorEntity getAuthor() {
		return author;
	}
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	public List<LibraryEntity> getLibrary() {
		return library;
	}
	public void setLibrary(List<LibraryEntity> library) {
		this.library = library;
	}
}

