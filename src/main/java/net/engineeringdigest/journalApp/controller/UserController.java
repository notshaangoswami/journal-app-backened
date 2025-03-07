//package net.engineeringdigest.journalApp.controller;
//
//
//import net.engineeringdigest.journalApp.entity.Users;
//import net.engineeringdigest.journalApp.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/users")
//
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//
//    @GetMapping
//    public ResponseEntity<Users> getAll() {
//        List<Users> allUsers = userService.getAllUsers();
//        if (allUsers != null && !allUsers.isEmpty()) {
//
//            return new ResponseEntity(allUsers, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping
//    public ResponseEntity<Users> createUser(@RequestBody Users user) {
//        try {
//            userService.saveUser(user);
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("{myId}")
//    public ResponseEntity<Users> getUserById(@PathVariable ObjectId myId) {
//        Optional<Users> user = userService.getUserById(myId);
//        return user.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @DeleteMapping("{myId}")
//    public ResponseEntity<?> deleteUserById(@PathVariable ObjectId myId) {
//        userService.deleteUSerById(myId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("{username}")
//    public ResponseEntity<Users> updateUser(@RequestBody Users newUser, @PathVariable String username) {
//        Users old = userService.findByUsername(username);
//        if (old != null && newUser != null) {
//
//            old.setPassword(newUser.getPassword() != null && !newUser.getPassword().equals("") ? newUser.getPassword() : old.getPassword());
//
//            old.setUsername(newUser.getUsername() != null && !newUser.getUsername().equals("") ? newUser.getUsername() : old.getUsername());
//            userService.saveUser(old);
//            return new ResponseEntity<>(old, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//}
