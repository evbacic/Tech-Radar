package hr.kingict.repository;

import hr.kingict.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Spring repository interface which works with Category entities
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
