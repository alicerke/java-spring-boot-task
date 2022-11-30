package hu.steve.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.steve.login.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
