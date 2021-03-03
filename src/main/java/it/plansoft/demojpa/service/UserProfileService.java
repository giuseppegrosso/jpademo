package it.plansoft.demojpa.service;/* ggrosso created on 03/03/2021 inside the package - it.plansoft.demojpa.service */

import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.model.UserProfile;
import it.plansoft.demojpa.repository.UserProfileRepository;
import it.plansoft.demojpa.service.interfaces.IUserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends BaseCrudService<UserProfileRepository, UserProfile, Long> implements IUserProfileService<User> {
    public UserProfileService(UserProfileRepository userProfileRepository) {
        super(userProfileRepository);
    }

}
