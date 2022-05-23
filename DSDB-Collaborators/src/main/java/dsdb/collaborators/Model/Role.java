package dsdb.collaborators.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"sang", "produced", "wrote", "featured"})
    private Person person;

    @EndNode
    @JsonIgnoreProperties({"sang", "collaborated", "wrote", "featured", "collaborators"})
    private Song song;

}
