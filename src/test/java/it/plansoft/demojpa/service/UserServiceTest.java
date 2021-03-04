package it.plansoft.demojpa.service;

import it.plansoft.demojpa.AbstractTest;
import it.plansoft.demojpa.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest extends AbstractTest {
    @Autowired
    private UserService service;

    @Test
    public void testStandAloneRepository() throws Exception {
        Optional<User> user = this.service.findBySso("giuseppe");
        assertEquals(user.get().getName(), "Giuseppe");
        assertEquals(user.get().getSso(), "giuseppe");
    }


    @Override
    protected void loadDataBase() {
        service.save(new User("giuseppe", "Giuseppe", "Giuseppe", "Grosso", ""));
    }
}