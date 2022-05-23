package dsdb.collaborators.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("Person")
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(value = "SANG")
    private List<Role> sang;

    @Relationship(value = "PRODUCED")
    private List<Song> produced;

    @Relationship(value = "WROTE")
    private List<Song> wrote;

    @Relationship(value = "FEATURED")
    private List<Song> featured;

    @Relationship(value = "COLLABORATED")
    private List<Person> collaborated;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

