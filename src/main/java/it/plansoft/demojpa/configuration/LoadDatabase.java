package it.plansoft.demojpa.configuration;

import it.plansoft.demojpa.model.Gender;
import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.model.UserProfile;
import it.plansoft.demojpa.repository.UserProfileRepository;
import it.plansoft.demojpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * caricamento iniziale database.
 */
//@Configuration
@Slf4j
public class LoadDatabase {


    //@Bean
    public CommandLineRunner LoadDatabaseTest(
            UserRepository userRepository,
            UserProfileRepository userProfileRepository
    ) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                userProfileRepository.deleteAllInBatch();
                userRepository.deleteAllInBatch();

                // caricamento utenti/account/ruoli
                // ..
                User user = new User("giuseppe",
                        "Giuseppe",
                        "Grosso",
                        "giuseppe.ing.grosso@gmail.com",
                        "12345678");

                UserProfile userProfile = new UserProfile(Gender.MALE,"3291148672",
                        new Date(1976, 4, 12),
                        "via Dante alighieri",
                        "firenze",
                        "Italia",
                        "50043");

                insert(user, userProfile, userRepository);

                user = new User("lorenzo",
                        "Lorenzo",
                        "Grosso",
                        "lorenzo@gmail.com",
                        "12345678");

                userProfile = new UserProfile(Gender.MALE,"zzzzz",
                        new Date(2009, 4, 5),
                        "via Dante alighieri",
                        "firenze",
                        "Italia",
                        "50043");

                insert(user, userProfile, userRepository);

                Optional<User> u = userRepository.findBySso("giuseppe");

                //System.out.println(u.get());
                //System.out.println(u.getEmail());
            }
        };


    }

    public void insert(User user, UserProfile userProfile, UserRepository userRepository) {
        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        userRepository.save(user);
        //log.info("insert userAccount {} ", userRepository.save(user));
    }


}