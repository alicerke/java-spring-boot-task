package hu.steve.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.steve.login.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
