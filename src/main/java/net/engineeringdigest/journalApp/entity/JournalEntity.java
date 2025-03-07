package net.engineeringdigest.journalApp.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "journal_Entities")
@Data
@NoArgsConstructor
public class JournalEntity {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private Date date;

}
