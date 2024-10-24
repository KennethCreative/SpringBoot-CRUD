package pers.kenneth.springbootcrud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.kenneth.springbootcrud.entity.User;
import pers.kenneth.springbootcrud.repository.UserRepository;

import java.util.List;

@SpringBootTest
class SpringBootCrudApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
