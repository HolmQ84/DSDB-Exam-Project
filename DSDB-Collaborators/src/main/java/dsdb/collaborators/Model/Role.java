package dsdb.collaborators.Model;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RelationshipEntity(type = "SANG")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private List<String> roles = new ArrayList<>();

    @StartNode
    private Person person;

    @EndNode
    private Song song;

}
