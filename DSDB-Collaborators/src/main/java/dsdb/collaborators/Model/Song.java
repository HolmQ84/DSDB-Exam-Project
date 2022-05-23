package dsdb.collaborators.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import java.util.ArrayList;
import java.util.List;

@Data
@Node("Song")
public class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(value = "SANG", direction = Direction.INCOMING)
    private List<Role> singers;

    @Relationship(value = "PRODUCED", direction = Direction.INCOMING)
    private List<Person> producers;

    @Relationship(value = "WROTE", direction = Direction.INCOMING)
    private List<Person> writers;

    @Relationship(value = "FEATURED", direction = Direction.INCOMING)
    private List<Person> features;

    public Song() {
    }

    public Song(String name) {
        this.name = name;
    }
}
