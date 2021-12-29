package africa.group.semicolon.jijiMoji.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("Listings")
@Data
public class Listing {
    @Id
    private String id;
    private String name;
    private String email;
    private String shortDescription;
    private String longDescription;
    private LocalDateTime dateListed = LocalDateTime.now();
    private  Conditions conditions;
    @DBRef //NON relational
    private  Lister lister;
    private String Location;
    private String type;
    private String subType;
    private int numberOfViews;
}
