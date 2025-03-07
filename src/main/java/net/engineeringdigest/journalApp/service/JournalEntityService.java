//package net.engineeringdigest.journalApp.service;
//
//import net.engineeringdigest.journalApp.entity.JournalEntity;
//import net.engineeringdigest.journalApp.entity.Users;
//import net.engineeringdigest.journalApp.repository.JournalEntityRepo;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class JournalEntityService {
//    @Autowired
//    private JournalEntityRepo journalEntityRepo;
//
//    @Autowired
//    private UserService userService;
//
//
//    public void saveEntity(JournalEntity journalEntity, String username) {
//        Users user = userService.findByUsername(username);
//        journalEntity.setDate(new java.util.Date());
//        JournalEntity saved = journalEntityRepo.save(journalEntity);
//        user.getJournalEntities().add(saved);
//        userService.saveUser(user);
//    }
//    public void saveEntity(JournalEntity journalEntity) {
//       journalEntityRepo.save(journalEntity);
//    }
//
//    public List<JournalEntity> getAllEntities() {
//        return journalEntityRepo.findAll();
//    }
//
//    public Optional<JournalEntity> getEntityById(ObjectId id) {
//        return journalEntityRepo.findById(String.valueOf(id));
//    }
//
//    public void deleteEntityById(ObjectId id, String username) {
//        Users user = userService.findByUsername(username);
//        user.getJournalEntities().removeIf(journalEntity -> journalEntity.getId().equals(id));
//        userService.saveUser(user);
//        journalEntityRepo.deleteById(String.valueOf(id));
//    }
//}
