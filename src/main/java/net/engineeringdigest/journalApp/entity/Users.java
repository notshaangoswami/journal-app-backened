//package net.engineeringdigest.journalApp.entity;
//
//import lombok.*;
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Document(collection = "users")
//@Data
//public class Users {
//
//    @Id
//    private ObjectId id;
//
//    @Indexed(unique = true)
//    @NonNull
//    private String username;
//    @NonNull
//    private String password;
//
//    @DBRef//works like foreign key.
//    List<JournalEntity> journalEntities =new ArrayList<>();
//
//}
