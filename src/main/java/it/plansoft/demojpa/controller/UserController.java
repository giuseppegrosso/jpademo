package it.plansoft.demojpa.controller;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.controller */

import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.repository.UserRepository;
import it.plansoft.demojpa.service.UserService;
import org.springframework.web.bind.annotation.RestController;


@RestController("/user")
public class UserController extends BaseCrudController<UserService, UserRepository, User, Long> {


    public UserController(UserService service) {
        super(service);
    }

}
