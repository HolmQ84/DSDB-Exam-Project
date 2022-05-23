package dsdb.collaborators.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnoreProperties({"person", "singers"})
    @Relationship(type = "SANG")
    private List<Role> sang = new ArrayList<>();

    @JsonIgnoreProperties({"singers", "producers", "features", "collaborators"})
    @Relationship(type = "PRODUCED")
    private List<Song> produced = new ArrayList<>();

    @JsonIgnoreProperties({"singers", "writers", "features", "collaborators"})
    @Relationship(type = "WROTE")
    private List<Song> wrote = new ArrayList<>();

    @JsonIgnoreProperties({"singers", "writers", "features", "collaborators"})
    @Relationship(type = "FEATURED")
    private List<Song> featured = new ArrayList<>();

    @JsonIgnoreProperties({"sang", "wrote", "featured", "collaborated", "produced"})
    @Relationship(type = "COLLABORATED")
    private List<Person> collaborated = new ArrayList<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

