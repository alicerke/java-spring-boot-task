package hu.steve.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.webshop.model.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
