package Microservice.AuthorDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Microservice.AuthorDetails.Entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
	
	@Query("SELECT u FROM AuthorEntity u WHERE u.authorName = ?1")
	AuthorEntity findByAuthor(String authorName);

}
