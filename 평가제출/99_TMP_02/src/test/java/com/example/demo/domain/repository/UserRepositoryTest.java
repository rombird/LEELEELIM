package com.example.demo.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void t1() throws Exception{
        User user = User.builder()
                .username("user1")
                .password("1234")
                .role("ROLE_USER")
                .build();
        userRepository.save(user);
    }

    @Test
    public void t2() throws Exception{
//        List<User> list =  userRepository.selectByRole("ROLE_USER");
//        list.stream().forEach(System.out::println);

        List<User> list =  userRepository.selectAllLikeUsername("1");
        list.stream().forEach(System.out::println);

    }
}