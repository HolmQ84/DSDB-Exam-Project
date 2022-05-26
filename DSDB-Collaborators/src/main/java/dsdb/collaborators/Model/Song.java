package dsdb.collaborators.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@Data
@NodeEntity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnoreProperties({"song", "sang"})
    @Relationship(type = "SANG", direction = INCOMING)
    private List<Role> singers;

    @JsonIgnoreProperties({"sang", "produced", "wrote", "featured", "collaborated"})
    @Relationship(type = "PRODUCED", direction = INCOMING)
    private List<Person> producers = new ArrayList<>();

    @JsonIgnoreProperties({"sang", "wrote", "produced", "featured", "collaborated"})
    @Relationship(type = "WROTE", direction = INCOMING)
    private List<Person> writers = new ArrayList<>();

    @JsonIgnoreProperties({"sang", "wrote", "produced", "featured", "collaborated"})
    @Relationship(type = "FEATURED", direction = INCOMING)
    private List<Person> features = new ArrayList<>();

    public Song() {
    }

    public Song(String name) {
        this.name = name;
    }
}
