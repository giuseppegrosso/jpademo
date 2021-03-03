package it.plansoft.demojpa.repository;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.repository */

import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByNazione(String nazione);
}
