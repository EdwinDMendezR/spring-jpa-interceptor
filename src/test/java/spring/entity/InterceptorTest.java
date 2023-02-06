package spring.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {})
//@ActiveProfiles("entity-person")
@AutoConfigureMockMvc
public class InterceptorTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void methodTest() {
        Person person = new Person();
        person.setName("name");
        person.setLastName("lastName");
        repository.save(person);
    }


}
