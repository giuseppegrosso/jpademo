package it.plansoft.demojpa.service;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.service */

import java.util.Optional;

import org.springframework.stereotype.Service;

import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.repository.UserRepository;
import it.plansoft.demojpa.service.interfaces.IUserService;

@Service
public class UserService extends BaseCrudService<UserRepository, User, Long> implements IUserService<User> {

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Optional<User> findBySso(String sso) {
        return ((UserRepository)repository).findBySso(sso);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return ((UserRepository)repository).findByEmail(email);
    }
}
