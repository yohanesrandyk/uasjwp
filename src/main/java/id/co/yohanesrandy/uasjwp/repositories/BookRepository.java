package id.co.yohanesrandy.uasjwp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.yohanesrandy.uasjwp.entities.Book;
import id.co.yohanesrandy.uasjwp.entities.Category;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findAll();

//	@Query("SELECT * FROM books b INNER JOIN categories c ON c.id = b.category_id")
//	List<Book> findJoin();
}
