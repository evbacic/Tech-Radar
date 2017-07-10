package hr.kingict.repository;

import hr.kingict.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by emil-vid.bacic on 27.6.2017..
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
