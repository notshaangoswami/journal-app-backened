package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveUser(Users user) {;
        userRepo.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<Users> getUserById(ObjectId id) {
        return userRepo.findById(String.valueOf(id));
    }

    public void deleteUSerById(ObjectId id) {
        userRepo.deleteById(String.valueOf(id));
    }
    public Users findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
