package com.masteraggregator.service;

import com.masteraggregator.entity.User;
import com.masteraggregator.exception.UserNotFoundException;
import com.masteraggregator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteUser(Long id){
        User user = getById(id);
        repo.delete(user);
    }
}
