package info.ali.auther;

import java.util.List;

import javax.persistence.ConstructorResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query("SELECT a from Author a where a.authId=:authId")
	public Author findFirst(@Param("authId") String authID);
	
	@Query(value = "SELECT * from AUTHOR a ORDER BY a.AUTH_ID FETCH FIRST :n ROWs ONLY", nativeQuery = true)
	public List<Author> findNAuthor(@Param("n") String n);
	
	
	@Query("SELECT a from Author a where a.name=:name")
	public Author findFirstByName(@Param("name") String name);
	
	@Override
	Page<Author> findAll(Pageable pageable);
}