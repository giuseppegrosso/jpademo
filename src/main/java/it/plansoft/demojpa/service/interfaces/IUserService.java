package it.plansoft.demojpa.service.interfaces;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.service.interfaces */

import java.util.Optional;

public interface IUserService<User> {
    Optional<User> findByEmail(String email);
    Optional<User> findBySso(String sso);
}
