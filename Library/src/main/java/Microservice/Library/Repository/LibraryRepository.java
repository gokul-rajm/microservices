package Microservice.Library.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Microservice.Library.Entity.LibraryEntity;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {

	@Query("SELECT u FROM LibraryEntity u WHERE u.authorName = ?1")
	List<LibraryEntity> findByAuthor(String authorName);

}
