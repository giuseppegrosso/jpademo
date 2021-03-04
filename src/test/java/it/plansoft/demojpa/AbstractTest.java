package it.plansoft.demojpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test repository
 */

public abstract class AbstractTest {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractTest.class);

    protected abstract void loadDataBase();

    @Before
    public void initialize() {
        log.info("startup ambiente");
        loadDataBase();
    }

    @After
    public void shutdown() {
        log.info("shutdown");
    }


}