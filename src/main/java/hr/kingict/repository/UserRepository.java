package hr.kingict.repository;

import hr.kingict.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A Spring repository interface which works with User entities
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
