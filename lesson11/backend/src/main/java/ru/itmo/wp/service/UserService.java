package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.domain.User;
import ru.itmo.wp.form.RegisterRequest;
import ru.itmo.wp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByLoginAndPassword(String login, String password) {
        return login == null || password == null ? null : userRepository.findByLoginAndPassword(login, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public void writePost(User user, Post post) {
        user.addPost(post);
        userRepository.save(user);
    }

    public Boolean exists(String login) {
        return userRepository.existsByLogin(login);
    }

    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setLogin(registerRequest.getLogin());
        user.setName(registerRequest.getName());
        user.setAdmin(false);
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), user.getLogin(), registerRequest.getPassword());
        return user;
    }
}
