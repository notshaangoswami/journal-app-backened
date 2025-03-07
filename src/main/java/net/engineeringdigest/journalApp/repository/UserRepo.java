package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Users, String> {
 public Users findByUsername(String username);
}
