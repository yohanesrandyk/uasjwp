package id.co.yohanesrandy.uasjwp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.yohanesrandy.uasjwp.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	List<Category> findAll();
}
