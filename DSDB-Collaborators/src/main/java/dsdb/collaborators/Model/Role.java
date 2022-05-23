package dsdb.collaborators.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RelationshipProperties
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship
    private List<String> roles = new ArrayList<>();

    @TargetNode
    private Person person;

    @TargetNode
    private Song song;
}
