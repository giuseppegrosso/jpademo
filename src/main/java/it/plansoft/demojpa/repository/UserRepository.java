package it.plansoft.demojpa.repository;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.repository */

import it.plansoft.demojpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>  findBySso(String sso);

    Optional<User> findByEmail(String email);
}
