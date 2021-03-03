package it.plansoft.demojpa.controller;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.controller */

import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.model.UserProfile;
import it.plansoft.demojpa.repository.UserRepository;
import it.plansoft.demojpa.service.UserProfileService;
import it.plansoft.demojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController extends BaseCrudController<UserService, UserRepository, User, Long> {

    @Autowired
    private UserProfileService userProfileService;

    public UserController(UserService service) {
        super(service);
    }



}
