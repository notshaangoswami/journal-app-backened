package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.Users;
import net.engineeringdigest.journalApp.service.JournalEntityService;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntityService journalEntityService;
    @Autowired
    UserService userService;


    @GetMapping("{username}")
    public ResponseEntity<?> getAllEntriesOfUser(@PathVariable String username) {
        Users user = userService.findByUsername(username);
        List<JournalEntity> journalEntries = user.getJournalEntities();
        if (journalEntries != null && !journalEntries.isEmpty()) {
            return new ResponseEntity<>(journalEntries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{username}")
    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity journalEntity, @PathVariable String username) {
        try {
            journalEntityService.saveEntity(journalEntity, username);
            return new ResponseEntity<>(journalEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntity> getJournalEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntity> journalEntity = journalEntityService.getEntityById(myId);
        return journalEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("id/{username}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String username) {
        journalEntityService.deleteEntityById(myId, username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{username}/{myId}")
    public ResponseEntity<JournalEntity> updateJournalEntityById(@PathVariable ObjectId myId,
                                                                 @RequestBody JournalEntity newEntry,
                                                                 @PathVariable String username) {
        JournalEntity old = journalEntityService.getEntityById(myId).orElse(null);
        if (old != null && newEntry != null) {

            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());

            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntityService.saveEntity(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
