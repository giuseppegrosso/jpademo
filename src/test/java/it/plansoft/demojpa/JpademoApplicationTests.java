package it.plansoft.demojpa;

import it.plansoft.demojpa.model.User;
import it.plansoft.demojpa.repository.UserRepository;
import it.plansoft.demojpa.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class JpademoApplicationTests {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JpademoApplicationTests.class);

	@Autowired
	private UserRepository repository;


	@Before
	public void initialize() {
		log.info("startup ambiente");
		loadDataBase();
	}

	protected void loadDataBase() {
		//service = new UserService(repository);
		//service.save(new User("giuseppe", "Giuseppe", "Giuseppe", "Grosso", ""));
		repository.save(new User("giuseppe", "Giuseppe", "Giuseppe", "Grosso", ""));
	}
	@After
	public void shutdown() {
		log.info("shutdown");
	}



	@Test
	public void testStandAloneRepository() throws Exception {
		Optional<User> user = this.repository.findBySso("giuseppe");
		assertEquals(user.get().getName(), "Giuseppe");
		assertEquals(user.get().getSso(), "giuseppe");
	}

}
