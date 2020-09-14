package com.augusto.springdatabaseencryption;

import com.augusto.springdatabaseencryption.user.User;
import com.augusto.springdatabaseencryption.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EncryptionTest {

    @Autowired
    @Lazy
    private UserRepository userRepository;

    @Test
    void savedUser() {
        User user = new User(1L, "user", "user@mail.com");
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
    }

    @Test
    void getUser() {
        Optional<User> user = userRepository.findById(1L);
        assertThat(user.get()).isNotNull();
        assertThat(user.get().getName()).isEqualTo("user");
        assertThat(user.get().getEmail()).isEqualTo("user@mail.com");
    }

}
